package com.nicholas.ocp.interfaces;

public interface StaticMethods {

	/*
	 * 4 regras de definição
	 * 
	 * 1-Para ser static deve conter a static keyword e implementar um body
	 * 
	 * 2-Se não houver um modificador de acesso, implicitamente public.
	 * 
	 * 3-Não pode ser marcada como abstract ou final
	 * 
	 * 4-Elas não são herdas, dito isso a classe que implementa essa interface deve
	 * chamar esse metodo com uma referencia de nome dessa interface
	 */

	static void metodo() {

	}
}

class HerdaSqn implements StaticMethods {

	public static void metodo() {

	}

	{
		StaticMethods.metodo();
	}
}
