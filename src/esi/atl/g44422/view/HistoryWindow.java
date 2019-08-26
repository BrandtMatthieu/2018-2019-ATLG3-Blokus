package esi.atl.g44422.view;

import esi.atl.g44422.model.GameInterface;
import esi.atl.g44422.util.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Represents the history windows containing the game history.
 */
public class HistoryWindow extends Stage implements Observer {

    private final GameInterface game;

    private final VBox layout;
    private final Label title;
    private final ListView<String> list;

    /**
     * Creates a new history window.
     *
     * @param primaryStage the primary stage of the app
     * @param game a reference to the game containing the history
     */
    HistoryWindow(Stage primaryStage, GameInterface game) {
        this.game = game;

        this.layout = new VBox();

        this.title = new Label("Moves History");
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font(24));
        title.setPadding(new Insets(5, 5, 5, 5));

        this.list = new ListView<>();
        this.update();

        this.layout.getChildren().addAll(title, list);

        this.setTitle("Moves History");
        this.setScene(new Scene(this.layout, 300, 400));
        this.setResizable(false);

        this.setX(primaryStage.getX() + 100);
        this.setY(primaryStage.getY() + 100);

        this.show();
        this.requestFocus();
    }

    /**
     * Updates the history window.
     */
    @Override
    public void update() {
        list.getItems().clear();
        this.game.getMovesHistory().forEach(
                move -> list.getItems().add(move)
        );
    }
}
