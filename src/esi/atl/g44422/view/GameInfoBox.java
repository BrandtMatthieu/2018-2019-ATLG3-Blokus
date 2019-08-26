package esi.atl.g44422.view;

import esi.atl.g44422.model.GameInterface;
import esi.atl.g44422.util.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Represents an info-box for the game in the application.
 */
class GameInfoBox extends FlowPane implements Observer {

    private final GameInterface game;

    private final Label turnNumberLabel;
    private final Label currentPlayerNickname;
    private PieceGrid selectedPiecePreview;

    /**
     * Creates a new info-box.
     *
     * @param game the game
     */
    GameInfoBox(GameInterface game) {
        super();
        this.game = game;

        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setMinHeight(50);
        this.setAlignment(Pos.CENTER);
        this.setHgap(20);
        this.setAlignment(Pos.CENTER);

        this.turnNumberLabel = new Label();

        this.currentPlayerNickname = new Label();

        this.selectedPiecePreview = new PieceGrid(null, 5, this.game);

        this.update();
    }

    /**
     * Updates the game infos box component.
     */
    public void update() {
        this.getChildren().clear();
        this.turnNumberLabel.setText("Turn number: " + (this.game.getTurnNumber() + 1));
        if (this.game.getCurrentPlayer() != null) {
            if (this.game.getWinner() != null) {
                this.currentPlayerNickname.setText("Winner : " + this.game.getWinner().getNickname());

                this.selectedPiecePreview.setVisible(false);
            } else {
                this.currentPlayerNickname.setText("Current player : " + this.game.getCurrentPlayer().getNickname());

                this.selectedPiecePreview = new PieceGrid(this.game.getSelectedPiece(), 5, this.game);
                this.selectedPiecePreview.setVisible(true);
            }
        }
        this.getChildren().addAll(turnNumberLabel, currentPlayerNickname, selectedPiecePreview);
    }
}
