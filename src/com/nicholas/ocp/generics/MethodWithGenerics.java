package com.nicholas.ocp.generics;

public class MethodWithGenerics<T> {

	/*
	 * Generics em nivel de metodos tambem e possivel.
	 * 
	 * A menos que o metodo obtem o formal type parameter de uma classe ou
	 * interface, deve especificar o formal type parameter antes do tipo de retorno.
	 * 
	 * Ao voce especificar o formal type parameter antes do retorno do metodo, esse
	 * formal type parameter e independente do da classe.
	 * 
	 * A oracle refere-se a tipos cujo as informacoes estao disponiveis at Runtime.
	 * como reifiable.Refiable podem fazer tudo que o java permite.
	 * 
	 * Restricoes de generics.
	 * 
	 * 1-Nao podem ser instanciadas, new T(); -> Isso sera new Object() em tempo de
	 * execucao.
	 * 
	 * 2-Cria um array de generics.
	 * 
	 * 3-InstanceOf -> List<String> instanceOf List<Integer>, e tudo object em tempo
	 * de execucao, considerando o type erasure
	 * 
	 * 4-Primitivos, nao use primitivos em generics, use WRAPERS
	 * 
	 * 5-Variaveis statics como generics, tipo generic esta likada na instancia da
	 * classe.
	 * 
	 * 
	 */

	public <T> void a(T t) {

	}

//	public void naoCompila(T t) {
//		
//	}

	// Este formal type parameter e exclusivo do metodo, se vc tirar ele n vai pegar
	// o da classe como num metodo de instancia
	public static <T> T as(T t) {
		return t;
	}

}
