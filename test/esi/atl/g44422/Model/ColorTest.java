package esi.atl.g44422.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {
	@Test
	public void colorRedTest() {
		assertEquals("Red", Color.RED.toString());
	}

	@Test
	public void colorBlueTest() {
		assertEquals("Blue", Color.BLUE.toString());
	}

	@Test
	public void colorGreenTest() {
		assertEquals("Green", Color.GREEN.toString());
	}

	@Test
	public void colorYellowTest() {
		assertEquals("Yellow", Color.YELLOW.toString());
	}
}