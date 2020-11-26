package com.nicholas.ocp.streams.parallel;

import java.util.List;
import java.util.stream.Stream;

public class OCPOrderedOperations {

	/*
	 * Operacoes que dependem da ordem da stream como findAny, skip, limit sao menos
	 * performaticos ao trabalhar com parallel strems. Porem, os resultados sao
	 * previsiveis, tanto no serial stream e no parallel streams, serao os mesmos
	 * resultados
	 * 
	 * 
	 */

	public static void main(String[] args) {
		Stream<Integer> serialStream = Stream.of(1, 2, 3, 4, 5, 6);
		Stream<Integer> parallelStream = List.of(1, 2, 3, 4, 5, 6).parallelStream();
		System.out.println("First element in serialStream " + serialStream.skip(1).limit(10).findFirst().get());
		System.out.println("First element in parallelStream " + parallelStream.skip(1).limit(10).findFirst().get());
		System.out.println("--Not predictable--");
		Stream<Integer> parallelStream2 = List.of(1, 2, 3, 4, 5, 6).parallelStream();
		System.out.println(parallelStream2.findAny().get());
		System.out.println();
		/*
		 * Metodo como undored(intermediate operation), ignora a ordem da stream ao
		 * trabalhar com final operation que dependem da ordem(Order-Based).
		 * 
		 */
		Stream<Integer> parallelStreamUnordered = List.of(1, 2, 3, 4, 5, 6).stream().unordered().parallel();
		System.out.println(parallelStreamUnordered.findFirst().get());
	}
}
