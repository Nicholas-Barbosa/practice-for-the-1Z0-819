package com.nicholas.ocp.testes;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReference {

	/*
	 * 
	 * Se comporta como lambda, pode apresentar em 4 formas.
	 * 
	 * 1-Metodo static.
	 * 
	 * 2-Num metodo de instancia de uma instancia particular.
	 * 
	 * 3-Metidi de instancia em parametro a ser definido at runtime.
	 * 
	 * 4-E em um construtor.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// Metodo static.
		Consumer<List<Integer>> met = Collections::sort;
		// Metodo de instancia
		String str = "Nicholas";
		Predicate<String> prei = str::startsWith;
		/*
		 * Metodo de instancia em um parametro a ser definido
		 * 
		 * O java pega o parametro fornecido at runtim e usa como instanci na qual esta
		 * chamando o metodo de instancia.
		 */
		Function<String, Boolean> sr = String::isEmpty;
		Consumer<String> o = MethodReference::teste;
		Consumer<Integer> o4 = MethodReference::teste;
		Consumer<MethodReference> o2 = MethodReference::test2;
		BiConsumer<String, Integer> biCon = new MethodReference()::testeBiCo;
	}

	private static void teste(String st) {

	}

	private static void teste(Integer st) {

	}

	public void testeBiCo(String i, Integer o) {
	}

	public MethodReference test2() {
		return null;
	}

}
