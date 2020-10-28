package com.nicholas.ocp.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiFunction;

import com.google.common.collect.Maps;

public class MapNotCollection {

	/*
	 * Usamos maps quando queremos identificar um valor pela sua respectiva Key.
	 * 
	 * HashMap como HashSet, armazena seus valores num hash table, sendo assim ele
	 * chama o metodo hashCode() dos objetos, para recupera-los de uma forma mais
	 * eficiente.
	 * 
	 * O principal beneficio do hashMap, adicionar e recuperar elementos, sao em
	 * tempo constante. Desvantagem, os elementos nao sao ordenados.
	 * 
	 * TreeMap, aramazena seus valores numa estruta de "arvore" ordenada(sorted tree
	 * strucute), seus elementos estao sempre ordenados.
	 * 
	 * Principal beneficio do TreeMap, e que os elementos estao sempre ordenados.
	 * Desvantagem, como no TreeMap, adicionar e verificar se o elemento ja esta no
	 * map, leva mais tempo do que no HashMap.
	 * 
	 * Map nao extends Collection, interface map possui metodos especiais.
	 * 
	 * 1-void clear() -> Limpa o map,remove todos os elementos no map.
	 * 
	 * 2-boolean containKey(Object key) -> retorna se ha a key no map.
	 * 
	 * 3-boolean containsValue(Object value) -> retorna se ha o value no map.
	 * 
	 * 4-Set<Map.entries<v,t>>entrySet() -> retorna os pares de key/value
	 * 
	 * 5-void forEach(BiConmsumer<t,r> o) -> Itera no map.
	 * 
	 * 6-get(Object key) -> Retorna o objeto mapeado pela key.
	 * 
	 * 7-getOrDefault(Object key,Object value) -> Retorna o objeto mapeado pela key,
	 * ou o valor default.
	 * 
	 * 8-boolean isEmpty()-> retorna se a map estiver vazia.
	 * 
	 * 9-Set keySet<t>() - > Retorna todas as keys do map.
	 * 
	 * 10->V merge(Object key,Object value,BuFunction<v,t,r>r) -> Define o valor se
	 * o key nao estiver no map.Se o key estiver no map, executa a BiFunction para
	 * determinar um novo valor. Remove se null.Retorna o que adiciona
	 * 
	 * 11-> V put(Object key,Object value) -> Adiciona se nao houver a key,
	 * substitui se houver a Key.Retorna o valor antigo(se houver no map) ou null.
	 * 
	 * 12->V putIfAbsent(Object key,Object value)-> Adiciona o valor se a key nao
	 * estiver no map e retorna null, caso contrario retorna o valor existente.
	 * 
	 * 13->get(Object key) -> Retorna o valor mapeado pela key.
	 * 
	 * 14->getOrDefault(Object key, Object value) -> Retorna o valor mapeado pela
	 * key, ou o valor default.
	 * 
	 * 15-> V remove(Object key) -> Remove e retorna o valor mapeado pela key, se
	 * nao estiver na key, retorna null.
	 * 
	 * 16-> V replace(Object key,Object value)=> Substitui o valor mapeado pela key,
	 * se estiver no map, retorna o valor original ou null.
	 * 
	 * 17->void replaceAll(BiFunctio<t,v,r>v) -> Substitui cada elemento pelo
	 * resultado da BiFunction.
	 * 
	 * 18-> int size() -> retorna o numero de keys/values no map.
	 * 
	 * 19 -> Collection<v>values() retorna uma collection com todos os valores do
	 * map
	 * 
	 * Obs: Com hasMap, o java usa o hashCode() para determinar a ordem.
	 * 
	 * no replaceAll-> BiFunction<parametroEaKey,parametroEOValue>
	 * 
	 * no merge-> BiFunction<parametroEoValorQueJaEstaNoMap,novoValor>
	 * 
	 * Caso o map tenha um valor null, a BiFunction nao e chamada para nao causar
	 * NullPointer, sendo assim ele so adiciona o valor no map.
	 * 
	 * Se a BiFunction retornar null, o pair de key/value sera excluida.
	 */

	public static void main(String[] args) {
		BiFunction<String, String, String> biFunction = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;
		Map<String, String> maps = new HashMap<>();
//		System.out.println(maps.put("N", "Nicholas"));// null
//		System.out.println(maps.put("N", "Barbosa"));
//		System.out.println(maps.remove("N"));
//		System.out.println(maps.remove("N"));
//		maps.put("N", "Barbosa");
//		System.out.println(maps.replace("N", "Nicholas"));// Barbosa
//		System.out.println(maps.replace("N2", "Nicholas"));// Null
//		maps.put("C", "Cestari");
//		maps.put("A", "Abelha");
//		maps.forEach(MapNotCollection::itera);
//		System.out.println(maps.merge("N", "barbosa", biFunction));
//		maps.replaceAll((s1, s2) -> s2 + " kkkkk");
//		maps.forEach(MapNotCollection::itera);
//		/*
//		 * Ou
//		 */
//		maps.entrySet().forEach(System.out::println);
		maps.put("#12", "Nicholas");
		maps.merge("#13", "Barbosa", biFunction);
		maps.merge("#13", "Cestari", biFunction);
		maps.forEach(MapNotCollection::itera);

	}

	private static void itera(String s1, String s2) {
		System.out.println("Key " + s1 + " value " + s2);
	}
}
