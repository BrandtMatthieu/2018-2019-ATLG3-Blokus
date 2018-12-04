package esi.atl.g44422.Model;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Player {
	private final String nickname;
	private int score;
	private boolean hasSkipped;
	private final Color color;
	private ArrayList<Piece> stock;
	private ArrayList<Piece> piecesPut;

	 public Player(String nickname, Color color) {
		this.nickname = nickname;
		this.score = 0;
		this.hasSkipped = false;
		this.color = color;
		this.stock = new ArrayList<Piece>();
		initStock();
		this.piecesPut = new ArrayList<Piece>();
	}

	public String getNickname() {
		return nickname;
	}

	 public int getScore() {
		return score;
	}

	boolean hasSkipped() {
		return hasSkipped;
	}

	 public Color getColor() {
		return color;
	}

	public ArrayList<Piece> getStock() {
		return stock;
	}

	ArrayList<Piece> getPiecesPut() {
		return piecesPut;
	}

	private void initStock() {
		 this.stock.addAll(asList(Piece.values()));
	}

	void skip() {
		this.hasSkipped = true;
	}

	void put(int index) {
		if (index > this.stock.size() - 1) {
			throw new IllegalArgumentException("This piece doesn't exists");
		} else {
			this.piecesPut.add(this.stock.get(index));
			this.stock.remove(index);
		}
	}
}
