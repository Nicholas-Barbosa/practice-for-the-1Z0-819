package com.nicholas.ocp.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SourceLongStream {

	public static void main(String[] args) {
		System.out.println("----Source LongStream to Stream----");
		LongStream mainLong = LongStream.of(10, 100, 1000);
		Stream<Long> fromLong = mainLong.mapToObj(x -> x);
		System.out.println(fromLong.max((x, y) -> x.intValue() - y.intValue()));
		System.out.println("----Source LongStream to DoubleStream----");
		LongStream mainDoubleStream = LongStream.of(10, 100, 1000);
		DoubleStream fromDoubleToDoubl = mainDoubleStream.mapToDouble(x -> x);
		System.out.println(fromDoubleToDoubl.max().getAsDouble());
		System.out.println("----Source LongStream to IntStream----");
		LongStream mainToIntStream = LongStream.of(10, 100, 1000);
		IntStream fromDoubleToInt = mainToIntStream.mapToInt(x -> Double.valueOf(x).intValue());
		System.out.println(fromDoubleToInt.max().getAsInt());
		System.out.println("----Source LongStream to LongStream----");
		LongStream mainToLongStream = LongStream.of(10, 100, 1000);
		LongStream fromLongToLongSTream = mainToLongStream.map(x -> Double.valueOf(x).intValue());
		System.out.println(fromLongToLongSTream.max().getAsLong());
	}
}
