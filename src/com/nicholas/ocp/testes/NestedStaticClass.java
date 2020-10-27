package com.nicholas.ocp.testes;

import com.nicholas.ocp.testes.NestedStaticClass.Nested;;

public class NestedStaticClass {
	/*
	 * Como se fosse a inner class, mas nao precisa ser instanciada a classe outer,
	 * para instanciar a nested. Por isso ela n tem acesso a membros da outer class
	 * sem uma referencia explicita
	 * 
	 * Ela como sefosse uma top level class, excter por tres motivos
	 * 
	 * 1-> O aninhameno cria um namespace porque outer class precisa se referencias
	 * , exemplo de importação -> import
	 * com.nicholas.ocp.testes.NestedStaticClass.Nested;;
	 * 
	 * 2-> Ela pode ter qualquer modificador de acesso
	 * 
	 * 3-> A outer class tem acesso a qualquer variavel ou metodo da nested
	 * 
	 */

	static {
		System.out.println(Nested.x);
	}
	int z = 9;

	 public static class Nested {
		static int x = 10;
	}

	public static void main(String[] args) {
		Nested ns = new Nested();

	}
}