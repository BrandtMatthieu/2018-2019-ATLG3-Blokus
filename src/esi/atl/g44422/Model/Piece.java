package esi.atl.g44422.Model;

/**
 * Represents a piece in the game
 */
public class Piece {

    private boolean[][] shape;
    private int value;
    private Color color;
    private Position position;

    /**
     * Creates a new Piece in the game
     * @param shape the shape of the piece
     * @param color the color of the piece
     */
    public Piece(boolean[][] shape, Color color) {
        this.shape = shape;
        this.value = this.calculateValue();
        this.color = color;
    }

    /**
     * Returns the shape of the piece
     * @return the shape of the piece
     */
    public boolean[][] getShape() {
        return this.shape;
    }

    /**
     * Returns the value of the piece
     * @return the value of the piece
     */
    int getValue() {
        return this.value;
    }

    /**
     * Returns the color of the piece
     * @return the color of the piece
     */
    Color getColor() {
        return this.color;
    }

    /**
     * Returns the position of the piece
     * @return the position of the piece
     */
    Position getPosition() {
        return this.position;
    }

    /**
     * Calculates the value of the piece
     * @return the value of the piece
     */
    private int calculateValue() {
        int value = 0;
        for (boolean[] line : this.shape) {
            for (boolean cell : line) {
                if (cell) {
                    value++;
                }
            }
        }
        return value;
    }

    /**
     * Rotates the shape of the piece clockwise of 90°
     */
    void rotateShapeRight90() {
        // TODO
    }

    /**
     * Rotates the shape of the piece counterclockwise of 90°
     */
    void rotateShapeLeft90() {
        // TODO
    }

    /**
     * Flips the shape of the piece horizontally
     */
    void flipHorizontally() {
        // TODO
    }

    /**
     * Flips the shape of the piece vertically
     */
    void flipVertically() {
        // TODO
    }

    /**
     * ¨Puts the piece on the board
     * @param position the position the piece must be put on the board
     */
    void put(Position position) {
        this.position = position;
    }

}
