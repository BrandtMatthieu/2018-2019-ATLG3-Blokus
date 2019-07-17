package esi.atl.g44422.model;

import java.util.ArrayList;

/**
 * Represents a player in the game
 */
public class Player {
	private final String nickname;
	private final Color color;
	private final ArrayList<Piece> stock;
	private final ArrayList<Piece> piecesPut;
	private int score;
	private boolean hasSkipped;

	/**
	 * Creates a new player
	 *
	 * @param nickname the name of the player
	 * @param color    the color of the player
	 */
	public Player(String nickname, Color color) {
		this.nickname = nickname;
		this.score = 0;
		this.hasSkipped = false;
		this.color = color;
		this.stock = new ArrayList<>();
		initStock();
		this.piecesPut = new ArrayList<>();
	}

	/**
	 * Returns the name of the player
	 *
	 * @return the name of the player
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Returns the score of the player
	 *
	 * @return the score of the player
	 */
	public int getScore() {
		return score;
	}

	/**
	 * returns if the player has skipped last turn
	 *
	 * @return if the player has skipped last turn
	 */
	public boolean hasSkipped() {
		return hasSkipped;
	}

	/**
	 * Returns the color of the player
	 *
	 * @return the color of the player
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Returns the stock of the player
	 *
	 * @return the stock of the player
	 */
	public ArrayList<Piece> getStock() {
		return stock;
	}

	/**
	 * returns a list with all the pieces put by the player
	 *
	 * @return a list with all the pieces put by the player
	 */
	public ArrayList<Piece> getPiecesPut() {
		return piecesPut;
	}

	/**
	 * Initializes the stock of the player
	 */
	private void initStock() {
		for(PieceShape shape : Piece.getDefaultShapes()) {
			this.stock.add(new Piece(new PieceShape(shape), this));
		}
	}

	/**
	 * Puts a piece and adds this piece to the piecesPut list
	 *
	 * @param piece the piece that has been put
	 */
	void putPiece(Piece piece) {
		this.piecesPut.add(piece);
		this.score += piece.getValue();
		this.stock.remove(piece);
	}

	/**
	 * Makes the player skip
	 */
	void skip() {
		this.hasSkipped = true;
	}

	/**
	 * Adds point to the player
	 *
	 * @param amount the amount of points to add
	 */
	public void addToScore(int amount) {
		this.score += amount;
	}

	/**
	 * Makes the player plays (only available for AIPlayers)
	 */
	synchronized void play() {
	}
}
