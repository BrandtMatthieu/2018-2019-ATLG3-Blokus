package esi.atl.g44422.Model;

import esi.atl.g44422.Util.*;

import java.util.ArrayList;

public class Game implements GameInterface {

    private final int SIZEX = 20;
    private final int SIZEY = 20;
    private final int numberRequiredPlayers = 4;

    private ArrayList<Observer> observers;

    private ArrayList<Player> players;
    private final Board board;
    private Player winner;
    private Player currentPlayer;
    // selectedPiece (ou dans player)

    public Game() {
        this.players = new ArrayList<>();
        this.board = new Board(SIZEX, SIZEY);
        this.winner = null;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getWinner() {
        return this.winner;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public int getNumberRequiredPlayers() {
        return numberRequiredPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Le nouveau joueur ne peut pas être null.");
        } else if (this.players.size() >= numberRequiredPlayers) {
            throw new IllegalStateException("Il ne peut pas y avoir plus que " + numberRequiredPlayers + " joueurs.");
        } else {
            this.players.add(player);
        }
    }

    public void start() {
        if (this.players.isEmpty()) {
            throw new IllegalStateException("Cannot begin the game without any player");
        } else if (this.players.size() != numberRequiredPlayers) {
            throw new IllegalStateException("Cannot begin the game when there is not enough players");
        } else {
            this.currentPlayer = this.players.get(0);
        }
    }

    public boolean isDone() {
        return false;
    }

    public void currentPlayerPutsPiece(int index) { 
/*
        - selectPiece(int index)
        - play(int x, int y) 
        - canPlay(int x, int y)
*/
        if (index < 0) {
            throw new IllegalArgumentException("Piece index cannot be negative");
        } else {
            this.board.put(this.currentPlayer.getStock().get(index));
            this.currentPlayer.put(index);
        }
    }

    public void currentPlayerSkips() {
        this.currentPlayer.skip();
        nextPlayer();
    }

    void nextPlayer() {
        this.currentPlayer = this.players.get((this.players.indexOf(this.currentPlayer) + 1) % this.numberRequiredPlayers);
    }

    @Override
    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        this.observers.remove(obs);
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
