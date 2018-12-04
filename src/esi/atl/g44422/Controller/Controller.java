package esi.atl.g44422.Controller; // package en minuscule

import esi.atl.g44422.Model.*;
import esi.atl.g44422.View.*;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Controller {
	private final GameInterface game;
	private final FxView fxView;
	private final ConsoleView consoleView;

	public Controller(Stage primarystage) {
		this.game = new Game();

		this.fxView = new FxView(primarystage, (Game) game, this);
		this.consoleView = new ConsoleView();

		this.start();
	}

	private void start() {
		game.addPlayer(new Player("Human", Color.BLUE));
		game.addPlayer(new AIPlayer("BOT 1", Color.GREEN));
		game.addPlayer(new AIPlayer("BOT 2", Color.RED));
		game.addPlayer(new AIPlayer("BOT 3", Color.YELLOW));
			Platform.runLater(() -> {
				fxView.update();
			});
			/*
		while (!game.isDone()) {
		}
		*/
	}

	public void placePieceHereEvent(int x, int y) {

	}
}
