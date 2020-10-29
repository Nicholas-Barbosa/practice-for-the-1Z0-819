package com.nicholas.ocp.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TesteReverse {

	public static void main(String[] args) {
		var names = Arrays.asList("Fluffy", "Hoppy");
		Comparator<String> c = Comparator.reverseOrder();
		 Collections.sort(names, c);
		System.out.println(names);
		System.out.println("index: " + Collections.binarySearch(names, "Fluffy", c));
	}
}
