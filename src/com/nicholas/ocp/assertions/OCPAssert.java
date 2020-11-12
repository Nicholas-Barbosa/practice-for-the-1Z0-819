package com.nicholas.ocp.assertions;

public class OCPAssert {

	/*
	 * Assertions e uma expressao boolean que vc poem no seu codigo, onde vc espera
	 * que algo seja true.
	 * 
	 * Assert statement, contem assertion e mais uma mensagem opcional.
	 * 
	 * Um assertions pode produzir tres coisa
	 * 
	 * 1-Se estiver desativado, o java pula o assert e continua em frente.
	 * 
	 * 2-Se estiver ativado e a expressao boolean for validada, o java continua em
	 * frente.
	 * 
	 * 3-Se estiver ativado e a expressao nao for validada, e lancado uma
	 * AssertionError e o programa stop, fatal!
	 * 
	 * assertions e como se fosse o following if
	 * 
	 * if(!boolean_expression)throw new AssertionError(message); Por padrao os
	 * assertions sao desativados pela JVM, para ativar vc usa o flag -ea ou
	 * -enableassertions.
	 * 
	 * java -ea: com.pa... MyProgram
	 * 
	 * estamos ativando os assertions para todas as classes de pacote e subpacote
	 * 
	 * Para desativar, -da ou -disableassertions
	 * 
	 * java -da: com.pa... MyProgram
	 * 
	 * estamos desativando para todos as classes desse pacote e subpacote
	 */

	public static void main(String[] args) {
		String nome = "nicholas";
		assert nome.equals("nicholas") : "diferente!";
	}
}
