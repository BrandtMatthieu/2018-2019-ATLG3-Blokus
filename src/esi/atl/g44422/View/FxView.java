package esi.atl.g44422.View;

import esi.atl.g44422.Controller.Controller;
import esi.atl.g44422.Model.*;
import esi.atl.g44422.Util.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FxView implements Observer {
    // sortir les classes dans ds ficheirs séparés
	private final Game game;
	private final Controller controller;

	private final int MAXHEIGHT = 700;
	private final int MAXWIDTH = 1000;
	private final String TITLE = "Blokus";

	private final Stage primaryStage;

	private final VBox mainVBox = new VBox();

	private final MenuBar menuBar = new MenuBar();
	private final Menu fichier = new Menu("Fichier");
	private final Menu edition = new Menu("Édition");
	private final Menu aide = new Menu("Aide");

	private final HBox mainHBox = new HBox();
	private final VBox playersInfoBoxes = new VBox();
	private GridBoard gridBoard = new GridBoard();

	private final HBox buttonsBar = new HBox();
	private final Button nouvellePartie = new Button("Nouvelle Partie");
	private final Button passe = new Button("Je passe");
	private final Button arrete = new Button("J'arrête");
	private final Button tourner = new Button("Tourner");

	public FxView(Stage primaryStage, Game game, Controller controller) {

		this.game = game;
		this.controller = controller;

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(this.TITLE);
		this.primaryStage.setMaxHeight(this.MAXHEIGHT);
		this.primaryStage.setMaxWidth(this.MAXWIDTH);
		this.primaryStage.setMinHeight(640);
		this.primaryStage.setMinWidth(750);
		this.primaryStage.getIcons().add(new Image("file:icon.jpg"));

		this.menuBar.getMenus().addAll(this.fichier, this.edition, this.aide);

		playersInfoBoxes.setSpacing(5);
		this.mainHBox.getChildren().addAll(playersInfoBoxes, gridBoard);
		this.mainHBox.setPadding(new Insets(5,5,5,5));

		this.buttonsBar.getChildren().addAll(this.nouvellePartie, this.passe, this.arrete, this.tourner);
		this.buttonsBar.setPadding(new Insets(10, 10, 10, 10));
		this.buttonsBar.setSpacing(5);
		this.buttonsBar.setAlignment(Pos.CENTER);

		this.mainVBox.getChildren().addAll(this.menuBar, this.mainHBox, this.buttonsBar);
		Scene mainScene = new Scene(this.mainVBox);
		this.primaryStage.setScene(mainScene);

		this.primaryStage.show();
	}

	@Override
	public void update() {
		refreshPlayers(this.game.getPlayers());
		refreshGrid(this.game.getBoard(), this.controller);
	}

	private void refreshPlayers(ArrayList<Player> players) {
		this.playersInfoBoxes.getChildren().clear();
		for (Player player : players) {
			this.playersInfoBoxes.getChildren().add(new PlayerInfoBox(player));
		}
	}

	private void refreshGrid(Board board, Controller controller) {
		this.gridBoard = new GridBoard(board, controller);
	}
}

class PlayerInfoBox extends FlowPane {
	Label playerNickname;
	Label playerScore;
	FlowPane playerStock;

	public PlayerInfoBox(Player player) {
		this.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.playerNickname = new Label("Joueur : " + player.getNickname());
		this.playerScore = new Label("Score : " + player.getScore());
		this.playerStock = new FlowPane();
		displayStock(player);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(playerNickname, playerScore, playerStock);
		this.getChildren().add(vbox);
		this.setPadding(new Insets(5, 5, 5, 5));
	}

	private void displayStock(Player player) {
		for(Piece piece : player.getStock()) {
			this.playerStock.getChildren().add(pieceAsGrid(piece, player.getColor()));
		}
	}

	private GridPane pieceAsGrid(Piece piece, Color color) {
		GridPane pieceAsGrid = new GridPane();
		pieceAsGrid.setPadding(new Insets(5, 5, 5, 5));
		pieceAsGrid.setHgap(1);
		pieceAsGrid.setVgap(1);
		pieceAsGrid.setCursor(Cursor.HAND);
		for(Position cell : piece.getCells()) {
			Pane pieceCell = new Pane();
			pieceCell.setPrefSize(7,7);
			javafx.scene.paint.Color fillColor;
			switch (color) {
				case RED:
					fillColor = javafx.scene.paint.Color.RED;
					break;
				case BLUE:
					fillColor = javafx.scene.paint.Color.BLUE;
					break;
				case GREEN:
					fillColor = javafx.scene.paint.Color.GREEN;
					break;
				case YELLOW:
					fillColor = javafx.scene.paint.Color.YELLOW;
					break;
				default:
					fillColor = javafx.scene.paint.Color.TRANSPARENT;
			}
			Background background = new Background(new BackgroundFill(fillColor, CornerRadii.EMPTY, Insets.EMPTY));
			pieceCell.setBackground(background);
			pieceAsGrid.add(pieceCell, cell.getX(), cell.getY());
		}
		return  pieceAsGrid;
	}
}

class GridBoard extends GridPane {
	public GridBoard() {
		this.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	public GridBoard(Board board, Controller controller) {
		this.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setHgap(1);
		this.setVgap(1);

		initGrid(board, controller);
		putPieces(board.getPiecesPut());
	}

	private void initGrid(Board board, Controller controller) {
		this.getChildren().clear();
		for(int j = 0; j < board.getSizeY(); j++) {
			for(int i = 0; i < board.getSizeX(); i++) {
				//this.getChildren().add();
			}
		}
	}

	private void putPieces(ArrayList<Piece> piecesPut) {
		for(Piece piece : piecesPut) {
			for(Position pos : piece.getCells()) {
				//this.add();
			}
		}
	}
}

class ClickablePane extends Region {
	int posX;
	int posY;

	ClickablePane(int posX, int posY, Controller controller) {
		this.setPrefSize(5,5);
		this.setMinSize(5, 5);
		this.setHeight(5);
		this.setWidth(5);

		this.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.posX = posX;
		this.posY = posY;
		/*this.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardEventHandler(){
			public void handle(KeyEvent event) {
				controller.placePieceHereEvent(posX, posY);
			}
		}, this.posX, this.posY);
		*/
	}

}
