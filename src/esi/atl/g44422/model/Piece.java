package esi.atl.g44422.model;

import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
 * Represents a piece in the game
 */
public class Piece {
	static private final ArrayList<PieceShape> defaultShapes = new ArrayList<>(
			asList(
					new PieceShape(new ArrayList<>(asList(new Position(0, 0)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 1)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(0, 3)))),
					new PieceShape(new ArrayList<>(asList(new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(0, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(1, 1)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(2, 1)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(0, 3), new Position(0, 4)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 3), new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(1, 3)))),
					new PieceShape(new ArrayList<>(asList(new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(0, 2), new Position(0, 3)))),
					new PieceShape(new ArrayList<>(asList(new Position(1, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1), new Position(0, 2), new Position(1, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(0, 2), new Position(1, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(0, 2), new Position(0, 3)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 2), new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(2, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(1, 2), new Position(2, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(2, 1), new Position(2, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(2, 1), new Position(2, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(1, 2), new Position(2, 1)))),
					new PieceShape(new ArrayList<>(asList(new Position(1, 1), new Position(0, 1), new Position(1, 0), new Position(2, 1), new Position(1, 2)))),
					new PieceShape(new ArrayList<>(asList(new Position(0, 0), new Position(1, 0), new Position(0, 1), new Position(1, 1), new Position(0, 2), new Position(1, 2))))
			)
	);
	private final Player owner;
	private final ArrayList<Position> corners;
	private PieceShape shape;
	private Position position;

	/**
	 * Creates a new piece
	 *
	 * @param newShape the shape of the piece
	 * @param owner    the owner of the piece
	 */
	Piece(PieceShape newShape, Player owner) {
		this.shape = newShape;
		this.position = null;
		this.owner = owner;
		this.corners = new ArrayList<>();
		findCorners();
	}

	/**
	 * Gets a list with all pre-defined shape
	 *
	 * @return Gets a list with all pre-defined shape
	 */
	static public ArrayList<PieceShape> getDefaultShapes() {
		return new ArrayList<>(defaultShapes);
	}

	/**
	 * Converts a piece's shape to a 2D boolean array
	 *
	 * @param shape the shape to be converted
	 * @return a 2D boolean array of the shape
	 */
	public static boolean[][] to2DArray(PieceShape shape) {
		boolean[][] new2DShape = new boolean[shape.getSizeY()][shape.getSizeX()];
		for(Position pos : shape.getCells()) {
			new2DShape[pos.getY()][pos.getX()] = true;
		}
		return new2DShape;
	}

	/**
	 * Returns a piece shape made from a 2d boolean array
	 *
	 * @param shape a 2d boolean array of a shape
	 * @return a piece shape
	 */
	public static PieceShape toPieceShape(boolean[][] shape) {
		ArrayList<Position> newShape = new ArrayList<>();
		for(int y = 0; y < shape.length; y++) {
			for(int x = 0; x < shape[0].length; x++) {
				if(shape[y][x]) {
					newShape.add(new Position(x, y));
				}
			}
		}
		return new PieceShape(newShape);
	}

	/**
	 * Rotates a 2d boolean array
	 *
	 * @param original the array to rotate
	 * @return the rotated array
	 */
	private static boolean[][] rotate2DArray90(boolean[][] original) {
		int totalRowsOfRotatedMatrix = original[0].length;
		int totalColsOfRotatedMatrix = original.length;

		boolean[][] rotated = new boolean[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

		for(int i = 0; i < original.length; i++) {
			for(int j = 0; j < original[0].length; j++) {
				rotated[(totalRowsOfRotatedMatrix - 1) - j][i] = original[i][j];
			}
		}
		return rotated;
	}

	/**
	 * Returns a mirrored array
	 *
	 * @param original the original array
	 * @return the rotated array
	 */
	private static boolean[][] mirror2DArray(boolean[][] original) {
		for(boolean[] row : original) {
			for(int i = 0; i < (row.length / 2); i++) {
				boolean temp = row[i];
				row[i] = row[row.length - i - 1];
				row[row.length - i - 1] = temp;
			}
		}
		return original;
	}

	/**
	 * Finds all the corners of the piece
	 */
	private void findCorners() {
		for(Position cell : this.shape.getCells()) {
			if(!PieceShape.isOnTheSideOfOtherCell(Position.add(cell, new Position(-1, -1)), this)) {
				this.corners.add(Position.add(cell, new Position(-1, -1)));
			}
			if(!PieceShape.isOnTheSideOfOtherCell(Position.add(cell, new Position(-1, 1)), this)) {
				this.corners.add(Position.add(cell, new Position(-1, 1)));
			}
			if(!PieceShape.isOnTheSideOfOtherCell(Position.add(cell, new Position(1, -1)), this)) {
				this.corners.add(Position.add(cell, new Position(1, -1)));
			}
			if(!PieceShape.isOnTheSideOfOtherCell(Position.add(cell, new Position(1, 1)), this)) {
				this.corners.add(Position.add(cell, new Position(1, 1)));
			}
		}
	}

	/**
	 * Returns the shape of the piece
	 *
	 * @return the shape of the piece
	 */
	public PieceShape getShape() {
		return this.shape;
	}

	/**
	 * Returns the position of the piece
	 *
	 * @return the position of the piece
	 */
	public Position getPosition() {
		return this.position;
	}

	/**
	 * Sets the position of the piece
	 *
	 * @param position the position of the piece
	 */
	void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Returns the owner of the piece
	 *
	 * @return the owner of the piece
	 */
	public Player getOwner() {
		return this.owner;
	}

	/**
	 * Returns the value of the piece
	 *
	 * @return the value of the piece
	 */
	int getValue() {
		return this.shape.getCells().size();
	}

	/**
	 * Returns the corners of the piece
	 *
	 * @return the corners of the piece
	 */
	public ArrayList<Position> getCorners() {
		return this.corners;
	}

	/**
	 * Rotates the shape of the piece 90°
	 */
	void rotate90() {
		this.shape = toPieceShape(rotate2DArray90(to2DArray(this.getShape())));
	}

	/**
	 * Mirrors the shape of the piece
	 */
	void mirror() {
		this.shape = toPieceShape(mirror2DArray(to2DArray(this.getShape())));
	}

	/**
	 * Returns a string made of the shape of the piece
	 *
	 * @return a string made of the shape of the piece
	 */
	@Override
	public String toString() {
		String str = "";
		for(boolean[] row : to2DArray(this.getShape())) {
			for(boolean cell : row) {
				str = str.concat(cell ? "x" : " ");
			}
			str = str.concat("\n");
		}
		return str;
	}
}
