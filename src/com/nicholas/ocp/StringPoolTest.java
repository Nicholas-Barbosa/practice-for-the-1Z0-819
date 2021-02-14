package com.nicholas.ocp;

public class StringPoolTest {

	public static void main(String[] args) {
		String firstString = "ni";
		String secondString = "n" + "i";
		System.out.println(firstString == secondString);

	}
}
