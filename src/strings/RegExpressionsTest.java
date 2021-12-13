package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static strings.RegExpressions.*;


class RegExpressionsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void javaVariableTrue() {
		assertTrue("__".matches(javaVariable()));
		assertTrue("$".matches(javaVariable()));
		assertTrue("a2".matches(javaVariable()));
		assertTrue("_2".matches(javaVariable()));
		assertTrue("A".matches(javaVariable()));
		assertTrue("$$".matches(javaVariable()));

	}

	@Test
	void javaVariableFalse() {
		assertFalse("_".matches(javaVariable()));
		assertFalse("1_".matches(javaVariable()));
		assertFalse("&abc".matches(javaVariable()));
		assertFalse("#".matches(javaVariable()));

	}

	@Test
	void lessEqual300TrueTest() {
		assertTrue("1".matches(lessEqual300()));
		assertTrue("99".matches(lessEqual300()));
		assertTrue("299".matches(lessEqual300()));
		assertTrue("100".matches(lessEqual300()));
		assertTrue("300".matches(lessEqual300()));
	}

	@Test
	void lessEqual300FalseTest() {
		assertFalse("0".matches(lessEqual300()));
		assertFalse("09".matches(lessEqual300()));
		assertFalse("301".matches(lessEqual300()));
		assertFalse("#".matches(lessEqual300()));
		assertFalse(" 40".matches(lessEqual300()));
	}

	@Test
	void ipV4PartTrueTest() {
		assertTrue("0".matches(ipV4Part()));
		assertTrue("001".matches(ipV4Part()));
		assertTrue("255".matches(ipV4Part()));
		assertTrue("020".matches(ipV4Part()));
		assertTrue("199".matches(ipV4Part()));
		assertTrue("100".matches(ipV4Part()));
		assertTrue("10".matches(ipV4Part()));
		assertTrue("99".matches(ipV4Part()));
		assertTrue("000".matches(ipV4Part()));
		assertTrue("200".matches(ipV4Part()));

	}

	@Test
	void ipV4PartFalseTest() {
		assertFalse("0000".matches(ipV4Part()));
		assertFalse("-10".matches(ipV4Part()));
		assertFalse("#".matches(ipV4Part()));
		assertFalse("300".matches(ipV4Part()));
		assertFalse("256".matches(ipV4Part()));
		assertFalse("260".matches(ipV4Part()));
		assertFalse("1%".matches(ipV4Part()));
	}

	@Test
	void arithmticExpressionsTrueTest() {
		assertTrue("  20".matches(arithmeticExpression()));
		assertTrue("20 +10 * 2/100 +4".matches(arithmeticExpression()));
		assertTrue(" 20 +10 * 2/100 +4 ".matches(arithmeticExpression()));

	}

	@Test
	void arithmticExpressionsTrueFalse() {
		assertFalse("  20+".matches(arithmeticExpression()));
		assertFalse("  20+a".matches(arithmeticExpression()));
		assertFalse("10  20".matches(arithmeticExpression()));
		assertFalse("  # * 10".matches(arithmeticExpression()));
		assertFalse("  20+&".matches(arithmeticExpression()));
		assertFalse(" +20".matches(arithmeticExpression()));
	}
	@Test
	void ipV4TrueTest() {
		assertTrue("0.0.0.0".matches(ipV4()));
		assertTrue("022.0.04.055".matches(ipV4()));
		assertTrue("255.0.000.0".matches(ipV4()));
		assertTrue("05.033.02.011".matches(ipV4()));
		

	}
	@Test
	void ipV4TrueFalse() {
		assertFalse("0000.88.9".matches(ipV4()));
		assertFalse("00 88.9.233".matches(ipV4()));
		assertFalse("0.88.9.256".matches(ipV4()));
		assertFalse("00.88-9".matches(ipV4()));
		assertFalse("0000.88.9.55.33".matches(ipV4()));

	}
	@Test
	void telNumIstTrueTest() {
		assertTrue("+972-534123456".matches(telephoneNumberIsrael()));
		assertTrue("+972534123456".matches(telephoneNumberIsrael()));
		assertTrue("+97253-4123456".matches(telephoneNumberIsrael()));
		assertTrue("+9725341-23-456".matches(telephoneNumberIsrael()));
		assertTrue("0534123456".matches(telephoneNumberIsrael()));
		assertTrue("054-712-34-56".matches(telephoneNumberIsrael()));
		
	}
	@Test
	void telNumIstFalseTest() {
		assertFalse("972534123456".matches(telephoneNumberIsrael()));//no +
		assertFalse("+9720534123456".matches(telephoneNumberIsrael()));//0 after +972
		assertFalse("053-412_456".matches(telephoneNumberIsrael()));//_ disallowed
		assertFalse("534123456".matches(telephoneNumberIsrael()));//wrong prefix
		assertFalse("+97253412345".matches(telephoneNumberIsrael()));//too few digits
		assertFalse("05341234567".matches(telephoneNumberIsrael()));
	}
	@Test
	void StringSplitTest() {
		String str = "Regular_Expressions_are_hard";
		String regEx ="_";
		String[] exp = {"Regular", "Expressions", "are", "hard"};
		assertArrayEquals(exp, str.split(regEx));
		boolean fl = false;
//		try {
//			exp = str.split("888");
//			
//		} catch (PatternSyntaxException e) {
//			fl = true;
//			System.out.println("Catching PatternSyntaxException ");
//		}
//		assertTrue(fl);
		String[] exp2 = {"R","gular_Expr","ssions_ar","_hard"};
		assertArrayEquals(exp2, str.split("e"));
}

	@Test
	void StringReplaseAllTest() {
		String str = "new e-mail adress: Jmai2lll@e-mail.com";
		String regEx = "(\\w){8}@e\\-mail.(\\w){3}";
		String exchange = "i.bas@me.com";
		assertEquals("new e-mail adress: i.bas@me.com", str.replaceAll(regEx, exchange));
	
	}
}
