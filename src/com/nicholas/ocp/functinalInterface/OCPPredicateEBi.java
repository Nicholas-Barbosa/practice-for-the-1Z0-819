package com.nicholas.ocp.functinalInterface;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class OCPPredicateEBi {

	/*
	 * Predicate ou BiPredicate, sao interfaces funcionais, cujo retornam
	 * boolean(primitivo) e pegam 1 e 2 parametros respectivamente.
	 * 
	 * Usamos quando queremos filtrar uma list por exemplo, remover,etc.
	 */

	public static void main(String[] args) {
		Predicate<String> p = String::isEmpty;
		System.out.println(p.test(""));

		BiPredicate<String, String> bp = String::startsWith;
		System.out.println(bp.test("nihoals", "n"));

		Predicate<String> p1 = s -> s.startsWith("n");
		Predicate<String> p2 = s -> s.endsWith("s");
		Predicate<String> together = p1.and(p2).negate();
		System.out.println(together.test("n"));

		Function<Integer, Integer> f1 = s -> s * 10;
		Function<Integer, Integer> f2 = s -> s + 0;
		Function<Integer, Integer> funTogether = f2.compose(f1);
		System.out.println(funTogether.apply(10));

		/*
		 * Retorno do compose da functiona dentro do compose, serve como parametro de
		 * entrada pra quem ta chamando
		 * 
		 * 
		 */
	}
}
