package esi.atl.g44422.Model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

 class PieceCodesTest {

	@Test
	 void toStringONE() {
		Piece myPiece = Piece.ONE;
		assertEquals("x\n",myPiece.toString());
	}

	@Test
	 void toStringTWO() {
		Piece myPiece = Piece.TWO;
		assertEquals(
	"x\n" +
			"x\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringTHREE() {
		Piece myPiece = Piece.THREE;
		assertEquals(
	"x\n" +
			"x\n" +
			"x\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringFOUR() {
		Piece myPiece = Piece.FOUR;
		assertEquals(
	"x \n" +
			"xx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringFIVE() {
		Piece myPiece = Piece.FIVE;
		assertEquals(
	"x\n" +
			"x\n" +
			"x\n" +
			"x\n",myPiece.toString());
	}

	@Test
	 void toStringSIX() {
		Piece myPiece = Piece.SIX;
		assertEquals(
	" x\n" +
			" x\n" +
			"xx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringSEVEN() {
		Piece myPiece = Piece.SEVEN;
		assertEquals(
	"x \n" +
			"xx\n" +
			"x \n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringEIGHT() {
		Piece myPiece = Piece.EIGHT;
		assertEquals(
	"xx\n" +
			"xx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringNINE() {
		Piece myPiece = Piece.NINE;
		assertEquals(
	"xx \n" +
			" xx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringTEN() {
		Piece myPiece = Piece.TEN;
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
	 void toStringELEVEN() {
		Piece myPiece = Piece.ELEVEN;
		assertEquals(
	" x\n" +
			" x\n" +
			" x\n" +
			"xx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringTWELVE() {
		Piece myPiece = Piece.TWELVE;
		assertEquals(
	" x\n" +
			" x\n" +
			"xx\n" +
			"x \n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringTHIRTEEN() {
		Piece myPiece = Piece.THIRTEEN;
		assertEquals(
	" x\n" +
			"xx\n" +
			"xx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringFOURTEEN() {
		Piece myPiece = Piece.FOURTEEN;
		assertEquals(
	"xx\n" +
			" x\n" +
			"xx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringFIFTEEN() {
		Piece myPiece = Piece.FIFTEEN;
		assertEquals(
	"x \n" +
			"xx\n" +
			"x \n" +
			"x \n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringSIXTEEN() {
		Piece myPiece = Piece.SIXTEEN;
		assertEquals(
	" x \n" +
			" x \n" +
			"xxx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringSEVENTEEN() {
		Piece myPiece = Piece.SEVENTEEN;
		assertEquals(
	"x  \n" +
			"x  \n" +
			"xxx\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringEIGHTEEN() {
		Piece myPiece = Piece.EIGHTEEN;
		assertEquals(
	"xx \n" +
			" xx\n" +
			"  x\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringNINETEEN() {
		Piece myPiece = Piece.NINETEEN;
		assertEquals(
	"x  \n" +
			"xxx\n" +
			"  x\n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringTWENTY() {
		Piece myPiece = Piece.TWENTY;
		assertEquals(
	"x  \n" +
			"xxx\n" +
			" x \n",
			myPiece.toString()
		);
	}

	@Test
	 void toStringTWENTYONE() {
		Piece myPiece = Piece.TWENTYONE;
		assertEquals(
	" x \n" +
			"xxx\n" +
			" x \n",
			myPiece.toString()
		);
	}
}
