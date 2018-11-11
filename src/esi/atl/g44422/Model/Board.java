package esi.atl.g44422.Model;

import java.util.ArrayList;

/**
 * Represents a Borad in the game
 */
public class Board {

    private int HSIZE;
    private int VSIZE;
    private ArrayList<ArrayList<Color>> board;

    /**
     * Creates a new Board for the game
     * @param HSIZE the horizontal size of the board, in cells
     * @param VSIZE the vertical size of the board, in cells
     */
    Board(int HSIZE, int VSIZE) {
        this.HSIZE = HSIZE;
        this.VSIZE = VSIZE;
        this.board = new ArrayList<ArrayList<Color>>();
        for (int i = 0; i < VSIZE; i++) {
            this.board.add(new ArrayList<Color>());
            for (int j = 0; j < HSIZE; j++) {
                this.board.get(i).add(null);
            }
        }
    }

    /**
     * Returns the board of the game
     * @return the board of the game
     */
    ArrayList<ArrayList<Color>> getBoard() {
        return this.board;
    }

    /**
     * Puts a piece on the board
     * @param piece The piece to put
     * @param pos The position to put the piece on the board.
     */
    void putPiece(Piece piece, Position pos) {
        for(int j = pos.getY(); j < pos.getY() + piece.getShape().length; j++) {
            for(int i = pos.getX(); i < pos.getX() + piece.getShape()[0].length; i++) {
                if(piece.getShape()[j - pos.getY()][i - pos.getX()]) {
                    this.board.get(j).set(i, piece.getColor());
                }
            }
        }
    }
}
