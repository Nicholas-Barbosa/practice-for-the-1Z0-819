package com.nicholas.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Hello<T> {
	T t;

	public Hello(T t) {
		this.t = t;
	}

	public String toString() {
		return t.toString();
	}

	private void println(T message) {
		System.out.print(t + "-" + message);
	}

	public static void main(String[] args) {
		Stream.iterate(1, x -> x++).limit(10).filter(x -> x > 90).forEach(System.out::print);

		var map = Map.of(1, 2, 3, 6);
		var list = List.copyOf(map.entrySet());

		List<Integer> one = List.of(8, 16, 2);
		var copy = List.copyOf(one);
		var copyOfCopy = List.copyOf(copy);
		var thirdCopy = new ArrayList<>(copyOfCopy);

		list.replaceAll(x -> null);
		one.replaceAll(x -> x * 2);
		thirdCopy.replaceAll(x -> x * 2);

		System.out.println(thirdCopy);
	}
}