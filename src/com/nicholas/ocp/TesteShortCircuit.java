package com.nicholas.ocp;

import java.util.ArrayList;

public class TesteShortCircuit {

	public static void main(String[] args) {
		int x = 0;
		labelA: for (var i = 10; i < 0; i--) {
			var j = 0;
			System.out.println(j);
			labelB: while (j < 10) {
				System.out.println("inside while");
				if (j > i)
					break labelB;
				if (i == j) {
					x++;
					continue labelA;
				}
				j++;
			}
			x--;
		}
		System.out.println(x);
	}

	private static boolean teste() {
		System.out.println("Teste");
		return true;
	}
}
