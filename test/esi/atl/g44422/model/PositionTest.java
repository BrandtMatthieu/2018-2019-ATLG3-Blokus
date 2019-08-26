package esi.atl.g44422.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the position class.
 * @author 44422
 */
public class PositionTest {

    private Position pos1;
    private Position pos2;

    /**
     * Initializes all the tests.
     */
    @Before
    public void initialize() {
        pos1 = new Position(0, 0);
        pos2 = new Position(0, 0);
    }

    /**
     * Checks 2 positions are equals.
     */
    @Test
    public void equals() {
        assertTrue(Position.equals(pos1, pos2));
    }

    /**
     * Checks adding 0 to a position doesn't change anything.
     */
    @Test
    public void add2zeros() {
        assertTrue(Position.equals(Position.add(pos1, pos2), new Position(0, 0)));
    }

    /**
     * Checks the adding function.
     */
    @Test
    public void add() {
        pos2 = new Position(1, 1);
        assertTrue(Position.equals(Position.add(pos1, pos2), new Position(1, 1)));
    }

    /**
     * Checks the distance function.
     */
    @Test
    public void dist() {
        pos2 = new Position(0, 1);
        assertEquals(1, Position.dist(pos1, pos2), 0);
    }

    /**
     * Checks the distance function.
     */
    @Test
    public void dist2() {
        pos2 = new Position(1, 1);
        assertNotEquals(1, Position.dist(pos1, pos2));
    }
}
