package esi.atl.g44422;

import esi.atl.g44422.Controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Entry point of the application
 * @author matth
 */
public class Main extends Application {

    /**
     * Main method of the program
     * @param args command line args
     */
    public static void main(String args[]) {
        Application.launch(args);
    }

    /**
     * Satrts the javafx app
     * @param primaryStage command line args
     */
    @Override
    public void start(Stage primaryStage) {
        Controller controller = new Controller(primaryStage);
        controller.start();
    }
}
