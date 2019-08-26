package esi.atl.g44422.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests a piece.
 * @author 44422
 */
public class PieceTest {

    private Player myPlayer;
    private Piece myPiece;
    private Board myBoard;

    /**
     * Initializes the tests.
     */
    @Before
    public void initialize() {
        this.myPlayer = new Player("Test player", Color.BLUE);
        this.myPiece = new Piece(Piece.getDefaultShapes().get(13), this.myPlayer);
        this.myBoard = new Board(20, 20);
    }

    /**
     * Tests the piece's value.
     */
    @Test
    public void pieceCellValueTest() {
        assertEquals(5, myPiece.getValue());
    }

    /**
     * Tests the piece's width.
     */
    @Test
    public void pieceCellWidthTest() {
        assertEquals(2, myPiece.getShape().getSizeX());
    }

    /**
     * Tests the piece's height.
     */
    @Test
    public void pieceCellHeightTest() {
        assertEquals(3, myPiece.getShape().getSizeY());
    }

    /**
     * Tests the piece toString method.
     */
    @Test
    public void pieceToStringTest() {
        assertEquals(
                "xx\n"
                + " x\n"
                + "xx\n",
                myPiece.toString()
        );
    }

    /**
     * Tests the 2d array method.
     */
    @Test
    public void pieceTo2DArrayTest() {
        boolean[][] myPieceBis = new boolean[][]{
            {true, true},
            {false, true},
            {true, true}
        };
        assertTrue(Arrays.deepEquals(myPieceBis, Piece.to2DArray(myPiece.getShape())));
    }

    /**
     * Tests the toPieceShape method.
     */
    @Test
    public void toPieceShapeTest() {
        assertEquals("xxx\nx x\nxxx\n", new Piece(Piece.toPieceShape(new boolean[][]{{true, true, true}, {true, false, true}, {true, true, true}}), myPlayer).toString());
    }

    /**
     * Tests the piece by rotating it.
     */
    @Test
    public void pieceRotateTest() {
        myPiece.rotate90();
        assertEquals(
                "xxx\n"
                + "x x\n",
                myPiece.toString()
        );
    }

    /**
     * Tests the piece by flipping it.
     */
    @Test
    public void pieceMirrorTest() {
        myPiece.mirror();
        assertEquals(
                "xx\n"
                + "x \n"
                + "xx\n",
                myPiece.toString()
        );
    }

    /**
     * Checks if a piece is out of bounds.
     */
    @Test
    public void pieceIsOutOfBounds() {
        Board myBoard = new Board(20, 20);
        myPiece.setPosition(null);
        assertFalse(myBoard.isOutOfBounds(myPiece, new Position(17, 16)));
    }

    /**
     * Checks if a piece is out of bounds.
     */
    @Test
    public void pieceIsOutOfBounds2() {
        Board myBoard = new Board(20, 20);
        myPiece.setPosition(null);
        assertFalse(myBoard.isOutOfBounds(myPiece, new Position(10, 10)));
    }

    /**
     * Checks if a piece is out of bounds.
     */
    @Test
    public void pieceIsOutOfBounds3() {
        myPiece.setPosition(null);
        assertTrue(myBoard.isOutOfBounds(myPiece, new Position(20, 20)));
    }

    /**
     * Checks if a piece does overlap another piece.
     */
    @Test
    public void pieceOverlapsOtherPiece() {
        Position overlappingPosition = new Position(10, 10);
        myBoard.put(myPiece, overlappingPosition);
        assertTrue(myBoard.overlapsOtherPiece(myPiece, overlappingPosition));
    }

    /**
     * Checks if a piece does overlap another piece.
     */
    @Test
    public void pieceOverlapsOtherPiece2() {
        Position overlappingPosition = new Position(10, 10);
        myBoard.put(myPiece, overlappingPosition);
        assertTrue(myBoard.overlapsOtherPiece(myPiece, Position.add(overlappingPosition, new Position(1, 0))));
    }
}
