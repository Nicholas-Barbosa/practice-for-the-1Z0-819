package com.nicholas.ocp;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReuseObject {

	public static void main(String[] args) {
		Integer i = -128;
		byte i2 = -128;
		System.out.println(i == i2);
		System.out.println(" oie ".stripLeading() + " oie ".stripTrailing());
		System.out.println(Math.pow(2, 2));

		List<Integer> lista = List.of(2, 3, 1);
		List<Integer> lista2 = List.of(5, 6, 4);
		Stream<Integer> stream = Stream.of(lista, lista2).flatMap(l -> l.stream()).sorted();
		System.out.println(stream.collect(Collectors.toList()));
		ReuseObject rs = new ReuseObject();

		Map<Boolean, Optional<Integer>> map = lista2.stream().collect(Collectors.partitioningBy(s -> s > 0,
				Collectors.mapping(x -> x, Collectors.maxBy((c1, c2) -> c1-c2))));
		System.out.println(map);
	}
}
