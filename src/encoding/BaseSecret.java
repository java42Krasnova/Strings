package encoding;

import java.util.HashSet;

public class BaseSecret {
	private String secret;

	public void setSectet(String sectet) {
		this.secret = sectet;
		if (getBase() <= 1 | !isUniqueKey()) {
			throw new IllegalArgumentException("Invalid key for ciphering");
		}
	}

	private boolean isUniqueKey() {
		HashSet<Character> chekHesh = new HashSet<Character>();
		char[] letersFromString = secret.toCharArray();
		for (char letter : letersFromString) {
			if (!chekHesh.add(letter)) {
				return false;
			}
		}
		return true;
	}

	private int getBase() {
		return secret.isEmpty() ? 0 : secret.length();
	}
	public static String toBinaryString(int num) {
		StringBuilder builder = new StringBuilder();
		do {
			int rem = num % 2;
			builder.insert(0, rem);
			num = num / 2;
		} while (num != 0);
		return builder.toString();
	}

	public static String toDecimalString(int num) {
		StringBuilder builder = new StringBuilder();
		do {
			int rem = num % 10;
			builder.insert(0, rem);
			num = num / 10;
		} while (num != 0);
		return builder.toString();
	}

	public static int parseIntBinary(String binaryStr) {
		int res = 0;
		int length = binaryStr.length();
		for (int i = 0; i < length; i++) {
			res = res * 2 + (binaryStr.charAt(i) - '0');
		}
		return res;
	}

	public static int parseIntDecimal(String decimalString) {
		int res = 0;
		int length = decimalString.length();
		for (int i = 0; i < length; i++) {
			res = res * 10 + (decimalString.charAt(i) - '0');
		}
		return res;
	}

	public String toSecretString(int num) {
		// TODO done
		StringBuilder builder = new StringBuilder();
		int base = getBase();
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
		int res = 0;
		for (char symbol : code.toCharArray()) {
			if (secret.indexOf(symbol) == -1) {
				throw new IllegalArgumentException("Code don't match to secret key");
			}
			res = res * getBase() + secret.indexOf(symbol);
		}
		return res == Integer.parseInt(decString);
	}
}
