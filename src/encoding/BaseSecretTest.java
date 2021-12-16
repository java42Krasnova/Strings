package encoding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseSecretTest {
	BaseSecret bs = new BaseSecret();

	@BeforeEach
	void setUp() throws Exception {

	}
	void testToBinaryString() {
		assertEquals("100", BaseSecret.toDigString(4,2));
	}

	@Test
	void testToDecimalString() {
		assertEquals("123", BaseSecret.toDigString(123,10));
	}

	@Test
	void testParseIntBinary() {
		assertEquals(4, BaseSecret.parseDig("100",2));
	}

	@Test
	void testParseIntDecimal() {
		assertEquals(4, BaseSecret.parseDig("4",10));
	}

	@Test
	void testToSecretString() {
		boolean fl = false;
		try {
			bs.setSectet(".-");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			fl = true;
		}
		assertFalse(fl);
		assertEquals("-..", bs.toSecretString(4));
		fl = false;
		try {
			bs.setSectet("j");// to short
		} catch (IllegalArgumentException e) {
			System.out.println(e);

			fl = true;
		}
		assertTrue(fl);
		fl = false;
		try {
			bs.setSectet("mmm");// not unique key for ciphering
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			fl = true;
		}
		assertTrue(fl);
	}

	@Test
	void testMatches() {
		boolean fl = false;
		try {
			bs.setSectet("()");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			fl = true;
		}
		assertFalse(fl);
		assertTrue(bs.matches(")((", "4"));
		assertFalse(bs.matches("())(", "8"));
		assertFalse(bs.matches("9s(", "4"));
		assertFalse(bs.matches("9s(", "4"));
		assertFalse(bs.matches("())(", "kk4"));


	}
//	@Test
//	void testToBinaryString() {
//		assertEquals("100", BaseSecret.toBinaryString(4));
//	}
//
//	@Test
//	void testToDecimalString() {
//		assertEquals("123", BaseSecret.toDecimalString(123));
//	}
//
//	@Test
//	void testParseIntBinary() {
//		assertEquals(4, BaseSecret.parseIntBinary("100"));
//	}
//
//	@Test
//	void testParseIntDecimal() {
//		assertEquals(4, BaseSecret.parseIntDecimal("4"));
//	}
}
