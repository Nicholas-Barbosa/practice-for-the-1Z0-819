package com.nicholas.ocp.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoundedParameterType {
	/*
	 * Bounded Parameter type e um generico, que especifica um limite pro generico
	 * 
	 * Wildcard general type -> E um generico desconhecido marcado como ?. Podem
	 * aparecer em tres formas.
	 * 
	 * A sintaexe para implementacao de um generics,e declarar um formal type
	 * parameter, entre colchetes angulares.
	 * 
	 * 1->Unbounded Wildcard-> Representa qualquer tipo. Usando ? ,todos os tipos
	 * podem ser formal type perameter.
	 * 
	 * 2->Upper Bounded Wildacard -> Sintaxe ? extendes Type, diz que qualquer tipo,
	 * classe que extends Number por exemplo ou proprio nummber, pode ser um formal
	 * parameter type.
	 * 
	 * Uma coisa interessante que acontece ao usar unbounded wildcard e upper bound,
	 * e que a List se torna imutavel, o java nao sabe qual o tipo de List</ extends
	 * Number>
	 * 
	 * 3-Lower Bounded Wildcards -> sintaxe ? super String, qualquer classe pai de
	 * String ou String pode ser um formal paramter type.
	 * 
	 * Lembre-se, nao misture o nome do tipo genereico com um wildcard general type.
	 * 
	 */
	public static void main(String[] args) {
		List<? super IOException> lista = new ArrayList<Exception>();
		// lista.add(new Exception()); Nao compila, esta List pode IOException,
		// Exception ou object. Se fosse IOException, objeto Exception nao poderia ser
		// armazenado nessa collection.
		lista.add(new FileNotFoundException());
		new BoundedParameterType().Unbounded(new ArrayList<Object>());
		new BoundedParameterType().Unbounded(new ArrayList<String>());
		/*
		 * Upper Bounded, sintax -> ? extends Type
		 */
		new BoundedParameterType().UpperBounded(new ArrayList<Son>());
		new BoundedParameterType().UpperBoundedWithInterface(new LinkedList<Son>());
		/*
		 * Lower Bounded, sintax -> ? extends Type
		 */
		new BoundedParameterType().lowerBounded(new LinkedList<Interface>());
		new BoundedParameterType().lowerBounded(new LinkedList<Object>());
		new BoundedParameterType().lowerBounded(new LinkedList<Interface>());
		/*
		 * Na hora de instancias, o java precisa saber qual tipo e o generic.
		 */
		List<? extends Interface> li = new ArrayList<Son>();
		new BoundedParameterType().<Son>t();
	}

	public void Unbounded(List<?> takesItAll) {
		// Imutavel, o java nao sabe o tipo.Remove pode!
		takesItAll.remove(9);
	}

	public void UpperBounded(List<? extends BoundedParameterType> upper) {
		// Imutavel, o java nao sabe o tipo.Remove pode!
		upper.remove(0);
	}

	public void UpperBoundedWithInterface(List<? extends Interface> upper) {
		// Imutavel, o java nao sabe o tipo.Remove pode!
		upper.remove(0);
	}

	public void lowerBounded(List<? super Son> li) {
		li.add(new Son());
	}

	public <T extends Interface> T t() {
		return null;
	}

//	public <T>void mixGenericNameWithWildCard(List<T extends Interface>l){
//		
//	}
}

	class Son extends BoundedParameterType implements Interface {
	}

interface Interface {
}
