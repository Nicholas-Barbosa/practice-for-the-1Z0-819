package com.nicholas.ocp.streams;

import java.util.stream.IntStream;

public class RangeStream {

	public static void main(String[] args) {
		IntStream intStream = IntStream.range(1, 10);
		System.out.println(intStream.max().getAsInt());
		System.out.println();
		IntStream intStreamRangeClosed = IntStream.rangeClosed(1, 10);
		System.out.println(intStreamRangeClosed.max().getAsInt());
	}
}
