package esi.atl.g44422.model;

/**
 * Represents a color of a player.
 */
public enum Color {
    /**
     * The color blue.
     */
    BLUE("Blue"),
    /**
     * The co:lor green.
     */
    GREEN("Green"),
    /**
     * The color red.
     */
    RED("Red"),
    /**
     * The color yellow.
     */
    YELLOW("Yellow");

    /**
     * The name of the color.
     */
    private final String colorName;

    /**
     * Creates a new color.
     *
     * @param colorName the name of the color
     */
    Color(final String colorName) {
        this.colorName = colorName;
    }

    /**
     * Returns the name of the color.
     *
     * @return the name of the color
     */
    @Override
    public String toString() {
        return this.colorName;
    }
}
