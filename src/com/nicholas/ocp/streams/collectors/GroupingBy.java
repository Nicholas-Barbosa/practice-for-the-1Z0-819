package com.nicholas.ocp.streams.collectors;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy {

	public static void main(String[] args) {
		var ohMy = Stream.of(10, 15, 20, 25);
		Map<Integer, Set<Integer>> map = ohMy
				.collect(Collectors.groupingBy(x -> x <= 20 ? 20 : 25, TreeMap::new, Collectors.toSet()));
		System.out.println(map + " class " + map.getClass());
		System.out.println();
		var ohMy2 = Stream.of(10, 15, 20, 25);
		Map<Integer, Optional<Integer>> mapMinBy = ohMy2.collect(Collectors.groupingBy(x -> x <= 20 ? 20 : 25, TreeMap::new,
				Collectors.mapping(x -> x, Collectors.minBy((a, b) -> a - b))));
		System.out.println(mapMinBy + " class " + mapMinBy.getClass());
	}
}
