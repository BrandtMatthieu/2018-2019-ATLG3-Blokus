package esi.atl.g44422;

import esi.atl.g44422.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Entry point for the program
 */
public class Main extends Application {
	/**
	 * Starts the program
	 *
	 * @param args the console line arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * Starts the JavaFx application
	 *
	 * @param primaryStage the primary stage given by JavaFx
	 */
	public void start(Stage primaryStage) {
		new Controller(primaryStage);
	}
}
