package esi.atl.g44422.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PieceTest {

	private Player myPlayer;
	private Piece myPiece;
	private Board myBoard;

	@Before
	public void initialize() {
		this.myPlayer = new Player("Test player", Color.BLUE);
		this.myPiece = new Piece(Piece.getDefaultShapes().get(13), this.myPlayer);
		this.myBoard = new Board(20, 20);
	}

	@Test
	public void pieceCellValueTest() {
		assertEquals(5, myPiece.getValue());
	}

	@Test
	public void pieceCellWidthTest() {
		assertEquals(2, myPiece.getShape().getSizeX());
	}

	@Test
	public void pieceCellHeightTest() {
		assertEquals(3, myPiece.getShape().getSizeY());
	}

	@Test
	public void pieceToStringTest() {
		assertEquals(
				"xx\n" +
						" x\n" +
						"xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void pieceTo2DArrayTest() {
		boolean[][] myPieceBis = new boolean[][]{
				{true, true},
				{false, true},
				{true, true}
		};
		assertTrue(Arrays.deepEquals(myPieceBis, Piece.to2DArray(myPiece.getShape())));
	}

	@Test
	public void toPieceShapeTest() {
		assertEquals("xxx\nx x\nxxx\n", new Piece(Piece.toPieceShape(new boolean[][]{{true, true, true}, {true, false, true}, {true, true, true}}), myPlayer).toString());
	}

	@Test
	public void pieceRotateTest() {
		myPiece.rotate90();
		assertEquals(
				"xxx\n" +
						"x x\n",
				myPiece.toString()
		);
	}

	@Test
	public void pieceMirrorTest() {
		myPiece.mirror();
		assertEquals(
				"xx\n" +
						"x \n" +
						"xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void pieceIsOutOfBounds() {
		Board myBoard = new Board(20, 20);
		myPiece.setPosition(null);
		assertFalse(myBoard.isOutOfBounds(myPiece, new Position(17, 16)));
	}

	@Test
	public void pieceIsOutOfBounds2() {
		Board myBoard = new Board(20, 20);
		myPiece.setPosition(null);
		assertFalse(myBoard.isOutOfBounds(myPiece, new Position(10, 10)));
	}

	@Test
	public void pieceIsOutOfBounds3() {
		myPiece.setPosition(null);
		assertTrue(myBoard.isOutOfBounds(myPiece, new Position(20, 20)));
	}

	@Test
	public void pieceOverlapsOtherPiece() {
		Position overlappingPosition = new Position(10, 10);
		myBoard.put(myPiece, overlappingPosition);
		assertTrue(myBoard.overlapsOtherPiece(myPiece, overlappingPosition));
	}

	@Test
	public void pieceOverlapsOtherPiece2() {
		Position overlappingPosition = new Position(10, 10);
		myBoard.put(myPiece, overlappingPosition);
		assertTrue(myBoard.overlapsOtherPiece(myPiece, Position.add(overlappingPosition, new Position(1, 0))));
	}
}
