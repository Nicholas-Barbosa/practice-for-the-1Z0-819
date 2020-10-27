package com.nicholas.ocp.interfaces;

public interface StaticMethods {

	/*
	 * 4 regras de defini��o
	 * 
	 * 1-Para ser static deve conter a static keyword e implementar um body
	 * 
	 * 2-Se n�o houver um modificador de acesso, implicitamente public.
	 * 
	 * 3-N�o pode ser marcada como abstract ou final
	 * 
	 * 4-Elas n�o s�o herdas, dito isso a classe que implementa essa interface deve
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
