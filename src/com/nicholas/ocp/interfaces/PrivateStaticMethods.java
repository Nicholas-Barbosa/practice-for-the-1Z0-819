package com.nicholas.ocp.interfaces;

public interface PrivateStaticMethods {

	/*
	 * Duas regras de definição
	 * 
	 * 1-Para ser private,deve ter private keyword e implementar um body
	 * 
	 * 2-Podem ser chamados por qualquer metodo definido dentro da interface
	 * 
	 */

	private void m1() {
		mkS();
	}

	default void mk2() {
		m1();
	}

	private static void mkS() {

	}
}
