package com.nicholas.ocp.fundamentals;

public interface InterfaceNewMethods {

	default void myMethodDf() {
		/*
		 * 1-Metodos de default so podem ser definidos numa interface.
		 * 
		 * 2-Sao implicitamente public.
		 * 
		 * 3-Para ser default, devem possuir default keyword e implementar um body.
		 * 
		 * 4-Nao podem ser marcados como abstract, final ou static.
		 * 
		 * 5-Podem ser overriden pelo tipo que implementa a interface.
		 * 
		 * 6-Se a classe herdar de dois ou mais metodos com a mesma assinatura, ele deve
		 * fornecer uma implementacao.!
		 * 
		 */
		System.out.println("Default method!");
	}

	static void myStaticMethod() {
		/*
		 * 1-Deve ter static keyword e implementar um body.
		 * 
		 * 2-Nao pode ser marcado como abstract ou final.
		 * 
		 * 3-Se nao houver nenhum modificador de acesso,sao implicitamente public.
		 * 
		 * 4-Estes metodos nao sao herdados, istor resolve o problema dos metodos
		 * defaults, que se for herdados dois ou mais metodos com a mesma assinatura, a
		 * covariante deve fornecer uma implementacao.Deve haver a referencia do nome da
		 * interface para serem chamados.
		 */
		System.out.println("My static method");
	}

	private void myPrivateMethod() {
		/*
		 * Deve haver o private key word e um body. So podem ser chamados por metodos
		 * default ou outros metodos privates.
		 */
		System.out.println("My private method");
		myPrivateStaticMethod();
	}

	private static void myPrivateStaticMethod() {
		/*
		 * Deve haver o private static key word e um body.Podem ser chamados por
		 * qualquer metodo dentro da interfce.
		 */
		System.out.println("My private static method");
	}
}
