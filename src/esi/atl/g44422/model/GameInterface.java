package esi.atl.g44422.model;

import esi.atl.g44422.util.Observable;
import esi.atl.g44422.util.Observer;

import java.util.ArrayList;

/**
 * Interface of the game.
 */
public interface GameInterface extends Observable {

	/**
	 * Initializes a new game.
	 */
	void newGame();

	/**
	 * Returns the board of the game.
	 *
	 * @return the board of the game
	 */
	Board getBoard();

	/**
	 * Returns the winner of the game.
	 *
	 * @return the winner of the game
	 */
	Player getWinner();

	/**
	 * Returns the turn number of the game.
	 *
	 * @return the turn number of the game
	 */
	int getTurnNumber();

	/**
	 * Returns the current player of the game.
	 *
	 * @return the current player of the game
	 */
	Player getCurrentPlayer();

	/**
	 * Returns the piece selected by the current player.
	 *
	 * @return the piece selected by the current player
	 */
	Piece getSelectedPiece();

	/**
	 * Returns the position selected by the current player.
	 *
	 * @return the position selected by the current player
	 */
	Position getSelectedPosition();

	/**
	 * Returns the number of required player to start the game.
	 *
	 * @return the number of required player to start the game
	 */
	int getNumberRequiredPlayers();

	/**
	 * Returns a list with all the players in the game.
	 *
	 * @return a list with all the players in the game
	 */
	ArrayList<Player> getPlayers();

	/**
	 * Adds a player into the current game.
	 *
	 * @param player the player to add to the game
	 */
	void addPlayer(Player player);

	/**
	 * Starts the game.
	 */
	void start();

	/**
	 * Checks if the game is done.
	 *
	 * @return if the game is done
	 */
	boolean isDone();

	/**
	 * Sets the selected piece for the current player.
	 *
	 * @param piece the piece selected by the current player
	 */
	void currentPlayerSelectsPiece(Piece piece);

	/**
	 * Sets the selected position for the current player.
	 *
	 * @param pos the selected position by the current player
	 */
	void currentPlayerSetsPosition(Position pos);

	/**
	 * Puts the selected piece at the selected position on the board.
	 */
	void currentPlayerPutsPiece();

	/**
	 * Makes the current player skips his turn.
	 */
	void currentPlayerSkips();

	/**
	 * Makes the current player end his turn.
	 */
	void currentPlayerEndsTurn();

	/**
	 * Makes the current player turn his piece.
	 */
	void currentPlayerTurnsPiece();

	/**
	 * Makes the current player flip his piece.
	 */
	void currentPlayerFlipsPiece();

	/**
	 * Returns true if the current selected piece can be put at the current selected position.
	 */
	boolean canPutSelectedPiece();

	/**
	 * Returns the history of all moves in the game.
	 *
	 * @return an arraylist with all moves made in the game
	 */
	ArrayList<String> getMovesHistory();

	/**
	 * Makes the AI players play.
	 */
	void aiPlayersPlay();

	/**
	 * Adds an observer to this game's component.
	 *
	 * @param obs an observer
	 */
	void addObserver(Observer obs);

	/**
	 * Removes an observer to this game's component.
	 *
	 * @param obs an observer
	 */
	void removeObserver(Observer obs);
}
