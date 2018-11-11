package esi.atl.g44422.View;

import esi.atl.g44422.Model.Color;
import esi.atl.g44422.Model.Player;

import java.util.Scanner;

/**
 * Represents a console line interface for the game
 */
public class ConsoleView {

    private Scanner sc;

    /**
     * Creates a new command line interface for the game
     */
    public ConsoleView() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Adds a player into the game
     * @return a newly created player
     */
    public Player addPlayer() {
        String nick = "";
        System.out.print("Entrez un nom pour ce joueur:\n> ");
        nick = this.sc.nextLine();
        return new Player(nick, Color.BLUE);
    }

    /**
     * Awaits a command input for the player
     * @param currentPlayer the player who is currently playing
     * @return the command entered by the player
     */
    public String awaitCommand(Player currentPlayer) {
        System.out.print(currentPlayer.getNickname() + ", enter a command :\n> ");
        return this.sc.nextLine().trim();
    }

    /**
     * Prints a welcome message and tells who begins
     * @param player the player who begins
     */
    public void printWelcome(Player player) {
        System.out.println("Welcome in Blokus.\n" +
            "Type \"help\" to get a list of all commands.");
        System.out.println(player.getNickname() + " (aka. " + player.getColor().toString() + "), you begin!");
    }

    /**
     * Prints the infos about the current player
     * @param currentPlayer the current player
     */
    public void printCurrentPlayer(Player currentPlayer) {
        System.out.println(
            "Current player : " + currentPlayer.getNickname() + " (aka. " + currentPlayer.getColor().toString() + ")\n" +
            "Score : " + currentPlayer.getScore() + "\n" +
            "Pieces left : " + currentPlayer.getStock().size() + " piece(s) left\n"
        );
    }

    /**
     * Prints an error message
     * @param str the error message
     */
    public void error(String str) {
        System.out.println("Error:\n" + str + "\n=============");
    }

    /**
     * Prints a line break
     */
    public void breakLine() {
        System.out.println("\n");
    }

    /**
     * Prints the help
     */
    public void printHelp() {
        System.out.println(
            "Help command :\n" +
            "==============\n" +
            "- add/play/put <piece index> <x pos.> <y pos.>\n" +
            "   puts a piece on the board\n" +
            "- skip\n" +
            "   skips your turn\n" +
            "- show/grid\n" +
            "   refreshes/print the board\n" +
            "- stock/score/player" +
            "   prints the score of the current player" +
            "- help\n" +
            "   prints the help pages\n" +
            "- quit/exit\n" +
            "   leaves the game"
        );
    }

    /**
     * Prints the winner of the game
     * @param winner the winner of the game
     */
    public void printWinner(Player winner) {
        System.out.println("Congratulations,\n" +
            "this game's winner is " + winner.getNickname() + ", with color " + winner.getColor().toString() + "\n" +
            "Score : " + winner.getScore() + " points!"
        );
    }

    /**
     * Prints the credits
     */
    public void printCredits() {
        System.out.println(
            "Thanks for playing Blokus.\n" +
            "Made by :\n" +
            "- G44422"
        );
    }
}
