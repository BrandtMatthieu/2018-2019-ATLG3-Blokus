package esi.atl.g44422.model;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * Represents a board in the game.
 */
public class Board extends GridPane {

    /**
     * The x size of the board.
     */
    private final int sizeX;

    /**
     * The y size of the board.
     */
    private final int sizeY;

    /**
     * All the pieces put on the board since the beginning.
     */
    private final ArrayList<Piece> piecesPut;

    /**
     * Creates a new board.
     *
     * @param sizeX the horizontal size of the board
     * @param sizeY the vertical size of the board
     */
    Board(final int sizeX, final int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.piecesPut = new ArrayList<>();
    }

    /**
     * Returns the horizontal size of the board. {@link Board#sizeX}
     *
     * @return the horizontal size of the board
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * Returns the vertical size of the board. {@link Board#sizeY}
     *
     * @return the vertical size of the board
     */
    public int getSizeY() {
        return sizeY;
    }

    /**
     * Returns a list with the pieces already put on the board.
     * {@link Board#piecesPut}
     *
     * @return a list with the pieces already put on the board
     */
    public ArrayList<Piece> getPiecesPut() {
        return new ArrayList<>(this.piecesPut);
    }

    /**
     * Puts a piece on the board.
     *
     * @param piece the piece that has to be put
     * @param position the position where the piece has to be put
     */
    void put(final Piece piece, final Position position) {
        piece.setPosition(position);
        this.piecesPut.add(piece);
    }
    
    /**
     * Removes the piece put on the board.
     * @param piece the piece to remove from the board
     */
    void removePiece(Piece piece) {
        this.piecesPut.remove(piece);
    }

    /**
     * Checks if the piece is out of bounds of the board at tha position.
     *
     * @param piece the piece to check
     * @param pos the position of the piece
     * @return if the piece is out of bounds of the board at tha position
     */
    boolean isOutOfBounds(final Piece piece, final Position pos) {
        if (piece == null || pos == null) {
            return true;
        }
        return !(pos.getX() >= 0
                && (pos.getX() + piece.getShape().getSizeX() - 1) < this.getSizeX()
                && pos.getY() >= 0
                && (pos.getY() + piece.getShape().getSizeY() - 1) < this.getSizeY());
    }

    /**
     * Checks if the piece overlaps another piece already put on the board.
     *
     * @param selectedPiece the piece we want to put on the board
     * @param selectedPiecePosition the position we want to put the piece to
     * @return if the piece overlaps another piece already put on the board
     */
    boolean overlapsOtherPiece(final Piece selectedPiece, final Position selectedPiecePosition) {
        for (Piece otherBoardPiece : this.getPiecesPut()) {
            for (Position otherBoardPieceCell : otherBoardPiece.getShape().getCells()) {
                for (Position selectedPieceCell : selectedPiece.getShape().getCells()) {
                    if (Position.equals(
                            Position.add(selectedPieceCell, selectedPiecePosition),
                            Position.add(otherBoardPieceCell, otherBoardPiece.getPosition()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the piece touches another piece of the same player by one of
     * it's corners.
     *
     * @param piece the piece we want to put on the board
     * @param pos the position we want to put the piece on the board
     * @return if the piece touches another piece of the same player by one of
     * it's corners
     */
    boolean touchesSamePlayerPieceByCorner(final Piece piece, final Position pos) {
        for (Piece piecePut : piece.getOwner().getPiecesPut()) {
            for (Position cellPiecePut : piecePut.getShape().getCells()) {
                for (Position cell : piece.getCorners()) {
                    if (Position.equals(Position.add(cell, pos), Position.add(cellPiecePut, piecePut.getPosition()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the piece touches a piece of the same player by the side.
     *
     * @param piece the piece we want to put on the board
     * @param pos the position we want to put the piece on the board
     * @return if the piece touches a piece of the same player by the side
     */
    boolean touchesSamePlayerBySide(final Piece piece, final Position pos) {
        for (Piece piecePut : piece.getOwner().getPiecesPut()) {
            for (Position cellPiecePut : piecePut.getShape().getCells()) {
                for (Position cell : piece.getShape().getCells()) {
                    if (Position.dist(Position.add(cellPiecePut, piecePut.getPosition()), Position.add(cell, pos)) == 1.0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if it's the first piece put by the player and if it touches one of
     * the corner of the board.
     *
     * @param piece the piece we want to put on the board
     * @param pos the position we want to put the piece on the board
     * @return if it's the first piece put by the player and if it touches one
     * of the corner of the board
     */
    boolean firstPiecePlayerTouchesBoardCorner(final Piece piece, final Position pos) {
        for (Position cell : piece.getShape().getCells()) {
            if (Position.equals(Position.add(cell, pos), new Position(0, 0))
                    || Position.equals(Position.add(cell, pos), new Position(0, this.getSizeY() - 1))
                    || Position.equals(Position.add(cell, pos), new Position(this.getSizeX() - 1, this.getSizeY() - 1))
                    || Position.equals(Position.add(cell, pos), new Position(this.getSizeX() - 1, 0))) {
                return true;
            }
        }
        return false;
    }
}
