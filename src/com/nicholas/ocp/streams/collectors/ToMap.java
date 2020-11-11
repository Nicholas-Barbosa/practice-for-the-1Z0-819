package com.nicholas.ocp.streams.collectors;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMap {

	public static void main(String[] args) {
		Map<Integer, String> map = Stream.of("nicholas", "barbosa", "bbbbbbbb")
				.collect(Collectors.toMap(String::length, x -> x, (a, b) -> a + "," + b, TreeMap::new));
		System.out.println(map);
	}
}
