package com.nicholas.ocp.streams;

import java.util.stream.Stream;

public class CollectRecue {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("N", "I");
		StringBuilder tudoJunto = new StringBuilder(stream.reduce((x, y) -> x + " " + y).orElse(""));
		System.out.println(tudoJunto);
		System.out.println();
		Stream<String> streamCollec = Stream.of("N", "I");
		StringBuilder t = streamCollec.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(t);
	}
}
