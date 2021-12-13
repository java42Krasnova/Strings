package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * V.R. OK
 */
class TestsClassStringBuilder {

	final StringBuilder strBilderTest = new StringBuilder("Happy");

	@Test
	void testAppendString() {
		String strForAppend = " New Year";
		String exp = "Happy New Year";
		assertEquals(exp, strBilderTest.append(strForAppend).toString());
	}

	@Test
	void testReplaceIntIntString() {
		assertEquals("Hungry", strBilderTest.replace(1, 4, "ungr").toString());
	}

	@Test
	void testInsertIntString() {
		strBilderTest.insert(2, "pPY");
		assertEquals("HapPYppy", strBilderTest.toString());
	}

	@Test
	void testReverse() {
		StringBuilder anagram = new StringBuilder("a rozA upala Na lapU azoRa");
		String exp = "aRoza Upal aN alapu Azor a";
		assertEquals(exp, anagram.reverse().toString());

	}

}
