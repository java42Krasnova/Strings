package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringTests {
private static final int N_STRINGS = 2000000;
 final String str ="Hello";
final StringBuilder strBuilder = new StringBuilder("Hello");
	@BeforeEach
	void setUp() throws Exception {
	
	}

	@Test
	void testReplace() {
		assertEquals("*ello", str.replace('H', '*'));
		strBuilder.replace(0, 1, "*");
		assertEquals("*ello", strBuilder.toString());
		
	}
private String joinString(String[]strings, String delimetr) {
	String res  = strings[0];
	for(int i=1; i< strings.length; i++) {
		res+= delimetr+strings[i];
	}
	return res;
}
private String[] getStrings(int nStrings) {
	String[] res = new String[nStrings];
	for(int i =0; i< nStrings; i++) {
		res[i] = str;
	}
	return res;
}
@Test
void functionalTestJoin() {
	String expected = str + ";" + str;
	assertEquals(expected, joinString(getStrings(2), ";"));
}
private String joinStringBuilder(String[]strings, String delimetr) {
	StringBuilder res  = new StringBuilder(strings[0]);
	for(int i=1; i< strings.length; i++) {
		res.append(delimetr).append(strings[i]);
	}
	return res.toString();
}
@Test
void functionalTestJoinBuilder() {
	String expected = str + ";" + str;
	assertEquals(expected, joinStringBuilder(getStrings(2), ";"));
}

//@Test
//void performanceJoinStringTest () {
//	joinString(getStrings(N_STRINGS), ";");
//	
//}
@Test
void performanceJoinStringBuilderTest() {
	joinStringBuilder(getStrings(N_STRINGS), ";");
	
}
}
