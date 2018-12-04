package esi.atl.g44422.Model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

 class GameTest {

	Game myGame;
	AIPlayer player1;
	AIPlayer player2;
	AIPlayer player3;
	AIPlayer player4;

	@BeforeEach
	 void initialize() {
		myGame = new Game();
		player1 = (AIPlayer) new Player("Player 1", Color.BLUE);
		player2 = (AIPlayer) new Player("Player 2", Color.GREEN);
		player3 = (AIPlayer) new Player("Player 3", Color.RED);
		player4 = (AIPlayer) new Player("Player 4", Color.YELLOW);
	}

	@Test
	 void newGameTest() {
		myGame.addPlayer(player1);
		assertNull(myGame.getWinner());
	}

	@Test
	 void addPlayerTest() {
		myGame.addPlayer(player1);
		assertFalse(myGame.getPlayers().isEmpty());
	}

	@Test
	 void add1PlayerTest() {
		myGame.addPlayer(player1);
		assertEquals(1, myGame.getPlayers().size());
	}

	@Test
	 void startEmptyGameTest() {
		assertThrows(IllegalStateException.class, () -> {
			myGame.start();
		});
	}

	@Test
	 void startGameNotEnoughPlayersTest() {
		myGame.addPlayer(player1);
		assertThrows(IllegalStateException.class, () -> {
			myGame.start();
		});
	}

	@Test
	 void startGameTooManyPlayersTest() {
		myGame.addPlayer(player1);
		myGame.addPlayer(player2);
		myGame.addPlayer(player3);
		myGame.addPlayer(player4);
		assertThrows(IllegalStateException.class, () -> {
			myGame.addPlayer(player1);
		});
	}

	@Test
	 void addPlayersThenStartTest() {
		myGame.addPlayer(player1);
		myGame.addPlayer(player2);
		myGame.addPlayer(player3);
		myGame.addPlayer(player4);
		myGame.start();
		assertEquals(player1, myGame.getCurrentPlayer());
	}

	@Test
	 void playerPutsPieceTest() {
		myGame.addPlayer(player1);
		myGame.addPlayer(player2);
		myGame.addPlayer(player3);
		myGame.addPlayer(player4);
		assertThrows(IllegalArgumentException.class, () -> {
			myGame.currentPlayerPutsPiece(-1);
		});
	}

	@Test
	 void playerSkipsTurnTest() {
		myGame.addPlayer(player1);
		myGame.addPlayer(player2);
		myGame.addPlayer(player3);
		myGame.addPlayer(player4);
		myGame.start();
		myGame.currentPlayerSkips();
		assertEquals(player2, myGame.getCurrentPlayer());
	}

}
