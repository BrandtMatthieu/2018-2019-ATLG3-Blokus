package esi.atl.g44422.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
	@Test
	public void boardPutPieceTest() {
		Board myBoard = new Board(20, 20);
		boolean[][] myShape = {{true}};
		Piece myPiece = new Piece(myShape, Color.BLUE);
		myBoard.putPiece(myPiece, new Position(10,10));
		assertFalse(myBoard.getBoard().contains(true));
	}

	@Test
	public void boardSizeTest() {
		Board myBoard = new Board(20, 20);
		assertEquals(20, myBoard.getBoard().size());
	}

	@Test
	public void boardSizeTest2() {
		Board myBoard = new Board(20, 20);
		assertEquals(20, myBoard.getBoard().get(0).size());
	}
}