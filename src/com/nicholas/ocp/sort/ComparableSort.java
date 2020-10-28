package com.nicholas.ocp.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComparableSort implements Comparable<ComparableSort> {
	/*
	 * Lembre-se,os elementos sao classificados numa ordem natural para numeros,para
	 * String -> numeros antes de letras, maiusculas antes minusculas.
	 * 
	 * Qualquer objeto pode ser comparable e implemenatar o campareTo().
	 * 
	 * Regras de retorno.
	 * 
	 * 1-Numero 0 se o current object for igual ao objeto passado no parametro.
	 * 
	 * 2-Numero positivo, current object maior que o objeto passado no argumento.
	 * 
	 * 3-Numero negativo, current object menor que o objeto passao no argumento.
	 * 
	 * compareTo() e dito ser consistente com o metodo equals, se somente se,
	 * x.equals(y) for true sempre que x.compareTo(y) for 0.
	 * 
	 * Mesma coisa o contrario, x.equals(y) deve ser false, toda vez que
	 * x.compareTo(y) nao for 0.
	 * 
	 * id-a.id -> ascendente
	 * 
	 * a.id - id -> descendente
	 */

	private String nome;

	public ComparableSort(String nome) {
		super();
		this.nome = nome;
	}

	private Integer id;

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public boolean equals(Object obj) {
		ComparableSort comp = (ComparableSort) obj;
		return id == comp.getId();
	}

	@Override
	public int compareTo(ComparableSort o) {
		System.out.println("metodo compareTo current o " + nome + " param " + o.getNome());
		return nome.compareTo(o.getNome());
	}

	public static void main(String[] args) {
		ComparableSort comp1 = new ComparableSort("Nicholas");
		ComparableSort comp2 = new ComparableSort("Barbosa");
		// System.out.println(comp1.compareTo(comp2));
		var lista = new ArrayList<ComparableSort>();
		lista.add(comp1);
		lista.add(comp2);
		lista.add(new ComparableSort("Cestari"));
		Collections.sort(lista);
		lista.forEach(System.out::println);
	}
}
