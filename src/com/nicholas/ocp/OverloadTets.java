package com.nicholas.ocp;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OverloadTets {

	public void print(int a) {
		System.out.println("in A");
	}

	public void print(Integer a) {
		System.out.println("In Integer");
	}

	public void print(Long l) {
		System.out.println("In Long");
	}


	public static void main(String[] args) {
		new OverloadTets().print(Integer.valueOf(10));

		var tickers = List.of("A", "D", "E", "C", "A");
		var ratio = List.of(1.0, 1.2, 1.5, 1.8, 2.0);
		var map1 = IntStream.range(0, tickers.size()).boxed().collect(Collectors.toMap(i -> tickers.get(i), i -> {
			double result = 1.0 / ratio.get(i);
			System.out.println("Resultado " + ratio.get(i));
			return result;
		}, (x, y) -> x + y)); // <<-----
		// LINE 1
		System.out.println(map1);
		System.out.println(1.0 / 1.5);

		List<String> list = new ArrayList<>();
		list.add("A");
		List<? extends String> list2 = new ArrayList<>();
		list.add("");
		System.out.println("Zoned " + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("'time zone' zz ZZ")));
	
	}

	{

	}
}

class SuperNotAbstract {
	void a() {
	}
}

abstract class Abstract extends SuperNotAbstract {
	abstract void a();
}

enum FormatStyle {
}