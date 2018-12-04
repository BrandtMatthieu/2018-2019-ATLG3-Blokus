package esi.atl.g44422.Model;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Board extends GridPane {
	private final int sizeX;
	private final int sizeY;
	private ArrayList<Piece> piecesPut;

	Board(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.piecesPut = new ArrayList<Piece>();
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public ArrayList<Piece> getPiecesPut() { // pas public ou copie
		return piecesPut;
	}

	void put(Piece piece) {
		this.piecesPut.add(piece);
	}

	boolean canPutPiece(Piece piece, Position position) {
		// TODO
		return false;
	}

	boolean isOutOfBounds() {
		// TODO
		return false;
	}

	boolean overlapsOtherPiece() {
		// TODO
		return false;
	}

	boolean touchesSamePlayerPiece() {
		// TODO
		return false;
	}

}
