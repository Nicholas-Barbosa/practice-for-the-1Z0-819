package com.nicholas.ocp.testes;

public class TesteDefaultMethods implements ComDefault, ComDefault2 {
/*
 * 1-Metodos defaults so podem ser definidos dentro de uma interface
 * 
 * 2-Os metodos que são defaults, devem ser marcados com a default keyword e implementar um body
 * 
 * 3-São implicitamente finals
 * 
 * 4-Não podem ser marcadados como abstract,final ou static
 * 
 * 5-A classe que implementa esta interface,pode dar override
 * 
 * 6-Se classe herda dois ou mais metodos defautls com a mesma assinatura, ela deve override, se nao compila
 */
	public void metodo() {

	}

	public void metodo(String p1) {

	}
	public void metodo(int p1) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface ComDefault {

	public default void metodo() {
		System.out.println("Metodo1");
	}
}

interface ComDefault2 {

	public default void metodo(String p1) {
		System.out.println("Metodo2");
	}
}
