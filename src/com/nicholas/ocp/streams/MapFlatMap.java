package com.nicholas.ocp.streams;

import java.util.stream.Stream;

public class MapFlatMap {

	public static void main(String[] args) {
		var mapStream = Stream.of(10, 20, 30);
		mapStream.mapToDouble(x -> x + 10).forEach(System.out::println);
		System.out.println();
		var stream2 = Stream.of("w", "o");
		int lenght = stream2.reduce(0, (i, s) -> i + s.length(), (a, b) -> 10 + 10);
		System.out.println(lenght);
	}
}
