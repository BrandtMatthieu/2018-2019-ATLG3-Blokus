package esi.atl.g44422.view;

import esi.atl.g44422.model.AIPlayer;
import esi.atl.g44422.model.GameInterface;
import esi.atl.g44422.model.Piece;
import esi.atl.g44422.model.Player;
import esi.atl.g44422.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Represents a info-box for a player in the application.
 */
public class PlayerInfoBox extends FlowPane implements Observer {

	private final Player player;
	private final GameInterface game;

	private final Label playerNickname;
	private final Label playerScore;
	private final Label playerStockCount;
	private final FlowPane playerStock;

	/**
	 * Creates a new info-box.
	 *
	 * @param player the player
	 * @param game   the game
	 */
	PlayerInfoBox(Player player, GameInterface game) {
		super();

		this.player = player;
		this.game = game;

		this.playerNickname = new Label("Player : " + player.getNickname() + "\n\t\t(aka. " + player.getColor().toString() + ")");

		this.playerScore = new Label();

		this.playerStockCount = new Label();

		this.playerStock = new FlowPane();

		VBox vbox = new VBox();
		vbox.getChildren().addAll(playerNickname, playerScore, playerStockCount, playerStock);
		displayStock();

		this.getChildren().add(vbox);

		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setPadding(new Insets(5, 5, 5, 5));

		this.update();
	}

	/**
	 * Displays the stock of pieces of a player.
	 */
	private void displayStock() {
		this.playerStock.getChildren().clear();
		for(Piece piece : player.getStock()) {
			PieceGrid playerPiece = new PieceGrid(piece, 7, this.game);
			if(this.game.getCurrentPlayer() == player && !(player instanceof AIPlayer)) {
				playerPiece.setCursor(Cursor.HAND);
			}
			this.playerStock.getChildren().add(playerPiece);
		}
	}

	/**
	 * Updates the player info box.
	 */
	public void update() {
		this.playerScore.setText("Score : " + this.player.getScore());
		this.playerStockCount.setText("Stock : " + player.getStock().size() + " pieces left");

		this.playerStock.getChildren().clear();
		this.displayStock();
	}
}
