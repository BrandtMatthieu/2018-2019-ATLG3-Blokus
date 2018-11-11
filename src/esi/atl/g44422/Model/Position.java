package esi.atl.g44422.Model;

/**
 * Represents a position of a piece on the game's board
 */
public class Position {

    private int x;
    private int y;

    /**
     * Creates a new position for a piece
     * @param x the x position of the piece
     * @param y the y position of the piece
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x position of the piece
     * @return the x position of the piece
     */
    int getX() {
        return this.x;
    }

    /**
     * Returns the y position of the piece
     * @return the y position of the piece
     */
    int getY() {
        return this.y;
    }
}
