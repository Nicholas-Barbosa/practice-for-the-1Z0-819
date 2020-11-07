package com.nicholas.ocp.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SourceSteam {

	public static void main(String[] args) {
		System.out.println("----Stream to DoubleStream----");
		Stream<Double> mainStream = Stream.iterate(10d, x -> x <= 1000, y -> y * 10);
		DoubleStream doubleStream = mainStream.mapToDouble(x -> x);
		doubleStream.average().ifPresent(System.out::println);
		System.out.println("----Stream to IntStream----");
		Stream<Double> mainIntStream = Stream.iterate(10d, x -> x <= 1000, y -> y * 10);
		IntStream intStream = mainIntStream.mapToInt(x -> x.intValue());
		System.out.println("Sum " + intStream.sum());
		System.out.println("----Stream to LongStream----");
		Stream<Double> mainLongStream = Stream.iterate(10d, x -> x <= 1000, y -> y * 10);
		LongStream longStream = mainLongStream.mapToLong(x -> x.intValue());
		Stream<?> streamWildCard = longStream.boxed();
		System.out.println(streamWildCard.findFirst().get());
	}
}
