package com.nicholas.ocp.streams;

import java.util.stream.Stream;

public class StreamTerminalOperations {

	/*
	 * Podemos pular os estagio de Intermediate Operations, seguindo direto para
	 * TerminalOperations.
	 * 
	 * Reductions e o nome que se da a combinacao de conteudos de uma stream, a um
	 * unico objeto ou primitivo.
	 * 
	 * Metodos para esta feature
	 * 
	 * 1-count() -> Este metodo determina os elementos de uma stream. Para uma
	 * infinite stream, nunca termine.
	 * 
	 * Ele e Redction, ja que pega todo o conteudo e combina num
	 * primitivo(long),sendo assim retornando o numero de elementos numa stream.
	 * 
	 * 2-min() e max() -> Estes metodos permitem vc passar um Comparator como
	 * parametro para determinar qual elemento e maior ou menor,dependendo de sua
	 * classifacao.Novamente, Reduction.
	 * 
	 * Optional<T>min(Comparator<?superT); Optional<T>max(Comparator<?superT);
	 * 
	 * 3-findFirst() e findAny() -> Retorna um elemento da stream, a menos que a
	 * Stream esteja vazia. Se estiver vazia retorna uma empty Optional.
	 * 
	 * Este pode terminar uma finite stream. Pelo nome, findAny() retorna qualquer
	 * elemento da stream,mas e comum retornar o primeiro,mas nem sempre acontece.
	 * 
	 * Estes metodos sao TerminalOperations, mas nao Reductions, ja que eles nao
	 * processam todos oe elementos da stream.
	 * 
	 * 4-allMatches(),noneMatches(),anyMatches()
	 * 
	 * Estes metodos pesquisam na stream e retornam true or false dependendo do
	 * predicate.Pode ou nao terminar uma infinite Streams(como
	 * iterate(seed,predicate,unary).Eles nao sao reductions pq eles nao olham todos
	 * os elementos.
	 * 
	 */

	public static void main(String[] args) {
		Stream<Integer> finiteCount = Stream.iterate(1, x -> x <= 4, y -> y + 1);
		// Stream<Integer> countWithInfinite = Stream.generate(() -> 2);
		System.out.println(finiteCount.count());
		// System.out.println(countWithInfinite.count());// Nao termina nunca

		Stream<Integer> minStream = Stream.of(1, 2, 3, 4);
		System.out.println(minStream.min((x, y) -> x - y));// Optional
		/*
		 * System.out.println(minStream.max((x, y) -> x - y)); exception, stream apos
		 * TerminalOperators nao e mais valida.
		 */
		Stream<Integer> maxStream = Stream.of(1, 2, 3, 4);
		System.out.println(maxStream.max((x, y) -> x - y));// Optional

		Stream<Integer> findFirst = Stream.generate(() -> 1234);
		System.out.println(findFirst.findFirst());// Optional

		Stream<Integer> allMatches = Stream.of(10, 100, 1000);// Retorna true se todos os elementos forem avaliados como
																// true no predicate.
		System.out.println(allMatches.allMatch(x -> x.toString().charAt(0) == '1' ? true : false));// Optional

		Stream<Integer> anyMatches = Stream.of(10, 100,
				1000);/*
						 * Retorna true se qualquer elemento for avaliado como true no Predicate.
						 */
		System.out.println(anyMatches.anyMatch(x -> x == 10));

		Stream<Integer> noneMatches = Stream.of(10, 100,
				1000);/*
						 * Retorna true se nenhum elemento for avaliado como true no Predicate.como^
						 */
		System.out.println(noneMatches.noneMatch(x -> x == 10));
	}
}
