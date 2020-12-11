package com.nicholas.ocp.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Review {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(10, 20, 30);
		IntSummaryStatistics summary = stream.collect(Collectors.summarizingInt(x -> x));
		System.out.println(summary.getMax());

		combinigPredicates();
		primitiveFunction();
		optionalPrimitive();
		groupingBy();
		flatMap();
	}

	private static void combinigPredicates() {
		Predicate<String> p1 = x -> x.startsWith("nicholas");
		Predicate<String> p2 = x -> x.startsWith("barbosa");
		Predicate<String> result = p1.and(p2).negate();
		System.out.println("Two predicates " + result.test("Nicholas Olveira"));

		Function<Integer, Integer> in1 = x -> x + 90;
		Function<Integer, Integer> in2 = x -> x * 2;
		Function<Integer, Integer> resultFunc = in1.compose(in2);
		Function<Integer, Integer> andThen = in1.andThen(in2);
		System.out.println("result " + resultFunc.apply(10));
		System.out.println("and then " + andThen.apply(10));
		/*
		 * andThen chama o caller primeiro e o compose chama o caller depois
		 */
	}

	private static void primitiveFunction() {
		ToIntFunction<String> returnAnInt = x -> x.length() + 10;
		IntFunction<String> returnString = x -> x + "string";
		System.out.println(returnAnInt.applyAsInt("10"));
		System.out.println(returnString.apply(900));
	}

	private static void optionalPrimitive() {
		IntStream st = IntStream.of(10, 20, 30, 40, 50);
		OptionalDouble op = st.average();
		System.out.println(op.getAsDouble());
	}

	private static void groupingBy() {
		Stream<String> st = Stream.of("Nicholas", "Barbosa", "Oliveira");
		Map<Integer, Optional<String>> map = st.collect(Collectors.groupingBy(String::length,
				Collectors.mapping(x -> x + "1", Collectors.minBy((a, b) -> a.toString().compareTo(b)))));
		System.out.println(map);
		/*
		 * mapping dois parametros, a function para os valores e o segundo para
		 * agrupar,como se fosse o accumulator
		 */
	}

	private static void flatMap() {

		var one = List.of("Nicholas");
		var two = List.of("Barbosa");
		Stream<List<String>> st = Stream.of(one, two);
		Stream<String> newSt = st.flatMap(w ->w.stream());
		newSt.forEach(System.out::println);

		Stream<Stream<?>> streamWitMap = Stream.of(one, two).map(x -> x.stream());
		streamWitMap.forEach((x) -> System.out.println(x.findFirst().get()));
		/*
		 * flatMap() 
		 * 
		 * Retorna uma Stream consistindo nos resultados de substituir cada elementos
		 * desta stream com os conteudos da stream produzida por aplicar a function
		 * fornecida para cada elemento.
		 * 
		 * Achata, nivela todos os elementos num mesmo nivel na stream.
		 * 
		 * map()
		 * 
		 * cria uma stream consistindo nos resultados da function.
		 */
	}
}
