package com.nicholas.ocp.collection;

import java.util.LinkedList;
import java.util.List;

public class ListCollection {

	/*
	 * List e uma collection ordenada que aceita duplicatas.
	 * 
	 * Implemenatcoes da List.
	 * 
	 * ArrayList -> E um array de tamanho redimensionavel, seu Principal beneficio,
	 * e que vc pode pesquisar elementos em tempo constante. Operacoes de add(),
	 * remove() sao mais lentas do que acessar um elemento.
	 * 
	 * Isso faz o arrayList uma boa escolha, quando vc esta lendo com mais
	 * frequencia(ou igual) do que quando vc esta escrevendo no array.
	 * 
	 * LinkedList e especial, pois implements List e Queue.
	 * 
	 * Principal beneficio de um LinkedList, e que vc pode acessar,
	 * adicionar,remevocer elementos do inicio e do final da list em tempo
	 * constante.
	 * 
	 * A desvantagem, ao lidar com indexes arbitrarios, o tempo e linear, ou seja
	 * dar um get(int index) demora mais do que num ArrayList.
	 * 
	 * Isso faz uma boa escolha, quando vc esta usando LinkedList como uma queue,
	 * escrevendo com mais frequencia do que lendo.
	 * 
	 * Factory methods de uma List.
	 * 
	 * Arrays.asList() -> Retorna uma List mutavel de tamanho fixa e linkada com o
	 * array.
	 * 
	 * List.of() -> Retorna uma List imutavel.
	 * 
	 * List.copyOf() -> Retorna uma List imutavel com os valores collection
	 * original.
	 * 
	 * Metodos do List
	 * 
	 * boolean add(E element) adiciona o elemento no final da collection e retorna
	 * true se for sucesso.
	 * 
	 * void add(int index,element) adicona o elemento em determinado index, e
	 * empurra o restante para o final da collection.
	 * 
	 * E set(int index, E element) -> substitui o elemento em determinado index,
	 * retorna o original.
	 * 
	 * E get(int index) -> Pega o elemento de determinado index, retorna o mesmo.
	 * 
	 * void replaceAll(UnaryOperator<t>t) -> Substitui todos elementos pelo resutado
	 * da operacao.
	 * 
	 * E remove(E e) -> remove o elemento , retorna o mesmo e move o resto pro
	 * inicio.
	 */
	public static void main(String[] args) {
		List<String> listaQueue = new LinkedList<>();
		// Usei listaQueue pois add,remove sao em tempos constantes.Mais performatico
		listaQueue.add("Nicholas");
		listaQueue.add("Cabral");
		listaQueue.add("Barbosa");
		listaQueue.add("Cestari");
		System.out.println(listaQueue.set(3, "Pastri"));
		System.out.println(listaQueue.remove(1));
		// Method reference
		listaQueue.replaceAll(ListCollection::concatena);
		// Method reference
		listaQueue.replaceAll(s -> s + " 1");
		List<String> lista = List.copyOf(listaQueue);
		System.out.println(lista);
		listaQueue.remove(2);
		lista.remove(2);// Throws Unsuported Exception
	}

	private static String concatena(String s) {
	
		return s += " 1Z0-819";
	}
}
