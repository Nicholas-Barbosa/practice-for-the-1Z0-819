package com.nicholas.ocp.functinalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class OCPFunctionEBi {

	/*
	 * Function, BiFunction e responsavel por transformar 1 e 2 parametros
	 * respectivamemte, num tipo potencialmente diferente.
	 * 
	 * Metodo apply(T), pega os parametros passados, R seu tipo de retorno.
	 * 
	 * Function<T,R>
	 * 
	 * BiFunction<T,U,R> seguindo as convencoes
	 */
	public static void main(String[] args) {
		Function<String, Integer> f1 = String::length;
		System.out.println(f1.apply("Nicholas"));
		// Neste caso, transformou o parametro passado em String num Integer. o metodo
		// lenght retornou um int mas ocorreu o autoboxing.
		BiFunction<String, String, Boolean> bi = String::startsWith;
		System.out.println(bi.apply("Ni", "N"));
	}
}
