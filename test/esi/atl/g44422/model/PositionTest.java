package esi.atl.g44422.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

	private Position pos1;
	private Position pos2;

	@Before
	public void initialize() {
		pos1 = new Position(0, 0);
		pos2 = new Position(0, 0);
	}

	@Test
	public void equals() {
		assertTrue(Position.equals(pos1, pos2));
	}

	@Test
	public void add2zeros() {
		assertTrue(Position.equals(Position.add(pos1, pos2), new Position(0, 0)));
	}

	@Test
	public void add() {
		pos2 = new Position(1, 1);
		assertTrue(Position.equals(Position.add(pos1, pos2), new Position(1, 1)));
	}

	@Test
	public void dist() {
		pos2 = new Position(0, 1);
		assertEquals(1, Position.dist(pos1, pos2), 0);
	}

	@Test
	public void dist2() {
		pos2 = new Position(1, 1);
		assertNotEquals(1, Position.dist(pos1, pos2));
	}
}
