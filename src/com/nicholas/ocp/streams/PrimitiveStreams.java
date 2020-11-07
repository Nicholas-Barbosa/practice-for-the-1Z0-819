package com.nicholas.ocp.streams;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
	/*
	 * Streams primitivas, IntStream, DoubleStream e LongStream.
	 * 
	 * Metodos comuns para Primitive Streams.
	 * 
	 * 1-OptionalDouble average() -> retorna uma OptionalDouble da media dos
	 * elementos na stream.
	 * 
	 * 2-<T>boxed() -> Onde T e a wrapper relacionada com teu primitivo.
	 * 
	 * 3-OptionalDouble, OptionalInt,OptionalLong min() e max() -> Aplica-se a todos
	 * os Primitive Streams respectivamente,retorna minimo elemento e o maximo
	 * elemento da Stream.
	 * 
	 * 4-IntStream, LongStream range(int/long a, int/long b) -> Retorna um numero
	 * entre a(inlcusive) e b(exclusive), mas antes de b.
	 * 
	 * 5-IntStream,LongStream rangeClosed(int/long a,int/long b) -> Retorna um
	 * numero entre a(inclusive) e b(inclusive).
	 * 
	 * 6-int sum(), long sum(), double sum(), aplica-se a todos os Primitive
	 * Streams, retornando a soma dos valores.
	 * 
	 * 7-IntSummaryStatistics summaryStatistic() -> Retorna um IntSummaryStatistics
	 * contendo metodos para pegar a media, min,max, sum,etc.
	 * 
	 * 8-DoubleSummaryStatistics summaryStatistic() -> Retorna um
	 * IntSummaryStatistics contendo metodos para pegar a media, min,max, sum,etc.
	 * 
	 * 8-LongSummaryStatistics summaryStatistic() -> Retorna um IntSummaryStatistics
	 * contendo metodos para pegar a media, min,max, sum,etc.
	 * 
	 * 
	 * Podemos criar uma stream, a partir de outra Stream usando o metodo map();
	 * 
	 * Soruce sendo uma Stream,para Stream -> map(Finction<>), para DoubleStream ->
	 * mapToDoube(toDoubleFunction), para IntStream -> mapToInt(toIntFunction), para
	 * LongStream -> mapToLong(toLongFunction);
	 * 
	 * Source sendo uma DoubleStream, para uma Stream ->
	 * mapToObj(DoubleFunction),para DoubleStream -> map(DoubleUnaryOperator<>) para
	 * IntStream -> mapToInt(DoubleToIntFunction<>), para LongStream ->
	 * mapToLong(DoubleToLongFunction)
	 * 
	 * Source sendo uama IntStream, para stream -> mapToObj(IntFunction), para
	 * DoubleStream(IntToDoubleFunction), para uma
	 * IntStream->map(IntUnaryOperator<>), para uma LongStream ->
	 * mapToLong(IntToLongFunction)
	 * 
	 * Source sendo uma LongStream, para stream-> mapToObj(LongFunction<>), para
	 * DoubleStream -> mapToDouble(LongToDoubleFunction<>),para IntStream ->
	 * mapToInt(LongToIntFunction<>), para LongFunction(LongUnaryOperator)
	 * 
	 * As functions sao intuitivas, o tipo do parametro sera o tipo da source
	 * stream, e do retorno da target stream.
	 * 
	 * Por exemplo, uma Stream<String> para uma LongStream, usariamos
	 * mapToLong(toLongFunction<String,long>).
	 */

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3);
		IntStream intStream = stream.mapToInt(x -> x);
		System.out.println(intStream.min().getAsInt());
		System.out.println();
		Stream<Integer> streamToDouble = Stream.of(1, 2, 3);
		DoubleStream doubleStream = streamToDouble.mapToDouble(x -> x);
		System.out.println(doubleStream.max().getAsDouble());
		System.out.println();
		Stream<Integer> streamToLong = Stream.of(1, 2, 3);
		LongStream longStream = streamToLong.mapToLong(x -> x);
		System.out.println(longStream.max().orElseGet(() -> Long.parseLong(Double.valueOf(Math.random()).toString())));
		System.out.println();
		DoubleStream grades = DoubleStream.of(7, 6.5, 9);
		DoubleSummaryStatistics statistics = grades.summaryStatistics();
		System.out.println("Average " + statistics.getAverage());
		System.out.println("Max grade " + statistics.getMax());
		System.out.println("Min grade " + statistics.getMin());
		System.out.println("Sum " + statistics.getSum());
		System.out.println();
		DoubleStream gradesWithNoSummaryStatistics = DoubleStream.of(7, 6.5, 9);
		System.out.println(gradesWithNoSummaryStatistics.average().getAsDouble());// Exception
		System.out.println(gradesWithNoSummaryStatistics.min().getAsDouble());// Exception
		System.out.println(gradesWithNoSummaryStatistics.max().getAsDouble());// Exception
		/*
		 * Vc viu oq SummaryStatistics pode fazer?? Estes metodos padroes de stream
		 * primitivo, sao terminal operators,apos a chamada de um desses metodos,a
		 * stream vence, perde validade.
		 */
	}
}
