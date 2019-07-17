package esi.atl.g44422.model;

/**
 * Represents a position in the game
 */
public class Position {
	private final int x;
	private final int y;

	/**
	 * creates a new position
	 *
	 * @param x the x position
	 * @param y the y position
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Checks if two positions are the same
	 *
	 * @param pos1 the first position
	 * @param pos2 the second position
	 * @return if two positions are the same
	 */
	static boolean equals(Position pos1, Position pos2) {
		return pos1.getX() == pos2.getX() &&
				pos1.getY() == pos2.getY();
	}

	/**
	 * Adds two positions together
	 *
	 * @param pos1 the first position
	 * @param pos2 the second position
	 * @return the sum of both positions
	 */
	public static Position add(Position pos1, Position pos2) {
		return new Position(pos1.getX() + pos2.getX(), pos1.getY() + pos2.getY());
	}

	/**
	 * Returns the distance between multiple positions
	 *
	 * @param pos1 the first position
	 * @param pos2 the second position
	 * @return the distance between both positions
	 */
	public static double dist(Position pos1, Position pos2) {
		return Math.sqrt(Math.pow(pos1.getX() - pos2.getX(), 2) + Math.pow(pos1.getY() - pos2.getY(), 2));
	}

	/**
	 * Returns the x part of the position
	 *
	 * @return the x part of the position
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Returns the y part of the position
	 *
	 * @return the y part of the position
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Returns a readable string based of the position
	 *
	 * @return a readable string based of the position
	 */
	@Override
	public String toString() {
		return "(" + this.x + ";" + this.y + ")";
	}
}
