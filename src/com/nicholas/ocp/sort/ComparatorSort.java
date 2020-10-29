package com.nicholas.ocp.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparatorSort {

	/*
	 * Comparator e uma forma alternativa do camparable.
	 * 
	 * Ha algumas diferencas entre eles,
	 * 
	 * 1-Nome do pacote, java.lang(Comparable),java.util(Comparator), sendo assim n
	 * e preciso um import para usar o Camparable.
	 * 
	 * 2-Classe nao precisa implementar a interface Camparator para usar o
	 * camparator, o mesmo nao e para Comparable.
	 * 
	 * 3-Camparable possui o metodo compareTo, Comparator possui o metodo compare
	 * 
	 * 4-Metodo do Comparable possui um parametro, Comparator possui dois.
	 * 
	 * 5-Comparator e implementado como uma expressao lambda.
	 * 
	 * Metodos default que ajudam na criacao de uma Camparator
	 *
	 * 1.comparing() -> compara pelos resultados de uma funcao que retorna um
	 * object, ou autobex into a object.
	 * 
	 * 2-comparingDouble -> compara pelos resultados de uma funcao que retorna um
	 * Double.
	 * 
	 * 3-comparingInt() -> compara pelos resultados de uma funcao que retorna um
	 * int.
	 * 
	 * 4-comparingLong() -> compara pelos resultados de uma funcao que retorna um
	 * long.
	 * 
	 * 5-naturalOrder() -> classifica usando a ordem especificada pela implementacao
	 * do Comparable nos objetos.
	 * 
	 * 6-reverseOrder() -> classifica usando a ordem inversa especificada pela
	 * implementacao do Comparable no objeto.
	 * 
	 * Metodos defautls que ajudam no encadeamento do Comparator.
	 * 
	 * 7-reverse -> inverte a ordem do Comparator encadeado.
	 * 
	 * 8-theComparing -> Se o comparator anterior retornar 0, use este que retorna
	 * um objeto ou autoboxed em um objeto.
	 * 
	 * 9-thenComparingDouble() -> Se o comparator anteriro retornar 0, use este que
	 * retorna um double. Caso contrario retorna o valor do comparator anterior.
	 * 
	 * 10-thenComparingInt() -> Se o comparator anteriro retornar 0, use este que
	 * retorna um int. Caso contrario ira retornar o valor do comparator anterior.
	 * 
	 * 11-thenComparingLong() -> Se o comparator anterior retornar 0, use este que
	 * retorna um long. Caso contrario retorna o valor anterior
	 *
	 */
	public static void main(String[] args) {
		Comparator<ComparatorSort> comparator = Comparator.comparingInt(ComparatorSort::getId)
				.thenComparing(ComparatorSort::getNome);
//		Function<ComparatorSort, String> function = s1 -> s1.getNome();
//		Comparator<ComparatorSort> comparator2 = Comparator.comparingInt(ComparatorSort::getId)
//				.thenComparing(function);

		List<ComparatorSort> lista = new ArrayList<>(
				List.of(new ComparatorSort(2, "Nicholas"), new ComparatorSort(2, "Barbosaaa")));
		Collections.sort(lista, comparator);
		lista.forEach(System.out::println);
		ComparatorSort.testeFinc(ComparatorSort::getId);
	}

	private Integer id;
	private String nome;

	public ComparatorSort(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	private static String testeFinc(Function<ComparatorSort, Integer> fun) {
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nome=" + this.nome + " id=" + this.id + "";
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
