package esi.atl.g44422.view;

import esi.atl.g44422.model.AIPlayer;
import esi.atl.g44422.model.Game;
import esi.atl.g44422.model.Piece;
import esi.atl.g44422.model.Player;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

/**
 * Represents a info-box for a player in the application
 */
class PlayerInfoBox extends FlowPane {
	private final Label playerNickname;
	private final Label playerScore;
	private final FlowPane playerStock;

	/**
	 * Creates a new info-box
	 *
	 * @param player the player
	 * @param game   the game
	 */
	public PlayerInfoBox(Player player, Game game) {
		super();
		this.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.playerNickname = new Label("Player : " + player.getNickname() + "            (aka. " + player.getColor().toString() + ")");
		this.playerScore = new Label("Score : " + player.getScore());
		this.playerStock = new FlowPane();
		this.displayStock(player, game);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(playerNickname, playerScore, playerStock);
		this.getChildren().add(vbox);
		this.setPadding(new Insets(5, 5, 5, 5));
	}

	/**
	 * Displays the stock of pieces of a player
	 *
	 * @param player the player
	 * @param game   the game
	 */
	private void displayStock(Player player, Game game) {
		for(Piece piece : player.getStock()) {
			PieceGrid playerPiece = new PieceGrid(piece, 7, game);
			if(game.getCurrentPlayer() == player && !(player instanceof AIPlayer)) {
				playerPiece.setCursor(Cursor.HAND);
			}
			this.playerStock.getChildren().add(playerPiece);
		}
	}
}

