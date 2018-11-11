package esi.atl.g44422.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
	@Test
	public void playerNickNameTest() {
		Player myPlayer = new Player("Player1", Color.BLUE);
		assertEquals("Player1", myPlayer.getNickname());
	}

	@Test
	public void playerNullScoreTest() {
		Player myPlayer = new Player("Player1", Color.BLUE);
		assertEquals(0, myPlayer.getScore());
	}

	@Test
	public void playerStcokTest() {
		Player myPlayer = new Player("Player1", Color.BLUE);
		assertFalse(myPlayer.getStock().isEmpty());
	}

	@Test
	public void playerColorNullTest() {
		Player myPlayer = new Player("Player1", Color.BLUE);
		assertNotNull(myPlayer.getColor());
	}
}