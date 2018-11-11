package esi.atl.g44422.Controller;

import esi.atl.g44422.Model.*;
import esi.atl.g44422.View.*;

import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Controls the flow of the game
 */
public class Controller {

    private final GameInterface game;
    private final FxView fxView;
    private final ConsoleView consoleView;

    /**
     * Creates anew Controller
     * @param primaryStage the main stage of the application for the user interface
     */
    public Controller(Stage primaryStage) {
        this.game = new Game();
        this.fxView = new FxView(primaryStage, this.game.getGRIDWIDTH(), this.game.getGRIDHEIGHT());
        this.consoleView = new ConsoleView();
    }

    /**
     * Starts the game
     */
    public void start() {
        this.fxView.init();

        this.game.addPlayer(new Player("Player1", Color.BLUE));
        this.game.addPlayer(new Player("Player2", Color.GREEN));
        this.game.addPlayer(new Player("Player3", Color.RED));
        this.game.addPlayer(new Player("Player4", Color.YELLOW));
        this.game.setCurrentPlayer(this.game.getPlayers().get(0));

        this.fxView.refreshGrid(game.show());
        this.fxView.refreshPlayers(game.getPlayers());
        this.consoleView.printWelcome(this.game.getCurrentPlayer());
        new Thread(() -> {
            do {
                handleCommand(consoleView.awaitCommand(this.game.getCurrentPlayer()));
            } while (!game.isDone());
            this.consoleView.printWinner(this.game.getWinner());
        }).start();
    }

    private void handleCommand(String command) {
        command = command.trim().toLowerCase();
        ArrayList<String> args = new ArrayList<String>(Arrays.asList(command.split(" ")));
        command = args.get(0);
        args.remove(0);
        switch (command) {
            case "add":
            case "play":
            case "put":
                play(command, args);
                break;
            case "turn":
            case "rotate":
                // rotates the selected piece
                break;
            case "flip":
                // flips the selected piece
                break;
            case "skip":
            case "pass":
                this.game.nextPlayer();
                break;
            case "show":
            case "grid":
                show(command, args);
                break;
            case "stock":
            case "score":
            case "player":
                stock(command, args);
                break;
            case "help":
                this.consoleView.printHelp();
                break;
            case "exit":
            case "quit":
                this.consoleView.printCredits();
                System.exit(0);
                break;
            default:
                this.consoleView.error("Unknown command.\nType \"help\" to get a list of all available commands");
        }

        Platform.runLater(() -> {
            fxView.refreshGrid(this.game.show());
            fxView.refreshPlayers(this.game.getPlayers());
        });

        this.consoleView.breakLine();
    }

    private void play(String command, ArrayList<String> args) {
        if(args.size() != 3) {
            this.consoleView.error("Missing argument.\nCorrect syntax: <piece index> <x pos.> <y pos.>");
            return;
        }
        if(!(isInteger(args.get(0)) && isInteger(args.get(0)) && isInteger(args.get(0)))) {
            this.consoleView.error("One of the arguments isn't an integer.\nAll arguments must be integers");
            return;
        }
        if(parseInt(args.get(1)) < 1 || parseInt(args.get(2)) < 1 || parseInt(args.get(1)) > this.game.getGRIDWIDTH() || parseInt(args.get(2)) > this.game.getGRIDHEIGHT()) {
            this.consoleView.error("One of the arguments isn't betwwen acceped bounds.\nPiece index must be between 1 and " + this.game.getCurrentPlayer().getStock().size() + ".\n" +
                "The position arguments must be between 1 and " + this.game.getGRIDWIDTH() + ".");
            return;
        }
        this.game.putPiece(this.game.getCurrentPlayer().getStock().get(parseInt(args.get(0)) - 1), new Position(parseInt(args.get(1)) - 1, parseInt(args.get(2)) - 1));
        this.game.getCurrentPlayer().addPutPiece(this.game.getCurrentPlayer().getStock().get(parseInt(args.get(0)) - 1));
        this.game.getCurrentPlayer().getStock().remove(this.game.getCurrentPlayer().getStock().get(parseInt(args.get(0)) - 1));
        this.game.nextPlayer();
        return;
    }

    private void show(String command, ArrayList<String> args) {

    }

    private void stock(String command, ArrayList<String> args) {
        Platform.runLater(() -> {
            consoleView.printCurrentPlayer(this.game.getCurrentPlayer());
        });
    }

    private boolean isInteger(String str) {
        return str.matches("-?\\d+");
    }
}
