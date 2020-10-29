package com.nicholas.ocp.generics;

public class InterfaceGenerics implements Generics<String> {
	/*
	 * Como em classes, interfaces podem declarar um formal type parameter.
	 * 
	 * interface Generics<T>{}
	 * 
	 * Ha tres formas de implemenacao.
	 * 
	 * 1-Especificar o tipo generico na classe.
	 * 
	 * 2-Cria um classe generica, permite que o chamador especifique o generics da
	 * classe e da interface
	 * 
	 * Raw Type
	 * 
	 * Essa ultima forma de implementar uma interface com tipo generico, e antiga e
	 * nao usa generics.
	 * 
	 * Voce pode implemetar a interface, sem especificar o tipo generico entre os
	 * colchetes angulares, dara um warinning mas vc pode igonorar esse warning
	 * usando @SupressWarining("unchecked").Essa interface sera uma Raw Type
	 */
	class SecongWay<T> implements Generics<T> {

	}

	class RawType implements Generics {
		/*
		 * Interface generics esta sendo uma Raw Type.
		 */
		
	}

	public static void main(String[] args) {

	}
}

interface Generics<T> {
}
