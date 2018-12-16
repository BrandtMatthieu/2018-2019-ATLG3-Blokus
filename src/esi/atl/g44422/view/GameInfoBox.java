package esi.atl.g44422.view;

import esi.atl.g44422.model.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

/**
 * Represents an info-box for the game in the application
 */
class GameInfoBox extends FlowPane {

	private final Label turnNumberLabel;
	private Label currentPlayerNickname;
	private PieceGrid selectedPiecePreview;

	/**
	 * Creates a new info-box
	 *
	 * @param game the game
	 */
	public GameInfoBox(Game game) {
		super();
		this.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setMinHeight(50);
		this.setAlignment(Pos.CENTER);
		this.setHgap(20);
		this.turnNumberLabel = new Label("Turn n° " + game.getTurnNumber());
		this.getChildren().add(turnNumberLabel);
		if(game.getCurrentPlayer() != null) {
			if(game.getWinner() != null) {
				this.currentPlayerNickname = new Label("Winner : " + game.getWinner().getNickname());
				this.getChildren().add(currentPlayerNickname);
			} else {
				this.currentPlayerNickname = new Label("Current player : " + game.getCurrentPlayer().getNickname());
				this.getChildren().add(currentPlayerNickname);
				if(game.getSelectedPiece() != null) {
					this.selectedPiecePreview = new PieceGrid(game.getSelectedPiece(), 5, game);
					this.getChildren().add(selectedPiecePreview);
				} else {
					Region emptyBox = new Region();
					emptyBox.setPrefSize(20, 20);
					emptyBox.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
					this.getChildren().add(emptyBox);
				}
			}
		}
	}
}
