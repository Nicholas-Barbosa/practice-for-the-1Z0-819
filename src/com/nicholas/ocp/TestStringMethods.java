package com.nicholas.ocp;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestStringMethods {
	static char i = '0';

	public static void main(String[] args) {
		List<Integer> lista1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		List<Integer> lista2 = lista1.subList(0, 5);
		lista1.set(0, 31);
		System.out.println(lista2);

		String st1 = " d ";
		System.out.println(st1.stripTrailing());
		Stream.of(10).flatMap(x -> Stream.of(x));
		Path p1 = Path.of("\\a\\b\\c");
		System.out.println(p1.resolve("\\d"));
		System.out.println(++i);
		System.out.println("index " + new StringBuilder().append("NICHOLAS HENRIQUE", 0, 8));
		LOOP: for (i = 0; i < 5; i++) {
			switch (i++) {

			case 1:
				System.out.println("B");
				break LOOP;
			case 2:
				System.out.println("C");
				break;
			case 3:
				System.out.println("D");
				break;
			case 4:
				System.out.println("E");
			case 'E':
				System.out.println("F");
			}
		}
	}
}
