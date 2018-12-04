package esi.atl.g44422.Model;

public enum Color {
	BLUE("Bleu"),
	GREEN("Vert"),
	RED("Rouge"),
	YELLOW("Jaune");

	private final String colorName;

	Color(String colorName) {
		this.colorName = colorName;
	}

	String getColorName() {
		return this.colorName;
	}
}
