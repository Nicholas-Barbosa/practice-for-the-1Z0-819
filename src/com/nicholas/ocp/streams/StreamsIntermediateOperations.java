package com.nicholas.ocp.streams;

import java.util.stream.Stream;

public class StreamsIntermediateOperations {

	/*
	 * Esses metodos retornam uma Stream como resultado, e nao um objeto ou
	 * primitivo como nos TerminalOperations
	 * 
	 * 1-filter() -> Retorna um stream com os elementos que combinam com o predicate
	 * passado.
	 * 
	 * 2-distinct() -> Retorna uma stream com elementos nao duplicatos, o java chama
	 * o equals para cada objeto na stream.
	 * 
	 * 3-map() -> Cria um mapeamento one-to-ne com os elementos na stream para os
	 * elementos do proxima etapa da stream
	 * 
	 * 4-flatMap() -> Pega cada elemento na stream e fabrica qualquer elemento que
	 * contiver um top level num unico stream.Util quando esta trabalhando com lists
	 * vazias ou quer combinar streams de lists
	 * 
	 * 5-skip() limit() -> Estes metodos pode criar uma finite Stream ou numa
	 * Infinite.
	 * 
	 * skip() -> Retorna uma infinite stream apartir do numero que vc passou.
	 * 
	 * limit() -> Determina um limite de elementos numa finite Stream.
	 * 
	 * 6-sorted() -> Retorna uma Stream com os elementos sorteados, se nao for
	 * passado nenhum comparator, sera usado a naturalOrder() especidficado na
	 * implementacao comparable().
	 * 
	 * 7-peek() -> Este metodo serve como dubugging do stream pipeline. Ele e como o
	 * forEach mas e IntermediateOperator.
	 *
	 */

	public static void main(String[] args) {
		Stream<String> togetherOnPipeline = Stream.of("Nichola", "Barbosaa", "Nicholas");
		System.out.println(togetherOnPipeline.limit(1).filter(x -> x.length() >= 8).distinct()
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append));
		System.out.println();
		Stream<String> togetherOnTwPipeline = Stream.of("Nicholas", "Barbosaa", "Nicholas");
		System.out.println(
				togetherOnTwPipeline.filter(x -> x.length() >= 8).distinct().min((x1, x2) -> x1.compareTo(x2)));
		System.out.println();

	}
}
