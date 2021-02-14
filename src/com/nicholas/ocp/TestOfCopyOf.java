package com.nicholas.ocp;

import java.util.ArrayList;
import java.util.List;

public class TestOfCopyOf {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>(List.of("a", "b"));
		List<List<String>> list1 = List.of(lista);
		lista.add("b");
		System.out.println(list1);
	}
}
