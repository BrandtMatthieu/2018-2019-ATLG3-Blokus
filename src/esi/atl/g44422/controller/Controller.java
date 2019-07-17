package esi.atl.g44422.Controller;

import esi.atl.g44422.Model.Game;
import esi.atl.g44422.Model.GameInterface;
import esi.atl.g44422.View.ConsoleView;
import esi.atl.g44422.View.FxView;
import javafx.stage.Stage;

/**
 * Represents a controller for the game
 */
public class Controller {

	private final GameInterface game;
	private final ConsoleView consoleView;
	private final FxView fxView;

	/**
	 * Creates a new controller
	 *
	 * @param primaryStage the primary stage of the JavaFx application
	 */
	public Controller(Stage primaryStage) {
		this.game = new Game();

		this.consoleView = new ConsoleView();
		this.game.addObserver(this.consoleView);

		this.fxView = new FxView(primaryStage, (Game) game);
		this.game.addObserver(this.fxView);

		this.game.start();
	}
}
