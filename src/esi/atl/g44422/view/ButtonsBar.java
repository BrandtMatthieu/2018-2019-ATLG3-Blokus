package esi.atl.g44422.view;

import esi.atl.g44422.model.GameInterface;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Represents the bar with all action button in the application.
 */
public class ButtonsBar extends HBox {
    
    private GameInterface game;

    /**
     * The new game button.
     */
    private final Button newGame;

    /**
     * The skip turn button.
     */
    private final Button skipTurn;

    /**
     * The stop game button.
     */
    private final Button stopGame;

    /**
     * The turn piece button.
     */
    private final Button turnPiece;

    /**
     * The flip piece button.
     */
    private final Button flipPiece;
    
    /**
     * The validate turn button.
     */
    private final Button validateTurn;
    
    /**
     * The cancel turn button.
     */
    private final Button cancelTurn;

    /**
     * Creates a new button bar.
     */
    ButtonsBar(GameInterface game) {
        this.game = game;
        
        this.newGame = new Button("New Game");

        this.skipTurn = new Button("Skip turn");

        this.stopGame = new Button("Stop game");

        this.turnPiece = new Button("Turn selected piece");

        this.flipPiece = new Button("Flip selected piece");
        
        this.validateTurn = new Button("Validate turn");
        
        this.cancelTurn = new Button("Cancel turn");

        this.getChildren().addAll(this.newGame, this.skipTurn, this.stopGame, this.turnPiece, this.flipPiece, this.validateTurn, this.cancelTurn);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Returns the naw game button.
     *
     * @return the new game button
     */
    public Button getNewGame() {
        return newGame;
    }

    /**
     * Returns the skip turn button.
     *
     * @return the skip turn button
     */
    public Button getSkipTurn() {
        return skipTurn;
    }

    /**
     * Returns the stop game button.
     *
     * @return the stop game button
     */
    public Button getStopGame() {
        return stopGame;
    }

    /**
     * Returns the turn piece button.
     *
     * @return the turn piece button
     */
    public Button getTurnPiece() {
        return turnPiece;
    }

    /**
     * Returns the flip piece button.
     *
     * @return the flip piece button
     */
    public Button getFlipPiece() {
        return flipPiece;
    }
    
    /**
     * Returns the validate turn button.
     * 
     * @return the validate turn button
     */
    public Button getValidateTurn() {
        return validateTurn;
    }

    /**
     * Returns the cancel turn button.
     * 
     * @return the cancel turn button
     */
    public Button getCancelTurn() {
        return cancelTurn;
    }
    
    public void update() {
        if(game.getCurrentPlayer() != null && game.getCurrentPlayer().hasPlayed()) {
            this.validateTurn.setDisable(false);
            this.cancelTurn.setDisable(false);
        } else {
            this.validateTurn.setDisable(true);
            this.cancelTurn.setDisable(true);
        }
    }
}
