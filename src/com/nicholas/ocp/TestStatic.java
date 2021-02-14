package com.nicholas.ocp;

class Super23 {
	static String ID = "QBANK";

}

class Sub extends Super23 {
	static {
		System.out.print("In Sub");
	}
}

public class TestStatic {

	public static void main(String[] args) {
		String sentence = "Life is a box of chocolates, Forrest. You never know what you're gonna get.";
		String splitted[] = sentence.split("[ ,.]");
		System.out.println(splitted[0]);
		System.out.println(splitted[1]);

		int[][] twoD = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10 } };

		System.out.print(twoD[0][1] == twoD[0].clone()[1]);

	}

}

enum c {
	X
}