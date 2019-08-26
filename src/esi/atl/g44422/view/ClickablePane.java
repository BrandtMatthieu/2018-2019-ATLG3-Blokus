package esi.atl.g44422.view;

import esi.atl.g44422.model.GameInterface;
import esi.atl.g44422.model.Player;
import esi.atl.g44422.model.Position;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Represents a clickable pane in the board.
 */
class ClickablePane extends Pane {

	/**
	 * The default width of the pane.
	 */
	private static final int PREFWIDTH = 20;

	/**
	 * The default height of the pane.
	 */
	private static final int PREFHEIGHT = 20;

	/**
	 * The position of the clickable pane in the grid board.
	 */
	private final Position pos;
	/**
	 * A reference to the game.
	 */
	private final GameInterface game;

	/**
	 * Creates a new clickable pane.
	 *
	 * @param posX the x position of the pane
	 * @param posY the y position of the pane
	 * @param game the game
	 */
	ClickablePane(final int posX, final int posY, final GameInterface game) {
		super();
		this.pos = new Position(posX, posY);
		this.game = game;

		this.setCursor(Cursor.HAND);
		this.setPrefSize(PREFWIDTH, PREFHEIGHT);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		this.setUserData(pos);

		this.setOnMouseClicked((event) -> { // TODO
			final Player currentPlayer = this.game.getCurrentPlayer();
			final int piecesCount = currentPlayer.getStock().size();
			this.game.currentPlayerSetsPosition(pos);
			if(currentPlayer.getStock().size() < piecesCount) {
				// if cell has been clicked and piece has been put (number of piece in stock decreased)
				this.game.aiPlayersPlay();
			}
		});
	}

	/**
	 * Sets the color of the cell based on the player the cell belongs to.
	 *
	 * @param player the player that put the piece that covers that cell
	 */
	public void setColor(final Player player) {
		Color fillColor;
		switch(player.getColor()) {
			case RED:
				fillColor = Color.RED;
				break;
			case BLUE:
				fillColor = Color.BLUE;
				break;
			case GREEN:
				fillColor = Color.GREEN;
				break;
			case YELLOW:
				fillColor = Color.YELLOW;
				break;
			default:
				fillColor = Color.TRANSPARENT;
		}
		this.setBackground(new Background(new BackgroundFill(fillColor, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
