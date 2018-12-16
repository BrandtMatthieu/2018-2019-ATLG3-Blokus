package esi.atl.g44422.view;

import esi.atl.g44422.model.Game;
import esi.atl.g44422.model.Position;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;

/**
 * Represents a clickable pane in the board
 */
class ClickablePane extends Region {
	private final Position pos;

	/**
	 * Creates a new clickable pane
	 *
	 * @param posX the x position of the pane
	 * @param posY the y position of the pane
	 * @param game the game
	 */
	ClickablePane(int posX, int posY, Game game) {
		super();
		this.pos = new Position(posX, posY);

		this.setCursor(Cursor.HAND);
		this.setPrefSize(20, 20);
		this.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		this.setUserData(pos);

		this.setOnMouseClicked((event) -> {
			game.currentPlayerSetsPosition(pos);
		});
	}
}
