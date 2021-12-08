package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsClassString {
	
	final String strTest = "WorLd of DreaM";
	@BeforeEach
	void setUp() throws Exception {
	
	}

	@Test
	void testCharAt() {
		// "WorLd of DreaM";
		assertEquals('W', strTest.charAt(0));
		assertEquals('r', strTest.charAt(2));
		assertEquals(111, strTest.charAt(1));
	}

	@Test
	void testEqualsIgnoreCase() {
		// "WorLd of DreaM";
		assertTrue(strTest.equalsIgnoreCase("world of Dream"));
		assertFalse(strTest.equalsIgnoreCase("word of dreaM"));
	}

	@Test
	void testCompareToIgnoreCase() {
		// "WorLd of DreaM";
		assertEquals(0, strTest.compareToIgnoreCase("world of dream"));
		assertEquals(2, strTest.compareToIgnoreCase("world of DRE"));
		assertEquals(-3, strTest.compareToIgnoreCase("world of dreamsss"));
	}

	@Test
	void testStartsWithStringInt() {
		// "WorLd of DreaM";
		assertTrue(strTest.startsWith(" of", 5));
		assertFalse(strTest.startsWith("ld", 3));
		assertFalse(strTest.startsWith("world", 1));

	}

	@Test
	void testStartsWithString() {
		// "WorLd of DreaM";
		assertTrue(strTest.startsWith("Wor"));
		assertFalse(strTest.startsWith("wor"));
		assertFalse(strTest.startsWith("dream"));

	}

	@Test
	void testEndsWith() {
		// "WorLd of DreaM";
		assertFalse(strTest.endsWith("Dream"));
		assertTrue(strTest.endsWith("DreaM"));
		assertFalse(strTest.endsWith("ord"));
	}

	@Test
	void testIndexOfInt() {
		// "WorLd of DreaM";
		assertEquals(1,strTest.indexOf(111));//'O'
		assertEquals(-1,strTest.indexOf('F'));
	}

	@Test
	void testIndexOfIntInt() {
		// "WorLd of DreaM";
		assertEquals(6, strTest.indexOf('o', 2 ));
		assertEquals(1, strTest.indexOf('o', 0 ));
		assertEquals(-1, strTest.indexOf('W', 5));

	}

	@Test
	void testLastIndexOfIntInt() {
		// "WorLd of DreaM";
		assertEquals(6, strTest.lastIndexOf('o', strTest.length()-1 ));
		assertEquals(1,  strTest.lastIndexOf('o', 5));
	}

	@Test
	void testIndexOfString() {
		// "WorLd of DreaM";
		assertEquals(5, strTest.indexOf(" "));
		assertEquals(6, strTest.indexOf("of "));

	}

	@Test
	void testIndexOfStringInt() {
		// "WorLd of DreaM";
		assertEquals(-1, strTest.indexOf('O'));
		assertEquals(1, strTest.indexOf('o') );
	}

	@Test
	void testSubstringInt() {
		// "WorLd of DreaM";
		assertEquals("DreaM", strTest.substring(9));
	}

	@Test
	void testSubstringIntInt() {
		// "WorLd of DreaM";
		assertEquals("of", strTest.substring(6, 8));
	}

	@Test
	void testContains() {
		// "WorLd of DreaM";
		assertFalse(strTest.contains("World"));
		assertTrue(strTest.contains("of Drea"));
	}

	@Test
	void testJoinCharSequenceCharSequenceArray() {
		String[] arrStr = {"the","weather","is","bad"};
		assertEquals("the__weather__is__bad",strTest.join("__",arrStr));
	}
	@Test
	void testToLowerCase() {
		assertEquals("world of dream", strTest.toLowerCase());
	}

	@Test
	void testTrim() {
		String str= "  WorLd of DreaM  ";
		String strEnd = "WorLd of DreaM  ";
		assertEquals("WorLd of DreaM", str.trim());
		assertEquals("WorLd of DreaM", strEnd.trim());
	}

	@Test
	void testToCharArray() {
		String woRd = "woRd";
		char[] exp = {'w','o','R','d'};
		assertArrayEquals(exp, woRd.toCharArray());
	}

	@Test
	void testFormatStringObjectArray() {
		String f = "My home addres %s %s %s %s 13.";
		String[] objFormat = {"is", "Ashkelon", "Ben", "Gurion"};
		assertEquals("My home addres is Ashkelon Ben Gurion 13.", String.format(f, objFormat));
	}

}
