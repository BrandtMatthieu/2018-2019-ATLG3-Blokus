package esi.atl.g44422.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

	Position pos1;
	Position pos2;

	@BeforeEach
	void initialize() {
		pos1 = new Position(0, 0);
		pos2 = new Position(0, 0);
	}

	@Test
	void equals() {
		assertTrue(Position.equals(pos1, pos2));
	}

	@Test
	void add2zeros() {
		assertTrue(Position.equals(Position.add(pos1, pos2), new Position(0, 0)));
	}

	@Test
	void add() {
		pos2 = new Position(1, 1);
		assertTrue(Position.equals(Position.add(pos1, pos2), new Position(1, 1)));
	}

	@Test
	void dist() {
		pos2 = new Position(0, 1);
		assertEquals(1, Position.dist(pos1, pos2));
	}

	@Test
	void dist2() {
		pos2 = new Position(1, 1);
		assertNotEquals(1, Position.dist(pos1, pos2));
	}
}