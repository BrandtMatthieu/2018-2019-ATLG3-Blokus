package esi.atl.g44422.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
	@Test
	public void positionXTest() {
		Position pos = new Position(0, 0);
		assertEquals(0, pos.getX());
	}

	@Test
	public void positionYTest() {
		Position pos = new Position(0, 0);
		assertEquals(0, pos.getX());
	}

	@Test
	public void positionXTest2() {
		Position pos = new Position(1, 1);
		assertEquals(1, pos.getX());
	}

	@Test
	public void positionYTest2() {
		Position pos = new Position(1, 1);
		assertEquals(1, pos.getX());
	}
}