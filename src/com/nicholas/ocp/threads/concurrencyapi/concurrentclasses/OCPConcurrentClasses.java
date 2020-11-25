package com.nicholas.ocp.threads.concurrencyapi.concurrentclasses;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OCPConcurrentClasses {

	/*
	 * Memory concurrency error ocorre quando duas threads tem inconsistencia de
	 * visualizaco onde os dados deveriam ser os mesmos.
	 * 
	 * Conceitualmente queremos que a gravacao de uma thread esteja disponivel para
	 * outra thread, se essa chamar uma concurrent class apos a gravacao.
	 * 
	 * Quando duas threads tentam modificar uma mesma collection, a JVM pode lancar
	 * uma ConcurrentModificationException, de fato pode ocorrer com single threads
	 * 
	 * concurrent classes
	 * 
	 * 1-ConcurrentHashMap, interfaces -> ConcurrentMap,Map; nao e ordenado nem
	 * sorteado; nao suporta blocking.
	 * 
	 * 2-ConcurrentLinkedQueue -> Queue, ordenado, nao sorteada;nao suporta blocking
	 * 
	 * 3-ConcurrentSkipListMap -> interfaces ->
	 * NavigableMap,ConcurrentMap,TreeMap,SortedMap, ordenada e sorteada; nao
	 * suporta blocking
	 * 
	 * 4-ConcurrentSkipListSet -> interfaces -> NavigableSet,SortedSet,TreeSet,
	 * ordenada e sorteada;nao suporta blocking
	 * 
	 * 5-CopyOnWriteArrayList -> interfaces -> List, ordenada e nao sorteada;nao
	 * blocking;
	 * 
	 * 6-CopyOnWriteArraySet -> interfaces -> Set, nao ordenada a nao sorteada;nao
	 * blocking;
	 * 
	 * 7-LinkedBlockingQueue -> interfaces -> BlockingQueue, ordenada, nao sorteada
	 * e suporta blocking.
	 * 
	 * Interfaces,estou querendo dizer de interfaces de java framework collection
	 */
	public static void main(String[] args) {
		/*
		 * List<String> lista = new ArrayList<>(List.of("nicholas")); lista.forEach(x ->
		 * { lista.remove(x); });
		 * 
		 * Ocorre a exception,pois removemos um elemento e o objeto do for each nao e
		 * atualizado.
		 * 
		 * versao com concurrent class
		 * 
		 */
		List<String> lista = new CopyOnWriteArrayList<>(List.of("nicholas"));
		lista.forEach(x -> {
			lista.remove(x);
		});
		System.out.println("lista size " + lista.size());
	}
}
