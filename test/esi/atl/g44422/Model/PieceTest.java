package esi.atl.g44422.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PieceTest {
	@Test
	public void pieceValueTest() {
		boolean[][] shape = {{}};
		Piece myPiece = new Piece(shape, Color.BLUE);
		assertEquals(0, myPiece.getValue());
	}

	@Test
	public void pieceValueTest2() {
		boolean[][] shape = {{true}};
		Piece myPiece = new Piece(shape, Color.BLUE);
		assertEquals(1, myPiece.getValue());
	}

	@Test
	public void pieceValueTest3() {
		boolean[][] shape = {{true}, {true}};
		Piece myPiece = new Piece(shape, Color.BLUE);
		assertEquals(2, myPiece.getValue());
	}

	@Test
	public void pieceValueTest4() {
		boolean[][] shape = {{true, true}};
		Piece myPiece = new Piece(shape, Color.BLUE);
		assertEquals(2, myPiece.getValue());
	}

	@Test
	public void pieceValueTest5() {
		boolean[][] shape = {{true, true}, {true, true}};
		Piece myPiece = new Piece(shape, Color.BLUE);
		assertEquals(4, myPiece.getValue());
	}

	@Test
	public void pieceValueTest6() {
		boolean[][] shape = {{true, false}, {false, true}};
		Piece myPiece = new Piece(shape, Color.BLUE);
		assertEquals(2, myPiece.getValue());
	}
}