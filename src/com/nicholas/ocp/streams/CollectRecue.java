package com.nicholas.ocp.streams;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
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
		System.out.println();
		Stream<String> streamTree = Stream.of("N", "I");
		StringBuilder set = streamTree.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(set);
		System.out.println();
		Stream<String> testeReduce = Stream.of("n", "y", "j");
		int le = testeReduce.reduce(1, (x, y) -> x + y.length(), (a, b) -> a + b);
		System.out.println(le);
		System.out.println();
		DoubleStream dbStream = DoubleStream.of(10, 20);
		DoubleSummaryStatistics statiscs = dbStream.summaryStatistics();
		System.out.println(statiscs.getAverage());
		System.out.println();
		var oh = Stream.of(10, 20, 30);
		IntSummaryStatistics st = oh.collect(Collectors.summarizingInt(x -> x));
		System.out.println(st.getAverage());
	}
}
