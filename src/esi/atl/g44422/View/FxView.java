package esi.atl.g44422.View;

import esi.atl.g44422.Model.Color;
import esi.atl.g44422.Model.Piece;
import esi.atl.g44422.Model.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Represents the game's user interface
 */
public class FxView {

    private final Stage primaryStage;
    private final VBox mainVBox;
    private final MenuBar menuBar;
    private final Menu fichier;
    private final Menu edition;
    private final Menu aide;
    private final VBox playersListVBox;
    private final GridPane grid;
    private final HBox buttonsBar;
    private final Button nouvellePartie;
    private final Button passe;
    private final Button arrete;
    private final Button tourner;
    private final int GRIDWIDTH;
    private final int GRIDHEIGHT;
    private final int cellSize = 20;

    /**
     * Creates a new user interface view
     * @param primaryStage the main stage of the view
     * @param GRIDWIDTH the max width of the game's window
     * @param GRIDHEIGHT the max height of the game's window
     */
    public FxView(Stage primaryStage, int GRIDWIDTH, int GRIDHEIGHT) {
        this.primaryStage = primaryStage;

        this.mainVBox = new VBox();

        this.menuBar = new MenuBar();

        this.fichier = new Menu("Fichier");
        this.edition = new Menu("Édition");
        this.aide = new Menu("Aide");

        this.playersListVBox = new VBox();
        this.grid = new GridPane();

        this.buttonsBar = new HBox();

        this.nouvellePartie = new Button("Nouvelle Partie");
        this.passe = new Button("Je passe");
        this.arrete = new Button("J'arrête");
        this.tourner = new Button("Tourner");

        this.GRIDWIDTH = GRIDWIDTH;
        this.GRIDHEIGHT = GRIDHEIGHT;
    }

    /**
     * Initializes the main components of the view
     */
    public void init() {
        int MAXHEIGHT = 700;
        int MAXWIDTH = 1000;
        Scene mainScene = new Scene(this.mainVBox);
        this.menuBar.getMenus().addAll(this.fichier, this.edition, this.aide);
        HBox middleBox = new HBox();
        middleBox.getChildren().addAll(this.playersListVBox, this.grid);
        this.playersListVBox.setPadding(new Insets(10, 10, 10, 10));
        middleBox.setPadding(new Insets(0, 10, 0, 10));
        this.buttonsBar.getChildren().addAll(this.nouvellePartie, this.passe, this.arrete, this.tourner);
        this.buttonsBar.setPadding(new Insets(10, 10, 10, 10));
        this.buttonsBar.setAlignment(Pos.CENTER);
        this.grid.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.grid.setHgap(2);
        this.grid.setVgap(2);
        this.mainVBox.getChildren().addAll(this.menuBar, middleBox, this.buttonsBar);
        this.primaryStage.setScene(mainScene);
        String TITLE = "Blokus";
        this.primaryStage.setTitle(TITLE);
        /*		this.primaryStage.setMinHeight(MAXHEIGHT /2);
		this.primaryStage.setMinWidth(MAXWIDTH /2);*/
        this.primaryStage.setMaxHeight(MAXHEIGHT);
        this.primaryStage.setMaxWidth(MAXWIDTH);
        this.primaryStage.setMinHeight(640);
        this.primaryStage.setMinWidth(750);
        this.primaryStage.getIcons().add(new Image("file:icon.jpg"));
        this.primaryStage.show();
    }

    /**
     * Refreshes the grid containing the game's board
     * @param newGrid the new board that has to be displayed
     */
    public void refreshGrid(ArrayList<ArrayList<Color>> newGrid) {
        this.grid.getChildren().clear();
        this.grid.setAlignment(Pos.CENTER);
        for (int j = 0; j < this.GRIDHEIGHT; j++) {
            for (int i = 0; i < this.GRIDWIDTH; i++) {
                Region cell = new Region();
                cell.setMinSize(cellSize, cellSize);
                if (newGrid.get(j).get(i) == null) {
                    cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    switch (newGrid.get(j).get(i)) {
                        case RED:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case GREEN:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case BLUE:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case YELLOW:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        default:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                    }
                }
                this.grid.add(cell, i, j, 1, 1);
            }
        }
    }

    /**
     * Refreshes the list of players and their stock pieces
     * @param players the list of all player in the game
     */
    public void refreshPlayers(ArrayList<Player> players) {
        this.playersListVBox.getChildren().clear();
        this.playersListVBox.setSpacing(10);
        for (Player player : players) {
            Label playerNickLabel = new Label("Joueur : " + player.getNickname());
            Label playerScoreLabel = new Label("Score : " + player.getScore());
            FlowPane playerStockHBox = new FlowPane();
            playerStockHBox.setHgap(5);
            for (Piece piece : player.getStock()) {
                playerStockHBox.getChildren().add(getPieceGrid(piece, player.getColor()));
            }
            VBox playerVBox = new VBox(playerNickLabel, playerScoreLabel, playerStockHBox);
            playerVBox.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            playerVBox.setPadding(new Insets(5, 5, 5, 5));
            playerVBox.setMinWidth(100);
            playerVBox.setMaxWidth(500);
            this.playersListVBox.getChildren().add(playerVBox);
        }
    }

    /**
     * Retunrs a newly created grid for a piece
     * @param piece the piece
     * @param color the color of the piece
     * @return a newly created grid for a piece
     */
    GridPane getPieceGrid(Piece piece, Color color) {
        GridPane pieceGridPane = new GridPane();
        //pieceGridPane.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        pieceGridPane.setHgap(1);
        pieceGridPane.setVgap(1);
        boolean[] line;
        Region cell;
        for (int j = 0; j < piece.getShape().length; j++) {
            line = piece.getShape()[j];
            for (int i = 0; i < line.length; i++) {
                cell = new Region();
                cell.setMinSize(7, 7);
                if (line[i]) {
                    switch (color) {
                        case BLUE:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case RED:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case GREEN:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case YELLOW:
                            cell.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                    }

                }
                pieceGridPane.add(cell, i, j, 1, 1);
            }
        }
        pieceGridPane.setPadding(new Insets(1, 1, 1, 1));
        pieceGridPane.setCursor(Cursor.HAND);
        return pieceGridPane;
    }
}
