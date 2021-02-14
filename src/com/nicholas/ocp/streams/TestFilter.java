package com.nicholas.ocp.streams;

import java.util.stream.Stream;

public class TestFilter {

	private static int i;

	public static void main(String[] args) {
		Stream<Integer> st = Stream.generate(TestFilter::generate);
		System.out.println(st.filter(e -> e >= 5).limit(3).count());
	}

	private static Integer generate() {
		if (i >20)
			return 0;
		return i++;
	}
}
