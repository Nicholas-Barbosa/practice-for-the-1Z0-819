package com.nicholas.ocp.streams;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OCPCollectors {
	/*
	 * 
	 */

	public static void main(String[] args) {
		/*
		 * Mesmo padrao,passamos um collector ao collect e ele executa a regra de
		 * negocio
		 */
		var myStream = Stream.of(10, 20, 30);
		IntSummaryStatistics summary = myStream.collect(Collectors.summarizingInt(x -> x));
		System.out.println("count " + summary.getCount());
		/*
		 * Vc pode especificar a classe do map, passando um supplier no ultimo parametro
		 * do toMap(Function,Function,BinaryOperator,Supplier).
		 * 
		 * Lembre-se as duas functions sao para dizer ao collector como criar a key,a
		 * segunda para dizer como criar o value.
		 * 
		 * Se houver mais de uma key duplicata no mesmo map,ira ocorrer uma
		 * exception!Por isso, passe um BinaryOperator(Optional) para juntar essas duas
		 * values na mesma key. Esse binaryOperator so sera executado se houver keys
		 * iguais no map.
		 * 
		 * Para especificar a classe do Map,passe um constructor reference no ultimo
		 * parametro(supplier),mas lembre de passar o BinaryOperator antes!
		 */
		var myStream2 = Stream.of(10, 10, 20, 30);
		Map<Integer, Integer> mp = myStream2
				.collect(Collectors.toMap(x -> x, x -> x, (x, y) -> x + y + 900, TreeMap::new));
		System.out.println(mp + " class " + mp.getClass());
	}
}
