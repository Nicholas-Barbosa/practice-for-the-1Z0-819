package com.nicholas.ocp.threads;

public class OCPRunnable {

	/*
	 * Interface Funcional que pode ser implementada usando lambda expression.
	 * Possui o metodo run que retorna void e nao pega nenhum parametro.
	 */

	public static void main(String[] args) {
		Runnable run1 = () -> System.out.println("run1");
		Runnable run2 = () -> System.out.println("run2");
		Runnable run3 = () -> System.out.println("run3");

		run1.run();
		run2.run();
		run3.run();
	}
}
