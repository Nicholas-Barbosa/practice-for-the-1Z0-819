package com.nicholas.ocp.testes.lambdas;

public class Function {
	/*
	 * Function pega 1 parametro, vc especifica Function<T,R> sendo R o tipo de
	 * retorno e T o param.
	 */

	public static void main(String[] args) {
		java.util.function.Function<String, Integer> sop = new Function()::testeSup;
		/*
		 * Method reference num metodo de instancia num parametro, java pega o
		 * Function(t) de parametro como instancia do metodo a ser chamado.
		 */
		java.util.function.Function<Function, Integer> sopSt = Function::testeSup;
		java.util.function.BiFunction<Function, Integer, Integer> sopSt3 = Function::testeSup;
		
	}

	public Integer testeSup(String st1) {
		return null;
	}

	public Integer testeSup() {
		return null;
	}

	public Integer testeSup(Integer st2) {
		return null;
	}

	public boolean testeSup2(String st2) {
		return false;
	}

}
