package esi.atl.g44422.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the game class.
 *
 * @author 44422
 */
public class GameTest {

    private Game myGame;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    /**
     * Initializes the tests.
     */
    @Before
    public void initialize() {
        myGame = new Game();
        player1 = new Player("Player 1", Color.BLUE);
        player2 = new Player("Player 2", Color.GREEN);
        player3 = new Player("Player 3", Color.RED);
        player4 = new Player("Player 4", Color.YELLOW);
    }

    /**
     * Tests a new game scenario.
     */
    @Test
    public void newGameTest() {
        myGame.start();
        assertNull(myGame.getWinner());
    }

    /**
     * Tests the add player scenario.
     */
    @Test
    public void addPlayerTest() {
        myGame.getPlayers().clear();
        myGame.addPlayer(player1);
        assertFalse(myGame.getPlayers().isEmpty());
    }

    /**
     * Tests the add player scenario.
     */
    @Test
    public void add1PlayerTest() {
        myGame.getPlayers().clear();
        myGame.addPlayer(player1);
        assertEquals(1, myGame.getPlayers().size());
    }

    /**
     * Tries to start a game without any players.
     */
    @Test(expected = IllegalStateException.class)
    public void startEmptyGameTest() {
        myGame.getPlayers().clear();
        myGame.start();
    }

    /**
     * Tries to start a game with too few players.
     */
    @Test(expected = IllegalStateException.class)
    public void startGameNotEnoughPlayersTest() {
        myGame.addPlayer(player1);
        myGame.start();
    }

    /**
     * Tries to start a game with too many players.
     */
    @Test(expected = IllegalStateException.class)
    public void startGameTooManyPlayersTest() {
        myGame.addPlayer(player1);
        myGame.addPlayer(player2);
        myGame.addPlayer(player3);
        myGame.addPlayer(player4);
        myGame.addPlayer(player1);
    }

    /**
     * Tries to start a game after adding players.
     */
    @Test
    public void addPlayersThenStartTest() {
        myGame.start();
        assertEquals(myGame.getPlayers().get(0), myGame.getCurrentPlayer());
    }

    /**
     * Tries to make a player skip his turn
     */
    @Test
    public void playerSkipsTurnTest() {
        myGame.start();
        myGame.currentPlayerSkips();
        assertEquals(myGame.getPlayers().get(1), myGame.getCurrentPlayer());
    }

}
