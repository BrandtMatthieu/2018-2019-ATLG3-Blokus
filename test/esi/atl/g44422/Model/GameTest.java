package esi.atl.g44422.model;

import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {

	Game myGame;
	Player player1;
	Player player2;
	Player player3;
	Player player4;

	@Before
	public void initialize() {
		myGame = new Game();
		player1 = new Player("Player 1", Color.BLUE);
		player2 = new Player("Player 2", Color.GREEN);
		player3 = new Player("Player 3", Color.RED);
		player4 = new Player("Player 4", Color.YELLOW);
	}

	@Test
	public void newGameTest() {
		myGame.start();
		assertNull(myGame.getWinner());
	}

	@Test
	public void addPlayerTest() {
		myGame.getPlayers().clear();
		myGame.addPlayer(player1);
		assertFalse(myGame.getPlayers().isEmpty());
	}

	@Test
	public void add1PlayerTest() {
		myGame.getPlayers().clear();
		myGame.addPlayer(player1);
		assertEquals(1, myGame.getPlayers().size());
	}

	@Test(expected = IllegalStateException.class)
	public void startEmptyGameTest() {
		myGame.getPlayers().clear();
		myGame.start();
	}

	@Test(expected = IllegalStateException.class)
	public void startGameNotEnoughPlayersTest() {
		myGame.addPlayer(player1);
		myGame.start();
	}

	@Test(expected = IllegalStateException.class)
	public void startGameTooManyPlayersTest() {
		myGame.addPlayer(player1);
		myGame.addPlayer(player2);
		myGame.addPlayer(player3);
		myGame.addPlayer(player4);
		myGame.addPlayer(player1);
	}

	@Test
	public void addPlayersThenStartTest() {
		myGame.start();
		assertEquals(myGame.getPlayers().get(0), myGame.getCurrentPlayer());
	}

	@Test
	public void playerSkipsTurnTest() {
		myGame.start();
		myGame.currentPlayerSkips();
		assertEquals(myGame.getPlayers().get(1), myGame.getCurrentPlayer());
	}

}
