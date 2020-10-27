package com.nicholas.ocp.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCollection {

	/*
	 * Normalmente usamos set quando nao estamos preocupado com a ordem da
	 * collection.
	 * 
	 * Essa collection nao aceita elemtos duplicados.
	 * 
	 * Suas implementacoes sao HashSet e TreeSet.
	 * 
	 * HashSet -> Armazena seus valores num HashTable,isto significa que as keys sao
	 * um hash e os valores sao um object.Ele chama o metodo hasCode() dos objetos
	 * para recupera-los de uma forma mais eficiente.
	 * 
	 * A principal vantagem de uma Set, e que a acao de adicionar um elemento no set
	 * e verificar se o mesmo ja existe no set, sao em tempos constantes. Sendo
	 * assim nao ha perda de performance(diferente do TreeSet). Desvantagem, vc
	 * perde a ordem do set.
	 * 
	 * TreeSet -> Armazena seus valores num sorted tree structure(estrutura de
	 * arvore ORDENADA).
	 * 
	 * A principal vantagem de usar um TreeSet, os elementos estao sem ordenados no
	 * set. A desvanatgem, o ato de adicionar o elemento e verificar se o mesmo ja
	 * esta no set, demora mais do que num HashSet,ja que os tempos de ambos sao
	 * constantes.
	 * 
	 * HashSet, como dito os elementos sao armazenados num Hash Table, ele chama o
	 * hash code dos objetos para recuperar os elementos.
	 * 
	 * O metodo equals() e usado para verificar a igualdade de objetos.
	 * 
	 * hashCode() usado para saber em qual intervalo procurar, para que o java nao
	 * examine todo o set para saber se o elemento ja esta ou nao no "conjunto".
	 * 
	 * No melhor caso, os codigos hash sao exclusivos e o java tera de chamar o
	 * equals em apenas num objeto.
	 * 
	 * No pior caso, as instancias retornam o mesmo hashCode(), e o java tera de
	 * chamar o equals() para todos os objetos.
	 * 
	 * Podemos criar uma list imutavel em apenas uma linha(Set.of(),Set.copyOf);
	 * 
	 * Metodos do set sao todos os do list(add,remove,clear,etc)Exceto aqueles que
	 * pegam como parametro o index do elemento.
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		class Person {
			private String nome;

			public Person(String nome) {
				this.nome = nome;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return nome;
			}

			@Override
			public boolean equals(Object obj) {
				System.out.println("Equals");
				Person person = (Person) obj;
				return this.nome.equals(person.nome) ? true : false;

			}

			@Override
			public int hashCode() {
				System.out.println("Hashcode!");
				return nome.charAt(0);
			}
		}
		Set<String> setComHashSet = new HashSet<>();
		setComHashSet.add("Nicholas");
		setComHashSet.add("Cabral");
		setComHashSet.add("Barbosa");
		System.out.println("I dont care about order! I care about performance to add() " + setComHashSet);
		Set<String> setTreeSet = new TreeSet<>(Set.copyOf(setComHashSet));
		System.out.println("I care about order, however I dont care about performance to add() " + setTreeSet);
		System.out.println();
		Set<Person> setPerson = new HashSet<>();
		Person person = new Person("Nicholas");
		Person person2 = new Person("Nicholas2");
		setPerson.add(person);
		setPerson.add(person2);
		System.out.println(setPerson);
	}

}
