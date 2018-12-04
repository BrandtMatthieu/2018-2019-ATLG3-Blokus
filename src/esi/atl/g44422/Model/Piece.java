package esi.atl.g44422.Model;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public enum Piece {
	ONE(new ArrayList<Position>(asList(new Position(0, 0)))),
	TWO(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1)))),
	THREE(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2)))),
	FOUR(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 1)))),
	FIVE(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(0, 3)))),
	SIX(new ArrayList<Position>(asList(new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(0, 2)))),
	SEVEN(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(1, 1)))),
	EIGHT(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1)))),
	NINE(new ArrayList<Position>(asList(new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(2, 1)))),
	TEN(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(0, 3), new Position(0, 4)))),
	ELEVEN(new ArrayList<Position>(asList(new Position(0, 3), new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(1, 3)))),
	TWELVE(new ArrayList<Position>(asList(new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(0, 2), new Position(0, 3)))),
	THIRTEEN(new ArrayList<Position>(asList(new Position(1, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1), new Position(0, 2), new Position(1, 2)))),
	FOURTEEN(new ArrayList<Position>(asList(new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(0, 2), new Position(1, 2)))),
	FIFTEEN(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(0, 2), new Position(0, 3)))),
	SIXTEEN(new ArrayList<Position>(asList(new Position(0, 2), new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(2, 2)))),
	SEVENTEEN(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(1, 2), new Position(2, 2)))),
	EIGHTEEN(new ArrayList<Position>(asList(new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(2, 1), new Position(2, 2)))),
	NINETEEN(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(2, 1), new Position(2, 2)))),
	TWENTY(new ArrayList<Position>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(1, 2), new Position(2, 1)))),
	TWENTYONE(new ArrayList<Position>(asList(new Position(1, 1), new Position(0, 1), new Position(1, 0), new Position(2, 1), new Position(1, 2))));

	private ArrayList<Position> cells;
	private Position position;

	Piece(ArrayList<Position> cells) {
		this.cells = cells;
	}

	 public ArrayList<Position> getCells() {
		return this.cells;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	private static ArrayList<Position> toPositionList(boolean[][] shape) {
		ArrayList<Position> positionList = new ArrayList<Position>();
		for (int y = 0; y < shape.length; y++) {
			for (int x = 0; x < shape[0].length; x++) {
				if (shape[y][x]) {
					positionList.add(new Position(x, y));
				}
			}
		}
		return positionList;
	}

	private static boolean[][] rotate2DArray90(boolean[][] original) {
		boolean[][] rotated = new boolean[original.length][original[0].length];
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[0].length; j++) {
				rotated[i][j] = original[j][original.length - i - 1];
			}
		}
		return rotated;
	}

	private static boolean[][] mirror2DArray(boolean[][] original) {
		for (int j = 0; j < original.length; ++j) {  // Extra for loop to go through each row in turn, performing the reversal within that row.
			boolean[] row = original[j];
			for (int i = 0; i < (row.length / 2); i++) {
				boolean temp = row[i];
				row[i] = original[j][row.length - i - 1];
				row[row.length - i - 1] = temp;
			}
		}
		return original;
	}

	 int getSizeX() {
		int maxX = 0;
		for (Position pos : this.cells) {
			maxX = Math.max(maxX, pos.getX());
		}
		return maxX + 1;
	}

	 int getSizeY() {
		int maxY = 0;
		for (Position pos : this.cells) {
			maxY = Math.max(maxY, pos.getY());
		}
		return maxY + 1;
	}

	 int getValue() {
		return this.cells.size();
	}

	private boolean[][] to2DArray() {
		boolean[][] shape = new boolean[this.getSizeY()][this.getSizeX()];
		for (Position pos : this.cells) {
			shape[pos.getY()][pos.getX()] = true;
		}
		return shape;
	}

	void rotate90() {
		this.cells = toPositionList(rotate2DArray90(this.to2DArray()));
	}

	void mirror() {
		this.cells = toPositionList(mirror2DArray(this.to2DArray()));
	}

	@Override
	public String toString() {
		String str = "";
		for (boolean[] row : this.to2DArray()) {
			for (boolean cell : row) {
				str += cell ? "x" : " ";
			}
			str += "\n";
		}
		return str;
	}
}
