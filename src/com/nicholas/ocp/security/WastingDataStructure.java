package com.nicholas.ocp.security;

import java.util.Arrays;

public class WastingDataStructure {

	private String[] myArray;

	private void inputArrayLenght(int len) {
		/*
		 * Input validation nossa melhor amiga!
		 */
		if (len >= 30) {
			throw new IllegalArgumentException("Length cannot be more than 30!");
		}

		myArray = new String[len];
		System.out.println(Arrays.toString(myArray));
	}

	public static void main(String[] args) {
		new WastingDataStructure().inputArrayLenght(12);
	}
}
