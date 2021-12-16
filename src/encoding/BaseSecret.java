package encoding;

import java.util.HashSet;

public class BaseSecret {
	private String secret;

	public void setSectet(String sectet) {
		this.secret = sectet;
		if (!isValidKey()) {
			throw new IllegalArgumentException(String.format
					("Invalid key for ciphering, key is %s",sectet));
		}
	}
	private boolean isValidKey() {
		if (secret.length() <= 1) {
			return false;
		}
		HashSet<Character> checkHesh = new HashSet<Character>();
		char[] letersFromString = secret.toCharArray();
		for (char letter : letersFromString) {
			checkHesh.add(letter) ;
		}
		return secret.length() == checkHesh.size();
	}
	
	public String toSecretString(int num) {
		// TODO done
		StringBuilder builder = new StringBuilder();
		if(secret == null) {
			return "key is not seted up";
		}
		int base = secret.length();
		
		do {
			int dig = num % base;
			num = num / base;
			char rem = getSymbol(dig);
			builder.insert(0, rem);
		} while (num != 0);
		return builder.toString();
	}

	private char getSymbol(int dig) {
		return secret.charAt(dig);
	}

	public boolean matches(String code, String decString) {
		// TODO done
		if(secret == null |!decString.matches("\\d+")) {
			return false;
		}
		int res = 0;
		for (char symbol : code.toCharArray()) {
			if (secret.indexOf(symbol) == -1) {
				return false;
			}
			res = res * secret.length() + secret.indexOf(symbol);
		}
		return res == Integer.parseInt(decString);
	}
	
	public static String toDigString(int num, int base) {
		StringBuilder builder = new StringBuilder();
		do {
			int rem = num % base;
			builder.insert(0, rem);
			num = num / base;
		} while (num != 0);
		return builder.toString();
	}

	public static int parseDig(String binaryStr, int base) {
		int res = 0;
		int length = binaryStr.length();
		for (int i = 0; i < length; i++) {
			res = res * base + (binaryStr.charAt(i) - '0');
		}
		return res;
	}

//	public static String toBinaryString(int num) {
//		StringBuilder builder = new StringBuilder();
//		do {
//			int rem = num % 2;
//			builder.insert(0, rem);
//			num = num / 2;
//			
//		}while(num != 0);
//		return builder.toString();
//	}
//	public static String toDecimalString(int num) {
//		StringBuilder builder = new StringBuilder();
//		do {
//			int rem = num % 10;
//			builder.insert(0, rem);
//			num = num / 10;
//			
//		}while(num != 0);
//		return builder.toString();
//	}
//	public static int parseIntBinary(String binaryStr) {
//		int res = 0;
//		int length = binaryStr.length();
//		for (int i = 0; i < length; i++) {
//			res = res * 2 + (binaryStr.charAt(i) - '0');
//		}
//		return res;
//	}
//	public static int parseIntDecimal(String decString) {
//		int res = 0;
//		int length = decString.length();
//		for (int i = 0; i < length; i++) {
//			res = res * 10 + (decString.charAt(i) - '0');
//		}
//		return res;
	//}
}

