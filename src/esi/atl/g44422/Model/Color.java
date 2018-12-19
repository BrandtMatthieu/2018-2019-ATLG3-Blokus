package esi.atl.g44422.model;

/**
 * Represents a color of a player
 */
public enum Color {
	BLUE("Blue"),
	GREEN("Green"),
	RED("Red"),
	YELLOW("Yellow");

	private final String colorName;

	/**
	 * Creates a new color
	 *
	 * @param colorName the name of the color
	 */
	Color(String colorName) {
		this.colorName = colorName;
	}

	/**
	 * Returns the name of the color
	 *
	 * @return the name of the color
	 */
	@Override
	public String toString() {
		return this.colorName;
	}
}
