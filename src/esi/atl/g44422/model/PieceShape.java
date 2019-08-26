package esi.atl.g44422.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a piece's shape in the game.
 */
public class PieceShape {

    private final ArrayList<Position> cells;

    /**
     * Creates a new PieceShape.
     *
     * @param cells the cells for the pieceShape
     */
    PieceShape(ArrayList<Position> cells) {
        this.cells = cells;
    }

    /**
     * Creates a copy of the provided shape.
     *
     * @param shape the provided shape
     */
    PieceShape(PieceShape shape) {
        this.cells = shape.cells;
    }

    /**
     * Checks if the cell is on the side of another cell.
     *
     * @param pos the position of the piece
     * @param piece the actual piece
     * @return if the cell is on the side of another cell
     */
    static boolean isOnTheSideOfOtherCell(Position pos, Piece piece) {
        for (Position cell : piece.getShape().getCells()) {
            if (Position.dist(pos, cell) != 1.0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if two shapes are equals.
     *
     * @param shape1 the first shape
     * @param shape2 the second shape
     * @return if the two shape are equals
     */
    public static boolean equals(PieceShape shape1, PieceShape shape2) {
        return Arrays.deepEquals(Piece.to2DArray(shape1), Piece.to2DArray(shape2));
    }

    /**
     * Returns the cells of the shape.
     *
     * @return the cells of the shape
     */
    public ArrayList<Position> getCells() {
        return new ArrayList<>(this.cells);
    }

    /**
     * Returns the maximum size occupied by the shape in horizontal direction.
     *
     * @return the maximum size occupied by the shape in horizontal direction
     */
    int getSizeX() {
        int maxX = 0;
        for (Position pos : this.getCells()) {
            maxX = Math.max(maxX, pos.getX());
        }
        return maxX + 1;
    }

    /**
     * Returns the maximum size occupied by the shape in vertical direction.
     *
     * @return the maximum size occupied by the shape in vertical direction
     */
    int getSizeY() {
        int maxY = 0;
        for (Position pos : this.getCells()) {
            maxY = Math.max(maxY, pos.getY());
        }
        return maxY + 1;
    }
}
