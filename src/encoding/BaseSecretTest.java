package encoding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseSecretTest {
	BaseSecret bs = new BaseSecret();

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testToBinaryString() {
		assertEquals("100", BaseSecret.toBinaryString(4));
	}

	@Test
	void testToDecimalString() {
		assertEquals("123", BaseSecret.toDecimalString(123));
	}

	@Test
	void testParseIntBinary() {
		assertEquals(4, BaseSecret.parseIntBinary("100"));
	}

	@Test
	void testParseIntDecimal() {
		assertEquals(4, BaseSecret.parseIntDecimal("4"));
	}

	@Test
	void testToSecretString() {
		boolean fl = false;
		try {
			bs.setSectet(".-");
		} catch (IllegalArgumentException e) {
			fl = true;
		}
		assertFalse(fl);
		assertEquals("-..", bs.toSecretString(4));
		fl = false;
		try {
			bs.setSectet("j");// to short
		} catch (IllegalArgumentException e) {
			fl = true;
		}
		assertTrue(fl);
		fl = false;
		try {
			bs.setSectet("mmm");//not unique key for ciphering 
		} catch (IllegalArgumentException e) {
			fl = true;
		}
		assertTrue(fl);
	}

	@Test
	void testMatches() {
		bs.setSectet("()");
		assertTrue(bs.matches(")((", "4"));
		assertFalse(bs.matches("())(", "8"));
		boolean fl = false;
		try {
			bs.matches("9s(", "4");//if code don't match to secret key 
		} catch (IllegalArgumentException e) {
			fl = true;
		}
	}

}
