package esi.atl.g44422.view;

import esi.atl.g44422.model.AIPlayer;
import esi.atl.g44422.model.Game;
import esi.atl.g44422.model.Player;
import esi.atl.g44422.util.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * represents a Fx View for the game (what the user sees)
 */
public class FxView implements Observer {
	private final int MAXHEIGHT = 750;
	private final int MAXWIDTH = 1000;
	private final String TITLE = "Blokus";
	private final Stage primaryStage;
	private final Scene mainScene;
	private final VBox mainVBox;
	private final MenuBar menuBar;
	private final Menu file;
	private final Menu edit;
	private final Menu help;
	private final HBox gameInfoBox;
	private final HBox mainHBox;
	private final VBox playersInfoBoxes;
	private final GridBoard gridBoard;
	private final HBox buttonsBar;
	private final Button newGame;
	private final Button skipTurn;
	private final Button stopGame;
	private final Button turnPiece;
	private final Button flipPiece;
	private Game game;

	/**
	 * Creates a new Fx View
	 *
	 * @param primaryStage the primary stage of the application
	 * @param game         the game
	 */
	public FxView(Stage primaryStage, Game game) {
		this.primaryStage = primaryStage;
		this.game = game;

		this.primaryStage.setTitle(this.TITLE);
		this.primaryStage.setMaxWidth(this.MAXWIDTH);
		this.primaryStage.setMaxHeight(this.MAXHEIGHT);
		this.primaryStage.setMinWidth(870);
		this.primaryStage.setMinHeight(this.MAXHEIGHT);
		this.primaryStage.getIcons().add(new Image("file:icon.jpg"));

		this.mainVBox = new VBox();

		this.menuBar = new MenuBar();
		this.file = new Menu("File");
		this.edit = new Menu("Edit");
		this.help = new Menu("Help");
		this.menuBar.getMenus().addAll(this.file, this.edit, this.help);

		this.gameInfoBox = new HBox();
		this.gameInfoBox.setAlignment(Pos.CENTER);

		this.mainHBox = new HBox();
		this.mainHBox.setAlignment(Pos.CENTER);
		this.playersInfoBoxes = new VBox();
		this.gridBoard = new GridBoard(game);

		this.buttonsBar = new HBox();
		this.newGame = new Button("New Game");
		this.newGame.setOnMouseClicked((event) -> {
			this.game.newGame();
			this.game.start();
		});
		this.skipTurn = new Button("Skip turn");
		this.skipTurn.setOnMouseClicked((event) -> {
			//if(!(game.getCurrentPlayer() instanceof AIPlayer)) {
				this.game.currentPlayerSkips();
			//}
		});
		this.stopGame = new Button("Stop game");
		this.stopGame.setOnMouseClicked((event) -> {
			System.exit(0);
		});
		this.turnPiece = new Button("Turn selected piece");
		this.turnPiece.setOnMouseClicked((event) -> {
			this.game.currentPlayerTurnsPiece();
		});
		this.flipPiece = new Button("Flip selected piece");
		this.flipPiece.setOnMouseClicked((event) -> {
			this.game.currentPlayerFlipsPiece();
		});

		playersInfoBoxes.setSpacing(5);
		this.mainHBox.getChildren().addAll(playersInfoBoxes, gridBoard);
		this.mainHBox.setPadding(new Insets(5, 5, 5, 5));
		this.mainHBox.setSpacing(5);

		this.buttonsBar.getChildren().addAll(this.newGame, this.skipTurn, this.stopGame, this.turnPiece, this.flipPiece);
		this.buttonsBar.setPadding(new Insets(10, 10, 10, 10));
		this.buttonsBar.setSpacing(5);
		this.buttonsBar.setAlignment(Pos.CENTER);

		this.mainVBox.setPadding(new Insets(5, 5, 5, 5));
		this.mainVBox.setSpacing(5);
		this.mainVBox.getChildren().addAll(this.menuBar, this.gameInfoBox, this.mainHBox, this.buttonsBar);
		this.mainScene = new Scene(this.mainVBox);
		this.primaryStage.setScene(mainScene);

		this.primaryStage.show();
	}

	/**
	 * Updates the Fx View
	 */
	@Override
	public void update() {
		this.refreshGameInfo(this.game);
		this.refreshPlayers(this.game.getPlayers());
		this.refreshGrid(this.game);
	}

	/**
	 * Refresh the game infos displayed
	 *
	 * @param game the game
	 */
	private void refreshGameInfo(Game game) {
		this.gameInfoBox.getChildren().clear();
		this.gameInfoBox.getChildren().add(new GameInfoBox(game));
	}

	/**
	 * Refreshes the infos about the players in the game
	 *
	 * @param players the players of the game
	 */
	private void refreshPlayers(ArrayList<Player> players) {
		this.playersInfoBoxes.getChildren().clear();
		for(Player player : players) {
			this.playersInfoBoxes.getChildren().add(new PlayerInfoBox(player, game));
		}
	}

	/**
	 * Refreshes the board of the game
	 *
	 * @param game the game
	 */
	private void refreshGrid(Game game) {
		this.mainHBox.getChildren().set(1, new GridBoard(game));
	}
}
