package com.nicholas.ocp.interfaces;

public interface DefaultMethods {

	/*
	 * 5 regras de defini��es
	 * 
	 * 1-S� podem ser definidos em interfaces
	 * 
	 * 2-Para ser um defualt, deve ter o default keyword e implementar um body
	 * 
	 * 3-Implicitamente public.
	 * 
	 * 4-N�o pode ser marcado como abstract, final ou static.
	 * 
	 * 5-Opcional override, mas preste aten��o na proxima regra
	 * 
	 * 6-Se a classe que implementa mais de uma interface que possui metodos com a
	 * mesma assinatura,DEVE ocorrer o override!!
	 */

	default void metodo() {

	}

//	public default void metodo() {
//		
//	}
	default void metodo2() {

	}
}

interface Regra6 {
	public default void metodo() {

	}

}

class Filha implements Regra6, DefaultMethods {

	@Override
	public void metodo() {

	}
}
