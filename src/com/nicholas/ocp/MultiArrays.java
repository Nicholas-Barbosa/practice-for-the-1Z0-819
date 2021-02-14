package com.nicholas.ocp;

import java.util.Arrays;

public class MultiArrays {

	public static void main(String[] args) {
		String[][][] arr3 = { { { "a", "b", "c" }, { "d", "e", null } }, { { "x" }, null }, { { "y" } },
				{ { "z", "p" }, {} } };
		System.out.println(arr3[2][0][0]);

		String[] arr = { "a" };
		String[] arr2 = { "x" };
		System.out.println(Arrays.compare(arr, arr2));
	}
}
