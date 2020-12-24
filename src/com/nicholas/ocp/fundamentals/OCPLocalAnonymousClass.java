package com.nicholas.ocp.fundamentals;

import java.io.PrintWriter;
import java.util.function.Predicate;

public class OCPLocalAnonymousClass {

	private String instanceField = "Nicholas";

	private void methodWithLocalClass() {
		String localField = instanceField + " Barbosa";
		class MyLocalClass {
			/*
			 * Classe aninhada difinida dentro de um metodo de instancia. Como as variavies
			 * locais, elas so existem quando o metodo e invocado. Apos a invocacao do
			 * metodo, ela perde seu escopo.
			 * 
			 * Possui as seguintes propriedades.
			 * 
			 * 1-Nao tem modificador de acesso(private-package)
			 * 
			 * 2-Nao tem nenhum metodo ou variavel estatica, exceto variavies static final.
			 * 
			 * 3-Possuem acesso a todos os campos da outer class(quando definida num metodo
			 * estatico)
			 * 
			 * 4-Podem acessar variavies locais, desde que sejam efetivamente final ou
			 * final.
			 */
			{
				System.out.println("Instance field " + instanceField);
				System.out.println("Local field effectvely final " + localField);
			}
		}

		new MyLocalClass();

	}

	private void methodWithAnonimousClass(Integer number) {
		/*
		 * Tipo especializado de uma local class que nao possui nome.Criada e
		 * instanciada numa mesma expressao.
		 * 
		 *
		 */

		/*
		 * Estamos implementando a interface funcional predicate, sem lambdas.
		 */
		Predicate<Integer> predAnonymous = new Predicate<Integer>() {

			public boolean test(Integer i) {
				if (i <= 10)
					return true;
				return false;
			}
		};
		System.out.println("result " + predAnonymous.test(number));
	}

	public static void main(String[] args) {
		OCPLocalAnonymousClass localAn = new OCPLocalAnonymousClass();
		localAn.methodWithLocalClass();
		localAn.methodWithAnonimousClass(900);
	}
}
