package esi.atl.g44422.model;

import esi.atl.g44422.util.Observer;

import java.util.ArrayList;

/**
 * Represents a game of Blokus.
 */
public class Game implements GameInterface {
	/**
	 * The horizontal size of the the board.
	 */
	private static final int SIZEX = 20;
	private static final int SIZEY = 20;
	private static final int numberRequiredPlayers = 4;

	private final ArrayList<Observer> observers;

	private ArrayList<Player> players;
	private Board board;
	private Player winner;
	private double turnNumber;
	private Player currentPlayer;
	private Piece selectedPiece;
	private Position selectedPosition;
	private ArrayList<String> movesHistory;

	/**
	 * Creates a new game.
	 */
	public Game() {
		this.observers = new ArrayList<>();
		this.newGame();
	}

	/**
	 * Initializes a new game.
	 */
	public void newGame() {
		this.players = new ArrayList<>();
		this.board = new Board(SIZEX, SIZEY);
		this.winner = null;
		this.turnNumber = 0.0;
		this.currentPlayer = null;
		this.selectedPiece = null;
		this.selectedPosition = null;
		this.movesHistory = new ArrayList<>();

		this.addPlayer(new Player("Human", Color.BLUE));
		this.addPlayer(new AIPlayer("BOT 1", Color.YELLOW, this));
		this.addPlayer(new AIPlayer("BOT 2", Color.RED, this));
		this.addPlayer(new AIPlayer("BOT 3", Color.GREEN, this));

		this.notifyObservers();
	}

	/**
	 * Returns the board of the game.
	 *
	 * @return the board of the game
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * Returns the winner of the game.
	 *
	 * @return the winner of the game
	 */
	public Player getWinner() {
		return this.winner;
	}

	/**
	 * Returns the turn number of the game.
	 *
	 * @return the turn number of the game
	 */
	public int getTurnNumber() {
		return (int) Math.ceil(this.turnNumber);
	}

	/**
	 * Returns the current player of the game.
	 *
	 * @return the current player of the game
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	/**
	 * Returns the piece selected by the current player.
	 *
	 * @return the piece selected by the current player
	 */
	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	/**
	 * Returns the position selected by the current player.
	 *
	 * @return the position selected by the current player
	 */
	public Position getSelectedPosition() {
		return this.selectedPosition;
	}

	/**
	 * Returns the number of required player to start the game.
	 *
	 * @return the number of required player to start the game
	 */
	public int getNumberRequiredPlayers() {
		return numberRequiredPlayers;
	}

	/**
	 * Returns a list with all the players in the game.
	 *
	 * @return a list with all the players in the game
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Adds a player into the current game.
	 *
	 * @param player the player to add to the game
	 */
	public void addPlayer(Player player) {
		if(player == null) {
			throw new IllegalArgumentException("New player cannot be null.");
		} else if(this.players.size() >= numberRequiredPlayers) {
			throw new IllegalStateException("There cannot be more than " + numberRequiredPlayers + " players.");
		} else {
			this.players.add(player);
		}
	}

	/**
	 * Starts the game.
	 */
	public void start() {
		if(this.players.isEmpty()) {
			throw new IllegalStateException("Cannot begin the game without any player");
		} else if(this.players.size() != numberRequiredPlayers) {
			throw new IllegalStateException("Cannot begin the game when there is not enough players");
		} else {
			this.currentPlayer = this.players.get(0);
		}

		while(this.getCurrentPlayer() instanceof AIPlayer && !this.isDone()) {
			this.getCurrentPlayer().play();
		}

		this.notifyObservers();
	}

	/**
	 * Checks if the game is done.
	 *
	 * @return if the game is done
	 */
	public boolean isDone() {
		boolean isOver = true;
		for(Player player : this.getPlayers()) {
			isOver = isOver && player.hasSkipped();
			if(player.getStock().isEmpty()) {
				this.movesHistory.add(this.currentPlayer.getNickname() + "\t won the game");
				return true;
			}
		}
		if(isOver) {
			this.movesHistory.add(this.currentPlayer.getNickname() + "\t won the game");
		}
		return isOver;
	}

	/**
	 * Sets the selected piece for the current player.
	 *
	 * @param piece the piece selected by the current player
	 */
	public void currentPlayerSelectsPiece(Piece piece) {
		this.selectedPiece = piece;
		this.notifyObservers();
	}

	/**
	 * Sets the selected position for the current player.
	 *
	 * @param pos the selected position by the current player
	 */
	public synchronized void currentPlayerSetsPosition(Position pos) {
		this.selectedPosition = pos;
		if((selectedPiece != null) && (!(this.currentPlayer instanceof AIPlayer))) {
			currentPlayerPutsPiece();
		}
	}

