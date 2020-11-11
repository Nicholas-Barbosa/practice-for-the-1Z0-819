package com.nicholas.ocp.streams.collectors;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartioningBy {

	public static void main(String[] args) {
		var myStream = Stream.of("nicholas", "barbosa");
		Map<Boolean, Set<String>> map = myStream
				.collect(Collectors.partitioningBy(x -> x.length() >= 8, Collectors.toSet()));
		System.out.println(map);
		System.out.println("".isEmpty());
	}
}
