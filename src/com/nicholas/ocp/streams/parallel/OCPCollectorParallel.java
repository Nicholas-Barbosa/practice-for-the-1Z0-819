package com.nicholas.ocp.streams.parallel;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OCPCollectorParallel {

	/*
	 * Toda instancia de Collector, define um metodo characteristics() que retorna
	 * uma set de Collectos.Characteristcs.
	 * 
	 * Para usar-mos collector em parallel reduction ha alguns steps que temos de
	 * seguir. Ou melhor, para ser um Parallel reduction.
	 * 
	 * 1-Stream e parallel stream
	 * 
	 * 2-argumentos do collector tem um Charactirists.CONCURRENT
	 * 
	 * 3-Stream nao e ordenada ou possui Charactirists.UNORDERED
	 * 
	 * Exemplo, Collectos.ToSet() tem a Characteristics.UNORDERED mas nao tem
	 * Characteristics.CONCURRENT, entao nao e parallel reduction.
	 * 
	 * Metodos como toCuncurrentMap() e groupingByConcurrent() sao UNRODERED e
	 * CONCURRENT.
	 * 
	 * toConcurrentMap() similar a toMap, duas functions para mapear a key e o
	 * value, um BinaryOperator para combinar valores de uma mesma function
	 * 
	 * groupingByConcurrent() similar a groupingBy(), uma function para mapear a Key
	 * e uma List de todos os elementos que dao match com esta key. Pode-se passar
	 * um downstream collector e um supplier para definir o tipo do map.
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * Not parallel reduction
		 */
		Stream<Integer> st = Stream.of(1, 2, 3, 4, 5, 56, 0).parallel();
		System.out.println("NOT Parallel " + st.collect(Collectors.toList()));
		System.out.println();
		ConcurrentMap<Integer, String> map = Stream.of("lions", "tigers", "bears").parallel()
				.collect(Collectors.toConcurrentMap((String x) -> x.length(), y -> y, (s1, s2) -> s1 + "," + s2));
		System.out.println(map);
		System.out.println();
		ConcurrentMap<Integer, List<String>> map2 = Stream.of("lions", "tigers", "bears", "lions").parallel()
				.collect(Collectors.groupingByConcurrent((String x) -> x.length(), ConcurrentSkipListMap::new,
						Collectors.toList()));
		System.out.println(map2);
		System.out.println(map2.getClass());

	}
}