	/**
	 * Tests if the selected piece can be put at the selected position.
	 *
	 * @return true if the selected piece can be put at the selected position
	 */
	public boolean canPutSelectedPiece() {
		if(this.currentPlayer.getPiecesPut().isEmpty()) {
			// if player hasn't put any pieces yet
			// the piece must be put in one of the corners
			return (!this.board.isOutOfBounds(this.selectedPiece, this.selectedPosition)
					&& !this.board.overlapsOtherPiece(this.selectedPiece, this.selectedPosition)
					&& this.board.firstPiecePlayerTouchesBoardCorner(this.selectedPiece, this.selectedPosition)
			);
		} else {
			// the piece can but put anywhere where it touches another piece of the same player
			return (!this.board.isOutOfBounds(this.selectedPiece, this.selectedPosition)
					&& !this.board.overlapsOtherPiece(this.selectedPiece, this.selectedPosition)
					&& this.board.touchesSamePlayerPieceByCorner(this.selectedPiece, this.selectedPosition)
					&& !this.board.touchesSamePlayerBySide(this.selectedPiece, this.selectedPosition)
			);
		}
	}

	/**
	 * Puts the selected piece at the selected position on the board.
	 */
	public void currentPlayerPutsPiece() {
		if(canPutSelectedPiece() && this.getCurrentPlayer().getStock().contains(this.selectedPiece)) {
			this.board.put(this.selectedPiece, this.selectedPosition);
			this.currentPlayer.putPiece(this.selectedPiece);

			this.movesHistory.add(this.currentPlayer.getNickname() + "\t added a piece for " + this.selectedPiece.getValue() + " points at " + this.selectedPosition.toString());

			this.currentPlayerEndsTurn();
			this.notifyObservers();
		}
	}

	/**
	 * Makes the current player skips his turn.
	 */
	public void currentPlayerSkips() {
		if(!this.isDone()) {

			this.movesHistory.add(this.currentPlayer.getNickname() + "\t skipped his turn");

			this.currentPlayer.skip();
			this.currentPlayerEndsTurn();
		}

		this.notifyObservers();
	}

	/**
	 * Makes the current player end his turn.
	 */
	public void currentPlayerEndsTurn() {
		if(this.isDone()) {
			for(Player player : this.getPlayers()) {
				if(this.winner == null) {
					this.winner = player;
				}
				if(player.getStock().isEmpty()) {
					player.addToScore(15);
				}
				if(!player.getPiecesPut().isEmpty()) {
					if(PieceShape.equals(player.getPiecesPut().get(player.getPiecesPut().size() - 1).getShape(), Piece.getDefaultShapes().get(0))) {
						player.addToScore(20);
					}
				}
				for(Piece piece : player.getStock()) {
					player.addToScore(0 - piece.getValue());
				}
				if(player.getScore() > this.winner.getScore()) {
					this.winner = player;
				}
			}
		} else {
			nextPlayer();
		}
		this.notifyObservers();
	}

	/**
	 * Makes the current player turn his piece.
	 */
	public void currentPlayerTurnsPiece() {
		if(this.selectedPiece != null) {
			this.selectedPiece.rotate90();
		}
		this.notifyObservers();
	}

	/**
	 * Makes the current player flip his piece.
	 */
	public synchronized void currentPlayerFlipsPiece() {
		if(this.selectedPiece != null) {
			this.selectedPiece.mirror();
		}
		this.notifyObservers();
	}

	/**
	 * Selects the next player as current player.
	 */
	private void nextPlayer() {
		this.currentPlayer = this.players.get((this.players.indexOf(this.currentPlayer) + 1) % numberRequiredPlayers);
		this.turnNumber += (double) 1 / this.getPlayers().size();
		this.selectedPiece = null;
		this.selectedPosition = null;
	}

	/**
	 * Returns the history of all moves in the game.
	 *
	 * @return an arraylist with all moves made in the game
	 */
	public ArrayList<String> getMovesHistory() {
		return new ArrayList<>(this.movesHistory);
	}

	/**
	 * Makes the AI players play.
	 */
	public synchronized void aiPlayersPlay() {
		while(this.currentPlayer instanceof AIPlayer && !this.isDone()) {
			this.currentPlayer.play();
			this.notifyObservers();
		}
	}

	/**
	 * Adds an observer to this game's component.
	 *
	 * @param obs an observer
	 */
	public void addObserver(Observer obs) {
		this.observers.add(obs);
	}

	/**
	 * Removes an observer to this game's component.
	 *
	 * @param obs an observer
	 */
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
	}

	/**
	 * Notifies all the observers attached to this object.
	 */
	public synchronized void notifyObservers() {
		for(Observer obs : observers) {
			obs.update();
		}
	}
}
