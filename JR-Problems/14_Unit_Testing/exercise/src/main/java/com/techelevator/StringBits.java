package com.techelevator;

public class StringBits {

	/*
	 * Given a string, return a new string made of every other char starting with
	 * the first, so "Hello" yields "Hlo".
	 * getBits("Hello") → "Hlo"
	 * getBits("Hi") → "H"
	 * getBits("Heeololeo") → "Hello"
	 */
	public String getBits(String str) {
		String result = "";
		if (str != null) {
			for (int i = 0; i < str.length(); i++) {
				if (i % 2 == 0) {
					result += str.charAt(i);
				}
			}
		}
		return result;
	}
}
