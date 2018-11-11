package esi.atl.g44422.Model;

/**
 * Represents a player's color in the game
 */
public enum Color {
    RED,
    GREEN,
    BLUE,
    YELLOW;

    @Override
    public String toString() {
        switch (this) {
            case RED:
                return "Red";
            case BLUE:
                return "Blue";
            case GREEN:
                return "Green";
            case YELLOW:
                return "Yellow";
            default:
                return "";
        }
    }
}
