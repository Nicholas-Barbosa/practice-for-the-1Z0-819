package com.nicholas.ocp.interfaces;

public interface QubrouARegraSAM {

	/*
	 * Se a interface incluir um método com a mesma assinatura(nome e parametro) de
	 * um dos publicos presentes na classe object, quebra a regra SAM e ela não é
	 * mais fincional!O java meio que ignora os metodos da classe object,presentes
	 * aqui!!
	 * 
	 * String toString()
	 * 
	 * boolean equals(Object)
	 * 
	 * int hashCode()
	 */

	String toString();

	String toString(int n2);

	boolean equals(Object o);

	int hashcode();
	
	/*
	 * stra=dogood
	 * strb=good
	 */
}
