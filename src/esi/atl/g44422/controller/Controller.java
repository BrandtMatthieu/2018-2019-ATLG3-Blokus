package esi.atl.g44422.controller;

import esi.atl.g44422.model.Game;
import esi.atl.g44422.model.GameInterface;
import esi.atl.g44422.view.ConsoleView;
import esi.atl.g44422.view.FxView;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


/**
 * Represents a controller for the game.
 */
public class Controller {
	/**
	 * The new game created by the controller.
	 */
	private final GameInterface game;

	/**
	 * The console view of the app.
	 */
	private final ConsoleView consoleView;

	/**
	 * The GUI view of the app.
	 */
	private final FxView fxView;

	/**
	 * Creates a new controller.
	 *
	 * @param primaryStage the primary stage of the JavaFx application
	 */
	public Controller(final Stage primaryStage) {
		this.game = new Game();

		this.consoleView = new ConsoleView();
		this.game.addObserver(this.consoleView);

		this.fxView = new FxView(primaryStage, game);
		this.game.addObserver(this.fxView);

		this.newGame();
	}

	/**
	 * Starts the controller.
	 */
	public void start() {
		this.game.start();
	}

	/**
	 * Adds listeners to the buttons.
	 */
	private void newGame() {
		/*
		 * Adds listener to the "new game" button.
		 */
		fxView.getButtonsBar().getNewGame().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			this.game.newGame();
			this.fxView.newGame();
			this.newGame();
			this.game.start();
		});

		/*
		 * Adds listener to the "new game" button.
		 */
		fxView.getButtonsBar().getSkipTurn().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			this.game.currentPlayerSkips();
			this.game.aiPlayersPlay();
		});

		/*
		 * Adds listener to the "stop game" button.
		 */
		fxView.getButtonsBar().getStopGame().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			System.exit(0);
		});

		/*
		 * Adds listener to the "turn piece" button.
		 */
		fxView.getButtonsBar().getTurnPiece().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			this.game.currentPlayerTurnsPiece();
		});

		/*
		 * Adds listener to the "flip piece" button.
		 */
		fxView.getButtonsBar().getFlipPiece().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			this.game.currentPlayerFlipsPiece();
		});

		/*
		 * Adds listener to the "history" button.
		 */
		fxView.getMenuBox().getHistory().addEventHandler(Event.ANY, event -> {
			this.fxView.showHistory();
			this.fxView.getHistoryWindow().addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, event2 -> {
				this.fxView.closeHistory();
			});
		});

		this.fxView.getMenuBox().getEdit().addEventHandler(Event.ANY, event -> {
		});
		this.fxView.getMenuBox().getFile().addEventHandler(Event.ANY, event -> {
		});
		this.fxView.getMenuBox().getHelp().addEventHandler(Event.ANY, event -> {
		});
	}
}
