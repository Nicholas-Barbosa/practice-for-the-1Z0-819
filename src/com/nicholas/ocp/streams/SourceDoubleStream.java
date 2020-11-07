package com.nicholas.ocp.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SourceDoubleStream {

	public static void main(String[] args) {
		System.out.println("----Source DoubleStream to Stream----");
		DoubleStream mainDouble = DoubleStream.of(10, 100, 1000);
		Stream<Double> fromDouble = mainDouble.mapToObj(x -> x);
		System.out.println(fromDouble.max((x, y) -> x.intValue() - y.intValue()));
		System.out.println("----Source DoubleStream to DoubleStream----");
		DoubleStream mainDoubleStream = DoubleStream.of(10, 100, 1000);
		DoubleStream fromDoubleToDoubl = mainDoubleStream.map(x -> x);
		System.out.println(fromDoubleToDoubl.max().getAsDouble());
		System.out.println("----Source DoubleStream to IntStream----");
		DoubleStream mainToIntStream = DoubleStream.of(10, 100, 1000);
		IntStream fromDoubleToInt = mainToIntStream.mapToInt(x -> Double.valueOf(x).intValue());
		System.out.println(fromDoubleToInt.max().getAsInt());
		System.out.println("----Source DoubleStream to LongStream----");
		DoubleStream mainToLongStream = DoubleStream.of(10, 100, 1000);
		LongStream fromDoubleToLongStream = mainToLongStream.mapToLong(x -> Double.valueOf(x).intValue());
		System.out.println(fromDoubleToLongStream.max().getAsLong());
	}
}
