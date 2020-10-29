package com.nicholas.ocp.generics;

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
	 */
	public static void main(String[] args) {

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
}
