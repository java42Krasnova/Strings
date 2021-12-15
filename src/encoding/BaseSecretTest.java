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
		bs.setSectet(".-");
		assertEquals("-..", bs.toSecretString(4));
		bs.setSectet("6");//digital key checking
		assertEquals("10", bs.toSecretString(6));
		boolean fl = false;
		try {
			bs.setSectet("0");//argument can't be equal zero
		} catch (ArithmeticException e) {
			fl = true;
		}
		assertTrue(fl);
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
	}

}
