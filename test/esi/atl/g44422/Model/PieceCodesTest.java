package esi.atl.g44422.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PieceCodesTest {

	private Player testPlayer;

	@Before
	public void initialize() {
		testPlayer = new Player("Test Player", Color.BLUE);
	}

	@Test
	public void toStringONE() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(0), testPlayer);
		assertEquals("x\n", myPiece.toString());
	}

	@Test
	public void toStringTWO() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(1), testPlayer);
		assertEquals(
				"x\n" +
						"x\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringTHREE() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(2), testPlayer);
		assertEquals(
				"x\n" +
						"x\n" +
						"x\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringFOUR() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(3), testPlayer);
		assertEquals(
				"x \n" +
						"xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringFIVE() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(4), testPlayer);
		assertEquals(
				"x\n" +
						"x\n" +
						"x\n" +
						"x\n", myPiece.toString());
	}

	@Test
	public void toStringSIX() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(5), testPlayer);
		assertEquals(
				" x\n" +
						" x\n" +
						"xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringSEVEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(6), testPlayer);
		assertEquals(
				"x \n" +
						"xx\n" +
						"x \n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringEIGHT() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(7), testPlayer);
		assertEquals(
				"xx\n" +
						"xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringNINE() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(8), testPlayer);
		assertEquals(
				"xx \n" +
						" xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringTEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(9), testPlayer);
		assertEquals(
				"x\n" +
						"x\n" +
						"x\n" +
						"x\n" +
						"x\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringELEVEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(10), testPlayer);
		assertEquals(
				" x\n" +
						" x\n" +
						" x\n" +
						"xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringTWELVE() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(11), testPlayer);
		assertEquals(
				" x\n" +
						" x\n" +
						"xx\n" +
						"x \n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringTHIRTEEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(12), testPlayer);
		assertEquals(
				" x\n" +
						"xx\n" +
						"xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringFOURTEEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(13), testPlayer);
		assertEquals(
				"xx\n" +
						" x\n" +
						"xx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringFIFTEEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(14), testPlayer);
		assertEquals(
				"x \n" +
						"xx\n" +
						"x \n" +
						"x \n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringSIXTEEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(15), testPlayer);
		assertEquals(
				" x \n" +
						" x \n" +
						"xxx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringSEVENTEEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(16), testPlayer);
		assertEquals(
				"x  \n" +
						"x  \n" +
						"xxx\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringEIGHTEEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(17), testPlayer);
		assertEquals(
				"xx \n" +
						" xx\n" +
						"  x\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringNINETEEN() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(18), testPlayer);
		assertEquals(
				"x  \n" +
						"xxx\n" +
						"  x\n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringTWENTY() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(19), testPlayer);
		assertEquals(
				"x  \n" +
						"xxx\n" +
						" x \n",
				myPiece.toString()
		);
	}

	@Test
	public void toStringTWENTYONE() {
		Piece myPiece = new Piece(Piece.getDefaultShapes().get(20), testPlayer);
		assertEquals(
				" x \n" +
						"xxx\n" +
						" x \n",
				myPiece.toString()
		);
	}
}
