package esi.atl.g44422.Model;

public enum Color {
	BLUE("Bleu"), // ANGLAIS.
	GREEN("Vert"),
	RED("Rouge"),
	YELLOW("Jaune");

	private final String colorName; // pas ici mais dans la vue (console ?)

	Color(String colorName) {
		this.colorName = colorName;
	}

	String getColorName() {
		return this.colorName;
	}
}
