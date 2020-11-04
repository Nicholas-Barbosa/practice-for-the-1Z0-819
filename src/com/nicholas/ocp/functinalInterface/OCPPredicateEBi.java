package com.nicholas.ocp.functinalInterface;

import java.util.function.BiPredicate;
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
		
	}
}
