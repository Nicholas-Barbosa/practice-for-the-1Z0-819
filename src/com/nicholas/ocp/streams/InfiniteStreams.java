package com.nicholas.ocp.streams;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class InfiniteStreams {

	/*
	 * Uma das maiores vantagens dos stremas em relacao ao List, e que vc pode criar
	 * streams infinitas.
	 * 
	 * Metodos para criacao de uma Stream.
	 * 
	 * 1- empty() Como no Optional, cria uam Stream vazia.
	 * 
	 * 2-of() -> Cria uma Stream aparatir de varargs.
	 * 
	 * 3-coll.stream() -> Cria uma stream apartir de uma collection.
	 * 
	 * 4-coll.paralelStream() -> Cria uma stream a partir de uma collection onde a
	 * steam pode correr paralelamente
	 * 
	 * 5-generate(Supplier) -> Cria uma infinity Stream usando o resultado da
	 * chamada do supplier para cada elemento mediante requisicao.
	 * 
	 * 6-iterate(seed,unaryOperator) -> Cria uma infinity Stream, onde o seed e o
	 * primeiro elemento e depois chama o unaryOperator para cada elemento
	 * subsequente mediante requisicao.
	 * 
	 * 7-iterate(seed,predicate,unaryOperator) -> Esta overloaded version, cria uma
	 * Stream considerando o seed como primeiro elemento, depois chama o supplier
	 * para cada elemento subsequente, ate que o predicate retorne false. Por isso
	 * este stream pode ser finite ou infinity
	 * 
	 *
	 * 
	 */

	public static void main(String[] args) {
		Stream<String> emptyStream = Stream.empty();
		System.out.println(emptyStream);// diferente de collection,ao chamar uma stream e retornado
										// java.util.streamPipeline$$...
		Stream<Integer> fromVarargs = Stream.of(1, 2, 30);
		System.out.println(fromVarargs);
		var coll = new ArrayList<Integer>();
		Stream<Integer> fromCollection = coll.stream();
		System.out.println(fromCollection);
		Stream<Integer> infinite = Stream.generate(() -> 2);
		infinite.forEach(System.err::println);
		Stream<Integer> iterate = Stream.iterate(2, x -> x + 1);
		iterate.forEach(System.out::println);

		Predicate<Integer> endsWith10 = x -> x <= 10;
		Predicate<Integer> endsWith20 = x -> x < 20;
		Stream<Integer> iterateWithPredicate = Stream.iterate(2, endsWith10.or(endsWith20), y -> y + 2);
		iterateWithPredicate.forEach(System.out::println);
	}
}
