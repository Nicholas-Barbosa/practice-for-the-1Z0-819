package com.nicholas.ocp.streams.parallel;

import java.util.stream.Stream;

public class OCPReduceParallel {

	/*
	 * Metodo reduce, q junta tudo da stream num single object. Relembrando,
	 * primeiro parametro chamado seed, segundo accumulator e o ultimo combiner.
	 * 
	 * O reduce() com parallelStreams, aplica o reduction(accumulator) com pares de
	 * valores gerando valores intermediarios, o accumulator vai pegar esses valores
	 * intermediarios, os combinando e ira criar o rsutlado.
	 * 
	 * Por isso, agora e importante usar a mesma logica no combiner e no
	 * accumulator.
	 * 
	 * Lembrando que o accumulator no reduce() junta current result com o current
	 * value na strem.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Stream<String> word = Stream.of("W", "O", "L", "F").parallel();
		System.out.println(word.reduce("", (a, b) -> a + b, (s1, s2) -> s1 + s2));
		System.out.println();
		/*
		 * Problematic accumulator, no codigo a baixo estaremos usando o accumulator
		 * como combiner. Como o identuty e aplicado a todos os elementos na stream, o
		 * combiner tem um papel importante de juntar os valores intermediarios gerados
		 * pelo accumulator
		 * 
		 */
		Stream<Integer> word2 = Stream.of(1, 2, 3, 4, 5).parallel();
		System.out.println(word2.reduce(0, (s1, s2) -> s1 - s2));
		System.out.println();

		/*
		 * Accumulator ira gerar valores intermediarios. Como o identity sera aplicado
		 * para todo mundo, entao 0-1=-1; 0-2=-2;0-3=-3;0-4=-4;0-5=-5 .
		 * 
		 * Combinner ira pegar e fundir ester valores gerando valor final.
		 */
		Stream<Integer> correct = Stream.of(1, 2, 3, 4, 5).parallel();
		System.out.println(correct.reduce(0, (s1, s2) -> s1 - s2, (i1, i2) -> i1 + i2));
		System.out.println();
		/*
		 * Identity aplicado a muitos elementos da stream,concorrentemente
		 */
		Stream<String> word3 = Stream.of("W", "O", "L", "F").parallel();
		System.out.println(word3.reduce("X", (s1, s2) -> s1 + s2));
	}
}
