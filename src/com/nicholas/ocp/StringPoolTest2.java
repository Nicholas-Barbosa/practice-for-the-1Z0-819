package com.nicholas.ocp;

public class StringPoolTest2 {

	public static void main(String[] args) {
		String newString = new String("HI");
		newString = newString.intern();
		String string = "HI";
		string = string.strip();
		System.out.println(string == newString);
	}
}
