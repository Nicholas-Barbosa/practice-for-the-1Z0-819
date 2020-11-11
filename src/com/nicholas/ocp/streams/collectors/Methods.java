package com.nicholas.ocp.streams.collectors;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Methods {

	/*
	 * Metdos estaticos de collection,
	 * 
	 * averagingInt(toIntFunction<R>) averaginDouble(toDoubleFunction<R)
	 * averaginLong(toLongFunction<R>) -> media dos elementos, double
	 * 
	 * counting() -> Numero de elementos, long
	 * 
	 * groupingBy(Function f) -> Diz ao collect agrupar os elementos num map.
	 * Podemos passar uma function para determinar a key, Collecotor para determinar
	 * o tipo da collection por exemplo e uma supplier para determinar o tipo do
	 * map.
	 * 
	 * joinning(CharSequence)->Retorna uma unica String usando o parametro como
	 * delimnitador.
	 * 
	 * maxBy(Comparator c) -> optional com o maior elemento / minBy(Comparator c)
	 * optional com o menor elemento.
	 * 
	 * summarizingInt(toIntFunction),summarizingDouble(toDoubleFunction),
	 * summarizingLong(toLongFunction) -> retorna IntSummaryStatistics,
	 * DoubleSummaryStatistics e LongSummaryStatistics respectivamente.
	 * 
	 * summingInt(ToIntFunction) -> int, summingDouble(ToDoubleFunction) -> double,
	 * summingLong(ToLongFiunction> -> long partioningBy(predicate,Collector)->
	 * Agrupa os elementos na stream em um map de duas keys, true e false.
	 * 
	 * mapping(Function f,Collector) -> Adiciona mais um nivel de collector, por
	 * exemplo, estamos usando um groupingBy e queremos os maiores elementos de cada
	 * key,usamos mapping!
	 * 
	 * toList,toSet() -> retornam um list ou set.
	 * 
	 * toCollection(supplier) -> retorna uma collection especificada no supplier
	 * 
	 * toMap(Function k,Functio V,BinaryOperator, supplier) -> Cria um map de acordo
	 * com a stream, as duas functions para mapear key/value, BinaryOperator
	 * opcional, para fundir elementos com a mesma key(para nao ocorrer exception) e
	 * supplier para defirnirmos o tipo do map.
	 */
	public static void main(String[] args) {
		var stream = IntStream.of(10, 20, 30);
		System.out.println(stream.mapToDouble(x -> x).min().getAsDouble());
		Optional<Double> op = Stream.of(5d, 10d, 20d).collect(Collectors.maxBy((x, y) -> x.compareTo(y)));
		Map<String, Integer> map = Stream.of("ni", "b").collect(Collectors.toMap(x -> "y" + x, x -> x.length()));
		System.out.println(map);
		System.out.println();
		Map<String, Optional<String>> mapGroup = Stream.of("ni", "ba").collect(Collectors.groupingBy(x -> "y" + x,
				Collectors.mapping(x -> x, Collectors.minBy((a, b) -> a.compareTo(b)))));
		System.out.println(mapGroup);
		var st = Stream.of(10l, 20l);

	}
}
