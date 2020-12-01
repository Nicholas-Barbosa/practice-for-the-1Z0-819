package com.nicholas.ocp.streams.parallel;

import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class OCPCollectParallel {

	/*
	 * collect() pega uma supplier para criar um objeto que sera armazenado os
	 * elementos.
	 * 
	 * Accumulator, BiConsumer para adicionar o elemento ao container, gerar os
	 * valores intermediarios.
	 * 
	 * Combinner, BiConsumer para fundir os dois containers, gerando os resultados
	 * finais.
	 * 
	 */

	public static void main(String[] args) {
		/*
		 * Usar cocncurrent collection para combinar resultados, garantir que os
		 * resultados da outras threads, nao lancem ConcurrentModificationExcpetion
		 */
		Stream<Integer> stream = Stream.of(4, 2, 1, 9, 3).parallel();
		SortedSet<Integer> set = stream.collect(ConcurrentSkipListSet::new, SortedSet::add, SortedSet::addAll);
		System.out.println(set);
		System.out.println();
		Stream<Integer> stream2 = Stream.of(4, 2, 1, 9, 3).parallel();
		List<Integer> list = stream2.collect(CopyOnWriteArrayList::new, List::add, List::addAll);
		System.out.println(list);
	}
}
