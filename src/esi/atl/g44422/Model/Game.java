package esi.atl.g44422.Model;

import java.util.ArrayList;

/**
 * Represents a game
 */
public class Game implements GameInterface {

    private final int MAXPLAYERS = 4;

    private final int GRIDWIDTH = 20;
    private final int GRIDHEIGHT = 20;

    private ArrayList<Player> players;

    private Player currentPlayer;
    private Player winner;
    private Board board;

    /**
     * Creates a new Game
     */
    public Game() {
        this.players = new ArrayList<Player>();
        this.board = new Board(this.GRIDWIDTH, this.GRIDHEIGHT);
    }

    /**
     * Returns the maximum of players the game has
     * @return the maximum of players the game has
     */
    public int getMAXPLAYERS() {
        return this.MAXPLAYERS;
    }

    /**
     * Returns the game's grid's width
     * @return the game's grid's width
     */
    public int getGRIDWIDTH() {
        return this.GRIDWIDTH;
    }

    /**
     * Returns the game's grid's height
     * @return  the game's grid's height
     */
    public int getGRIDHEIGHT() {
        return this.GRIDHEIGHT;
    }

    /**
     * Adds a plyaer in the game
     * @param player the player that should be added
     */
    public void addPlayer(Player player) {
        if(this.players.size() > this.getMAXPLAYERS() -1 ) {
            throw new IllegalStateException("Cannot add more than " + this.getMAXPLAYERS() + " players!");
        } else {
            this.players.add(player);
        }
    }

    /**
     * Returns all the game's players
     * @return all the game's players
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * Returns the playing's player
     * @return the playing's player
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Sets the current player
     * Only used when the game begins
     * @param currentPlayer the current player
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Returns the winner of the game
     * @return the winner of the game
     */
    public Player getWinner() {
        return this.winner;
    }

    /**
     * Returns true if the game is done
     * @return true if the game is done
     */
    public boolean isDone() {
        for (Player player : this.players) {
            if (player.getStock().size() == 0) {
                this.winner = player;
                return true;
            }
        }
        return false;
    }

    /**
     * Puts a piece on the board
     * @param piece The piece to put
     * @param pos The position to put the piece on the board.
     */
    public void putPiece(Piece piece, Position pos){
        this.board.putPiece(piece, pos);
    }

    /**
     * Returns the game's board
     * @return the game's board
     */
    public ArrayList<ArrayList<Color>> show() {
        return this.board.getBoard();
    }

    /**
     * Switches to the next player
     */
    public void nextPlayer() {
        this.currentPlayer = this.players.get((this.players.indexOf(this.currentPlayer) + 1) % this.players.size());
    }
}
