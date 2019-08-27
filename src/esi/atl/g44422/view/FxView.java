package esi.atl.g44422.view;

import esi.atl.g44422.model.GameInterface;
import esi.atl.g44422.util.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

/**
 * represents a Fx View for the game (what the user sees).
 */
public class FxView implements Observer {

    /**
     * The maximum height of the window.
     */
    private static final int MAXHEIGHT = 850;

    /**
     * The maximum width of the window.
     */
    private static final int MAXWIDTH = 1000;

    /**
     * The minimum height of the window.
     */
    private static final int MINHEIGHT = 700;

    /**
     * The minimum width of the window.
     */
    private static final int MINWIDTH = 870;

    /**
     * The title of the window.
     */
    private final String TITLE = "Blokus - Blokus-Brandt 44422";

    /**
     * The primary stage of the window.
     */
    private final Stage primaryStage;

    /**
     * A reference to the game.
     */
    private final GameInterface game;

    /**
     * The menu box of the window.
     */
    private MenuBox menuBox;

    /**
     * The game info box of the window.
     */
    private GameInfoBox gameInfoBox;

    /**
     * The container of all infoboxes.
     */
    private VBox playersInfoBoxesContainer;

    /**
     * All the infoboxes.
     */
    private ArrayList<PlayerInfoBox> playersInfoBoxes;

    /**
     * The grid box of the window.
     */
    private GridBoard gridBoard;

    /**
     * The buttons bar of the window.
     */
    private ButtonsBar buttonsBar;

    /**
     * The history window.
     */
    private HistoryWindow historyWindow;

    /**
     * Creates a new Fx View.
     *
     * @param primaryStage the primary stage of the application
     * @param game the game
     */
    public FxView(final Stage primaryStage, final GameInterface game) {
        this.primaryStage = primaryStage;
        this.game = game;

        this.newGame();

        this.historyWindow = null;
    }

    /**
     * Returns the menu box.
     *
     * @return the menu box
     */
    public MenuBox getMenuBox() {
        return menuBox;
    }

    /**
     * Returns the button bar.
     *
     * @return the button bar
     */
    public ButtonsBar getButtonsBar() {
        return this.buttonsBar;
    }

    /**
     * Returns the history window.
     *
     * @return the history window
     */
    public HistoryWindow getHistoryWindow() {
        return historyWindow;
    }

    /**
     * Creates a new game view.
     */
    public void newGame() {
        this.primaryStage.setTitle(this.TITLE);
        this.primaryStage.setMaxWidth(MAXWIDTH);
        this.primaryStage.setMaxHeight(MAXHEIGHT);
        this.primaryStage.setMinWidth(MINWIDTH);
        this.primaryStage.setMinHeight(MINHEIGHT);
        this.primaryStage.getIcons().add(new Image("icon.jpg"));

        this.menuBox = new MenuBox();

        this.gameInfoBox = new GameInfoBox(this.game);

        HBox mainHBox = new HBox();
        mainHBox.setAlignment(Pos.CENTER);

        this.playersInfoBoxes = new ArrayList<>();

        this.playersInfoBoxesContainer = new VBox();
        this.playersInfoBoxesContainer.getChildren().clear();
        playersInfoBoxesContainer.setSpacing(5);

        this.game.getPlayers().forEach(player -> {
            PlayerInfoBox box = new PlayerInfoBox(player, this.game);
            this.playersInfoBoxes.add(box);
            this.playersInfoBoxesContainer.getChildren().add(box);
        });

        this.gridBoard = new GridBoard(this.game);

        mainHBox.getChildren().clear();
        mainHBox.getChildren().addAll(playersInfoBoxesContainer, gridBoard);
        mainHBox.setPadding(new Insets(5, 5, 5, 5));
        mainHBox.setSpacing(5);

        this.buttonsBar = new ButtonsBar(this.game);

        VBox mainVBox = new VBox();
        mainVBox.setPadding(new Insets(5, 5, 5, 5));
        mainVBox.setSpacing(5);
        mainVBox.getChildren().addAll(this.menuBox, this.gameInfoBox, mainHBox, this.buttonsBar);

        Scene mainScene = new Scene(mainVBox);
        this.primaryStage.setScene(mainScene);
        this.primaryStage.show();

        this.primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            if (this.historyWindow != null) {
                this.historyWindow.close();
            }
        });

        this.update();
    }

    /**
     * Shows the history window.
     */
    public void showHistory() {
        if (this.historyWindow != null) {
            this.historyWindow.requestFocus();
        } else {
            this.historyWindow = new HistoryWindow(this.primaryStage, this.game);
        }
    }

    /**
     * Closes the history window.
     */
    public void closeHistory() {
        this.historyWindow = null;
    }

    /**
     * Updates the Fx View.
     */
    public synchronized void update() {
        this.gameInfoBox.update();

        this.playersInfoBoxes.forEach(box -> {
            box.update();
        });

        this.gridBoard.update();

        if (this.historyWindow != null) {
            this.historyWindow.update();
        }
        
        this.buttonsBar.update();
    }
}
