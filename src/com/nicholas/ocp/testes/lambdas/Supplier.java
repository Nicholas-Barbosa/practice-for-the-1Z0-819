package com.nicholas.ocp.testes.lambdas;

public class Supplier {
	/*
	 * Supplier n pega nenhum parametro,por isso nao use o method reference como
	 * instancia em um parametro a ser determinado.
	 * 
	 * Supplier<T> tipoi de retorno e T!!
	 */
	public static void main(String[] args) {
		java.util.function.Supplier<Integer> sup = new Supplier()::testeSupplir;
		java.util.function.Supplier<Integer> sup2 = () -> new Supplier().testeSupplir();
	}

	public Integer testeSupplir() {
		return null;
	}
}
