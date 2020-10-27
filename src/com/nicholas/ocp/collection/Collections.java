package com.nicholas.ocp.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Collections {

	/*
	 * Diamond operator e uma shorthand notation usada para omitir o tipo generico
	 * do lado direito numa expressao, quando o tipo pode ser inferido.
	 * 
	 * Uma collection e um grupo de objetos contido num unico objeto.
	 * 
	 * Collections Framework conjunto de classes para armazenas esses objetos.
	 * 
	 * List -> Collection ordenada que aceita duplicatas.
	 * 
	 * Set -> Collection nao aceita duplicatas.
	 * 
	 * Queue -> Collection orderna seus elementos por ordem especifica para
	 * processamento. Normalemte processa pela ordem de primeiro entrar/sair. Podem
	 * ser usadas outras.
	 * 
	 * Map -> Mapeia seus elementos na nocao key to value.Nao pode ter keys
	 * repetidas.
	 * 
	 * Map nao extends Collection!
	 * 
	 * ArrayList implements List.
	 * 
	 * LinkedList implements queue e listt.
	 * 
	 * HashSet e TreeSet implements Set.
	 * 
	 * HashMap e TreeMap implements Map.
	 * 
	 * Metodos de uma collection.
	 * 
	 * 1-> add(Object o) retorna true(list) e false(set se houver duplicatas),ao
	 * adicionar um elemento.
	 * 
	 * 2-remove(Object o) overload remove(int index), retorna true se for removido!
	 * 
	 * 3-isEmpty e size, eles contam os elementos numa collection.
	 * 
	 * 4-contains() Verifica na collection se ha um certo valor.Ele chama o equals()
	 * para cada elemento
	 * 
	 * 5-Clear discarta tudoooo!
	 * 
	 * 6-> removeIf(), remove sobre certa condicao, usa predicate mas nao pode usar
	 * method reference com metodos que precisam de um parametro, como startswith()
	 * 
	 * 7->forEach(),itera na collection,pode usar method reference.
	 * 
	 */

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.add("Nicholas");
		queue.add("Nicholas");
		queue.forEach(System.out::println);
		/*
		 * como se fosse isso abaixo. queue.forEach(s -> System.out.println(s));
		 * 
		 */

		System.out.println("Tem n?? " + queue.contains("Nicholas"));
		System.out.println(queue);
		Function<String, Boolean> pre = String::isEmpty;
		BiPredicate<String, String> pred = String::startsWith;
		BiFunction<String, String, Boolean> fin = String::startsWith;
		/*
		 * Usando List
		 */

		Set<String> set = new TreeSet<>();
		System.out.println(set.add("nichoals"));
		System.out.println(set.add("nichoals"));
		int mask = 0x000F;
		int value = 0x2222;
		System.out.println(mask & value);
		int n = 3;
		String result = (n % 2) == 0 ? "not weird" : "Weird";
		System.out.println("42.0".matches("[0-9]*"));		 
	}
}
