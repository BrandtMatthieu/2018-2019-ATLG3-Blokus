package esi.atl.g44422.Model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

 class PieceTest {

	Piece myPiece;

	@BeforeEach
	 void initialize() {
		this.myPiece = Piece.FOURTEEN;
	}

	@Test
	 void pieceCellValueTest() {
		assertEquals(5, myPiece.getValue());
	}

	@Test
	 void pieceCellWidthTest() {
		assertEquals(2, myPiece.getSizeX());
	}

	@Test
	 void pieceCellHeightTest() {
		assertEquals(3, myPiece.getSizeY());
	}

	@Test
	 void pieceToStringTest() {
		assertEquals(
	"xx\n" +
			" x\n" +
			"xx\n",
			myPiece.toString()
		);
	}

	@Test
	 void pieceRotateTest() {
		myPiece.rotate90();
		assertEquals(
	"x x\n" +
			"xxx\n",
			myPiece.toString()
		);
	}

	@Test
	 void pieceMirrorTest() {
		myPiece.mirror();
		assertEquals(
	"xx\n" +
			"x \n" +
			"xx\n",
			myPiece.toString()
		);
	}
}
