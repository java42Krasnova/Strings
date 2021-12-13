package strings;

public class RegExpressions {
public static String javaVariable() {
	
//	return"[A-Za-z$][A-Za-z$0-9_]*|_[A-Za-z$0-9_]+";
	return"[A-Za-z$][\\w$]*|_[\\w$]+";

}
public static String lessEqual300() {
	return"[1-9]\\d?|[12]\\d{2}|300";
}
/**
 * @return regex for any number  0 - 255 with optional leading zero's
 */
public static String ipV4Part() {
	return "\\d\\d?|[0-1]\\d{2}|2[0-4]\\d|25[0-5]";
}
/**
 * 
 * @return regex for arithmetic expressions without brackets
 * operators - +, -.*./
 * opernds integer positive number with possible leading zero's
 */
public static String arithmeticExpression() {
	String delimiter = "\\s*";
	String operand = "\\d+";
	String operator = "[+*/-]";
	return String.format("%1$s%2$s(%1$s%3$s%1$s%2$s)*%1$s", delimiter,operand,operator);
//	return delimiter + operand + "(" +delimiter + operator + delimiter + operand+")"+"*" + delimiter;
//	return "\\s*\\d+(\\s*[+*/-]\\s*\\d+)*\\s*";
}
/**
 * 
 * @return regex for IpV4
 * contains four parts separated by dot
 * each part is the  regex of String ipV4Part()
 */
//TODO done
public static String ipV4() {
	String ipNum = "("+ ipV4Part()+")";
	String dilimetr = "[.]";
	//return String.format("(%1$s%2$s){3}%1$s" ,ipNum, dilimetr);
	return "(" + ipNum + dilimetr +")"+"{3}" + ipNum;
	
}/**
 * 
 * @return regex for mobile Israel phone
 * Israel code optional +972 (if the code specified, operator code should be with no 0)
 * operator code: 050-059 , 072-077
 * 7 digits that may or may not be separated by dash
 */
//TODO done
public static String mobileIsraelPhone() {
	String prefiks = "(\\+972\\-?\\s*|0)";
	String code = "(5\\d|7[2-7])";
	String number ="(\\-?\\d){7}";
	//return String.format("%1$s%2$s%3$s", prefiks, code, number);
	return prefiks+code+ number;
}
}
