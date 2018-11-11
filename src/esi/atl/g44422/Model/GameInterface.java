package esi.atl.g44422.Model;

import java.util.ArrayList;

/**
 * A simplified view of the game
 */
public interface GameInterface {

    /**
     * Adds a plyaer in the game
     * @param player the player that should be added
     */
    void addPlayer(Player player);

    /**
     * Returns the playing's player
     * @return the playing's player
     */
    Player getCurrentPlayer();
    
    /**
     * Sets the current player
     * Only used when the game begins
     * @param currentPlayer the current player
     */
    void setCurrentPlayer(Player currentPlayer);

    /**
     * Returns all the game's players
     * @return all the game's players
     */
    ArrayList<Player> getPlayers();

    /**
     * Returns the winner of the game
     * @return the winner of the game
     */
    Player getWinner();

    /**
     * Returns true if the game is done
     * @return true if the game is done
     */
    boolean isDone();

    /**
     * Puts a piece on the board
     * @param piece The piece to put
     * @param pos The position to put the piece on the board.
     */
    void putPiece(Piece piece, Position pos);

    /**
     * Returns the game's board
     * @return the game's board
     */
    ArrayList<ArrayList<Color>> show();

    /**
     * Switches to the next player
     */
    void nextPlayer();

    /**
     * Returns the maximum of players the game has
     * @return the maximum of players the game has
     */
    int getMAXPLAYERS();

    /**
     * Returns the game's grid's width
     * @return the game's grid's width
     */
    int getGRIDWIDTH();

    /**
     * Returns the game's grid's height
     * @return  the game's grid's height
     */
    int getGRIDHEIGHT();
}
