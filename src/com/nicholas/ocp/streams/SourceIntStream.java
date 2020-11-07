package com.nicholas.ocp.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SourceIntStream {

	public static void main(String[] args) {
		System.out.println("----Source IntStream to Stream----");
		IntStream mainInt = IntStream.of(10, 100, 1000);
		Stream<Integer> fromDouble = mainInt.mapToObj(x -> x);
		System.out.println(fromDouble.max((x, y) -> x.intValue() - y.intValue()));
		
		System.out.println("----Source IntStream to DoubleStream----");
		IntStream mainIntStream = IntStream.of(10, 100, 1000);
		DoubleStream fromIntToDoubleStream = mainIntStream.mapToDouble(x -> x);
		System.out.println(fromIntToDoubleStream.max().getAsDouble());
		
		System.out.println("----Source IntStream to IntStream----");
		IntStream mainToIntStream = IntStream.of(10, 100, 1000);
		IntStream fromDoubleToInt = mainToIntStream.map(x -> Double.valueOf(x).intValue());
		System.out.println(fromDoubleToInt.max().getAsInt());
		
		System.out.println("----Source IntStream to LongStream----");
		IntStream mainToLongStream = IntStream.of(10, 100, 1000);
		LongStream fromIntToLongStream = mainToLongStream.mapToLong(x -> Double.valueOf(x).intValue());
		System.out.println(fromIntToLongStream.max().getAsLong());
	}
}
