package esi.atl.g44422.Model;

import org.junit.Test;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;

public class GameTest {
 	@Test
	public void addPlayerTest() {
	 	Game myGame = new Game();
	 	myGame.addPlayer(new Player("Player1", Color.BLUE));
	 	assertEquals(1, myGame.getPlayers().size());
	 }

	@Test
	public void addPlayerTest2() {
		Game myGame = new Game();
		myGame.addPlayer(new Player("Player1", Color.BLUE));
		myGame.setCurrentPlayer(myGame.getPlayers().get(0));
		assertEquals("Player1", myGame.getCurrentPlayer().getNickname());
	}

	@Test
	public void setCurrentPlayerTest() {
 		Game myGame = new Game();
 		Player myPlayer = new Player("Player1", Color.BLUE);
		myGame.addPlayer(myPlayer);
		myGame.setCurrentPlayer(myGame.getPlayers().get(0));
		assertEquals(myPlayer, myGame.getCurrentPlayer());
	}

	@Test
	public void newGameIsNotDoneTest() {
		Game myGame = new Game();
		assertFalse(myGame.isDone());
	}

	@Test
	public void newGameIsNotDoneTest2() {
		Game myGame = new Game();
		Player myPlayer = new Player("Player1", Color.BLUE);
		myGame.addPlayer(myPlayer);
		myGame.setCurrentPlayer(myGame.getPlayers().get(0));
		assertFalse(myGame.isDone());
	}

	@Test
	public void gameIsDoneTest() {
		Game myGame = new Game();
		Player myPlayer = new Player("Player1", Color.BLUE);
		myPlayer.getStock().clear();
		myGame.addPlayer(myPlayer);
		myGame.setCurrentPlayer(myGame.getPlayers().get(0));
		assertTrue(myGame.isDone() && myGame.getCurrentPlayer().getStock().isEmpty());
	}

	@Test
	public void nextPlayerTest() {
		Game myGame = new Game();
		Player myPlayer = new Player("Player1", Color.BLUE);
		myGame.addPlayer(myPlayer);
		myGame.setCurrentPlayer(myGame.getPlayers().get(0));
		myGame.nextPlayer();
		assertEquals(myPlayer, myGame.getCurrentPlayer());
	}

	@Test
	public void nextPlayerTest2() {
		Game myGame = new Game();
		Player myPlayer = new Player("Player1", Color.BLUE);
		Player myPlayer2 = new Player("Player2", Color.RED);
		myGame.addPlayer(myPlayer);
		myGame.addPlayer(myPlayer2);
		myGame.setCurrentPlayer(myGame.getPlayers().get(0));
		myGame.nextPlayer();
		assertEquals(myPlayer2, myGame.getCurrentPlayer());
	}

	@Test(expected = IllegalStateException.class)
	public void maxPlayersRespectedTest() {
		Game myGame = new Game();
		Player myPlayer = new Player("Player1", Color.BLUE);
		for(int i = 0; i < myGame.getMAXPLAYERS() + 1; i++) {
			myGame.addPlayer(myPlayer);
		}
	}

	@Test
	public void winGame() {
		Game myGame = new Game();
		Player myPlayer = new Player("Player1", Color.BLUE);
		myGame.addPlayer(myPlayer);
		myGame.setCurrentPlayer(myGame.getPlayers().get(0));
		while(!myPlayer.getStock().isEmpty()) {
			myGame.putPiece(myGame.getCurrentPlayer().getStock().get(0), new Position(10, 10));
			myGame.getCurrentPlayer().addPutPiece(myGame.getCurrentPlayer().getStock().get(0));
			myGame.getCurrentPlayer().getStock().remove(myGame.getCurrentPlayer().getStock().get(0));
		}
		myGame.isDone();
		assertEquals(myPlayer, myGame.getWinner());
	}

	@Test
	public void winGame2() {
		Game myGame = new Game();
		Player myPlayer = new Player("Player1", Color.BLUE);
		myGame.addPlayer(myPlayer);
		myGame.setCurrentPlayer(myGame.getPlayers().get(0));
		while(!myPlayer.getStock().isEmpty()) {
			myGame.putPiece(myGame.getCurrentPlayer().getStock().get(0), new Position(10, 10));
			myGame.getCurrentPlayer().addPutPiece(myGame.getCurrentPlayer().getStock().get(0));
			myGame.getCurrentPlayer().getStock().remove(myGame.getCurrentPlayer().getStock().get(0));
		}
		myGame.isDone();
		assertEquals(90, myGame.getWinner().getScore());
	}
}
