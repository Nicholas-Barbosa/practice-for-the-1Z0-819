package com.nicholas.ocp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ImplicitNarrowing {

	/*
	 * Ocorre somente com constantes tipo int,char,short e byte
	 */
	public static void main(String[] args) {
		final int i = 2;
		final short is = i;
		final char ic = is;

		byte bt = ic;
		System.out.println(bt);

		StringBuilder sb = new StringBuilder("abc");
		sb.setLength(10);
		System.out.println(sb);
		int [] [] array = {{0}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}, {0, 1, 2, 3, 4}};
	//	var arr1 = array[4];
		//System.out.println (arr1[4][1]);
		System.out.println (array[4][1]);
	}

	public ImplicitNarrowing() {
		String[] st = {};
		if (true)
			;
		else
			;

	short ch =(short)( 180 *200);
		// TODO Auto-generated constructor stub
	}
	/*
	 * SafeVaragrs, documented e FunctionalInterface
	 */
}
