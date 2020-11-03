package com.nicholas.ocp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OCPGenerecis {

	/*
	 * Generics e usado para vc esperar oq tratar,por exemplo em um metodo.
	 *
	 * A sintaxe para introduzir uma generic,e declarar um formal type paramter
	 * entre chaves.
	 * 
	 * Convencoes para nomeacao de generics.
	 * 
	 * A convencao e usar uma unica letra em maiuscula, para deixar obvia que n e o
	 * nome de uma classe real.
	 * 
	 * K-> Map Key
	 * 
	 * V-> Map Value
	 * 
	 * E -> element
	 * 
	 * T-> Dados genericos
	 * 
	 * S,U,V -> Outros dados genericos.
	 * 
	 * N-> Number
	 * 
	 * Typed erasure.
	 * 
	 * Especificando o tipo generico, permite ao compilador imponha o uso adequado
	 * do tipo generico.
	 * 
	 * Por exemplo, especificando uma classe Crate<T>, em sua instancia quando
	 * passarmos o generico como Animal, e como se fosse que substituimos todos os T
	 * por Animals, mas so em tempo de compilacao.
	 * 
	 * Por baixo dos panos, o compilador todas as referencias T sao substituidos por
	 * Object, em outras palavras, codigo apos compilar, o tipo generico e
	 * Object(Porque especificar o tipo genercio, permite ao compilador impor o uso
	 * adequado do tipo generico).
	 * 
	 * Este processo de remover a sintaxe de tipos genericos, e chamado de Type
	 * Erasure.
	 * 
	 * Type Erasure, permite que seu codigo funcione com versoes que nao tenham
	 * tipos genericos.
	 * 
	 * Sendo assim, o compilador introduz casts relevantes em seu codigo para que
	 * funcione.
	 * 
	 * Como em classes, interfaces podem declarar um formal type parameter.
	 * 
	 * Cuidado com unbounded e lower bounded, removeIf por exemplo, so aceita
	 * metodos de object, ja que o java tem certeza de que eles sao object
	 * 
	 * Com upper bounded, somente os metodos do pai sao aceitos, por exemplo ?
	 * extends Object, somente os metodos de Object num removeIf seriam aceitos.
	 * Pois qualquer elementos filho de object teriam acesso ao metodos dele.
	 * 
	 * Unbounded e upper bounded, como nao da para determinar o tipo da List por
	 * exemplo, a lista se torna imutavel.
	 * 
	 * Cuidado ao adicionar elementos num lower bounded, pode ser que o elemento
	 * seja incompativel e cause um erro de compilacao.
	 * 
	 * List<? super OCPGenerics> lista .....
	 * 
	 * lista.add(new Object()); -> erro de compilacao, se a lista fosse do tipo
	 * OCPGenerics, objeto object nao poderia estar contido nessa collection.
	 * 
	 * Wildcards somente em parametros e variaveis. nao em classes
	 */
	private String nome;

	public OCPGenerecis(String nome) {
		super();
		this.nome = nome;
	}

	public OCPGenerecis() {
		super();
	}

	public static void main(String[] args) {
		List<Double> dList = Arrays.asList(10.0, 12.0);
		dList.forEach(x -> {
			x = x + 10;
		});
		dList.forEach(x -> System.out.println(x));
		List<OCPGenerecis> lista = new ArrayList<>();
		java.util.function.Predicate<OCPGenerecis> pc = new OCPGenerecis()::isBlank;
		// pc.test(new OCPGenerecis("nicholas"));
		lista.add(new OCPGenerecis("Barbosas"));
		lista.add(new OCPGenerecis("nicholas"));
		lista.removeIf(pc);
		System.out.println(lista);
		List<? extends OCPGenerecis> listaLower = new ArrayList<>();
		listaLower.removeIf(pc);
		class Crat<T> {
			private T variable;

			private void set(T t) {
				this.variable = t;
			}

			private T take() {
				return this.variable;
			}
		}

		Crat<String> crat = new Crat<>();
		crat.set("Nicholas");
		/*
		 * Compilador faz isso.
		 * 
		 * String p24 = (String)crat.take();
		 */

		String p2 = crat.take();
		System.out.println(p2);
		/*
		 * String nao conhece Crat, e nem Crat conhece String. Vai ocorrer o type
		 * erasure
		 */
	}

	public boolean isBlank(OCPGenerecis s) {
		if (s.nome.contains("n"))
			return true;
		return false;
	}
}

class SonTeste extends OCPGenerecis {

	public boolean isBlank() {
		return true;
	}
}

class W {
}

class X extends W {
}

class Y extends X {
}

class Z<s> {
	W w3 = new Y();
}
