package com.nicholas.ocp.streams;

import java.util.List;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<StringBuilder> list = List.of(new StringBuilder(), new StringBuilder());
		Stream<StringBuilder> st = list.stream();
		list.forEach(x -> x.insert(0, "inseted"));
		st.forEach(System.out::println);
	}
}
