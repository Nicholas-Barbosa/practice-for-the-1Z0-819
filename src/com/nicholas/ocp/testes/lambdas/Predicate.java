package com.nicholas.ocp.testes.lambdas;

public class Predicate {
	/*
	 * Predicate sempre retornar um boolean, predicate<T> parametro do metodo
	 * abstrato.
	 * 
	 * BiPredicate <T,R> sempre retorna um boolean, parametros do metodo abstrato
	 */

	public static void main(String[] args) {
		java.util.function.BiPredicate<Predicate, String> s1 = Predicate::testeSup2;
		java.util.function.Predicate<Predicate> s13 = Predicate::teste;
	}

	public boolean testeSup2(String st2) {
		return false;
	}

	public boolean teste() {
		return false;
	}
}
