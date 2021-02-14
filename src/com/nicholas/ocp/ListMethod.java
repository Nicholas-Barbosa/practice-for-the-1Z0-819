package com.nicholas.ocp;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("A");
		lista.add("A");
		lista.add("A");
		System.out.println(lista.subList(1, 2));
		System.out.println(lista);

		int s = 20;
		char sc = (char) s;
	}
}
