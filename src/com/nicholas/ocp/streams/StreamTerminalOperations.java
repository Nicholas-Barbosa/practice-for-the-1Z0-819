package com.nicholas.ocp.streams;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StreamTerminalOperations {

	/*
	 * Podemos pular os estagio de Intermediate Operations, seguindo direto para
	 * TerminalOperations.
	 * 
	 * Reductions e o nome que se da a combinacao de conteudos de uma stream, a um
	 * unico objeto ou primitivo.
	 * 
	 * Metodos para esta feature
	 * 
	 * 1-count() -> Este metodo determina os elementos de uma stream. Para uma
	 * infinite stream, nunca termine.
	 * 
	 * Ele e Redction, ja que pega todo o conteudo e combina num
	 * primitivo(long),sendo assim retornando o numero de elementos numa stream.
	 * 
	 * 2-min() e max() -> Estes metodos permitem vc passar um Comparator como
	 * parametro para determinar qual elemento e maior ou menor,dependendo de sua
	 * classifacao.Novamente, Reduction.
	 * 
	 * Optional<T>min(Comparator<?superT); Optional<T>max(Comparator<?superT);
	 * 
	 * 3-findFirst() e findAny() -> Retorna um elemento da stream, a menos que a
	 * Stream esteja vazia. Se estiver vazia retorna uma empty Optional.
	 * 
	 * Este pode terminar uma finite stream. Pelo nome, findAny() retorna qualquer
	 * elemento da stream,mas e comum retornar o primeiro,mas nem sempre acontece.
	 * 
	 * Estes metodos sao TerminalOperations, mas nao Reductions, ja que eles nao
	 * processam todos oe elementos da stream.
	 * 
	 * 4-allMatches(),noneMatches(),anyMatches()
	 * 
	 * Estes metodos pesquisam na stream e retornam true or false dependendo do
	 * predicate.Pode ou nao terminar uma infinite Streams(como
	 * iterate(seed,predicate,unary).Eles nao sao reductions pq eles nao olham todos
	 * os elementos.
	 * 
	 * 5-reduce()
	 * 
	 * Transforma uma stream num unico objeto, como ele verifica todos os elementos
	 * da stream, ele e reduction.
	 * 
	 * T reduce(T indentity,BinaryOperator<T> accumulater)
	 * 
	 * Optional<T>reduce(UnaryOperator<T> accumulator)
	 * 
	 * <U> U reduce(U identity,BiFunction<U,? super
	 * T>accumulator,BinaryOperator<U>combiner)
	 * 
	 * 1-Se a stream estiver vazia, e retornada um optional empty.
	 * 
	 * 2-Se houver um elemento,este elemento e retornado.
	 * 
	 * 3-Caso haja varios elementos, o accumulator e chamado.
	 * 
	 * Accumulator -> Responsavel por pegar o current result e combinar com o
	 * current value na stream.
	 * 
	 * Identity -> como seed em iterate(), valor inicial da reduction
	 * 
	 * 
	 * 6-collect() *Entederemos melhor, quando vermos seus metodos da classe
	 * Collectors, que abstrai o trabalho de ficar reimplementando o mesmo
	 * collector.
	 * 
	 * <R>collect(Supplier<R> supplier, BiConsumer<R,? super
	 * R>accumulator,BiConsumer<R,? super R>combiner>
	 * 
	 * Esta assinatura nos permite criar nosso proprio collect.
	 * 
	 * Caso especial de Reduction, ele e chamado de mutable Reduction. Mais
	 * eficiente que os reductions regulares, pois usa o mesmo objeto(mutavel)
	 * enquanto esta accumulating
	 * 
	 * Combiner -> Responsavel por pegar duas collections em mesclar.(Entendimento
	 * melhor quando estivermos trabalhando com lambdas)
	 */

	public static void main(String[] args) {
		Stream<Integer> finiteCount = Stream.iterate(1, x -> x <= 4, y -> y + 1);
		// Stream<Integer> countWithInfinite = Stream.generate(() -> 2);
		System.out.println(finiteCount.count());
		// System.out.println(countWithInfinite.count());// Nao termina nunca

		Stream<Integer> minStream = Stream.of(1, 2, 3, 4);
		System.out.println(minStream.min((x, y) -> x - y));// Optional
		/*
		 * System.out.println(minStream.max((x, y) -> x - y)); exception, stream apos
		 * TerminalOperators nao e mais valida.
		 */
		Stream<Integer> maxStream = Stream.of(1, 2, 3, 4);
		System.out.println(maxStream.max((x, y) -> x - y));// Optional

		Stream<Integer> findFirst = Stream.generate(() -> 1234);
		System.out.println(findFirst.findFirst());// Optional

		Stream<Integer> allMatches = Stream.of(10, 100, 1000);// Retorna true se todos os elementos forem avaliados como
																// true no predicate.
		System.out.println(allMatches.allMatch(x -> x.toString().charAt(0) == '1' ? true : false));// Optional

		Stream<Integer> anyMatches = Stream.of(10, 100,
				1000);/*
						 * Retorna true se qualquer elemento for avaliado como true no Predicate.
						 */
		System.out.println(anyMatches.anyMatch(x -> x == 10));

		Stream<Integer> noneMatches = Stream.of(10, 100,
				1000);/*
						 * Retorna true se nenhum elemento for avaliado como true no Predicate.como^
						 */
		System.out.println(noneMatches.noneMatch(x -> x == 10));

		/*
		 * reduction()
		 * 
		 */
		System.out.println();

		Stream<String> empty = Stream.empty();
		System.out.println(empty.reduce((s1, s2) -> s1 + s2));

		Stream<String> singleElement = Stream.of("ni");
		System.out.println(singleElement.reduce((s1, s2) -> s1 + s2));

		Stream<String> threeElements = Stream.of("henrique", "barbosa");
		Optional<String> op = threeElements.reduce((s1, s2) -> s1 + s2);
		System.out.println(op);
		Stream<String> streamName = Stream.of("henrique", "barbosa");
		String myName = streamName.reduce("nicholas", (x1, x2) -> x1 + " " + x2);
		System.out.println(myName);
		System.out.println();

		Stream<String> streamNameLeng = Stream.of("henrique", "barbosa");
		int myNameLeng = streamNameLeng.reduce(20, (x1, x2) -> x1 + x2.length(), (a, b) -> b + a);
		System.out.println("leng " + myNameLeng);

		/*
		 * Collectors
		 * 
		 * Neste primeiro exemplo nosso mutable collector nao funcionou, pq String e
		 * imutavel
		 */
		Stream<String> streamWithCollector = Stream.of("nicholas", "barbosa");
		String r = streamWithCollector.collect(String::new, String::concat, String::concat);
		System.out.println("r> " + r);
		System.out.println();
		Stream<StringBuilder> streamWithCollectorImutavel = Stream.of(new StringBuilder("nicholas"),
				new StringBuilder("barbosa"));
		StringBuilder imutavel = streamWithCollectorImutavel.collect(StringBuilder::new, StringBuilder::append,
				StringBuilder::append);
		System.out.println("r> " + imutavel);
		System.out.println();

		Stream<String> stream = Stream.of("n", "y", "A");

		TreeSet<String> tree = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(tree);
		Stream<String> streamSet = Stream.of("n", "y", "A");

		List<String> set = streamSet.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
		System.out.println(set);
		System.out.println();
		Stream<String> streamTest = Stream.of("C", "B");

		Set<String> reduce = new TreeSet<>(Set.of(streamTest.reduce("A", (x1, x2) -> x1 + " " + x2)));
		System.out.println(reduce);

		Stream<String> streaSize = Stream.iterate("A", x -> x.length() <= 10, x -> x + x);
		String allInOne = streaSize.reduce("S", (x, y) -> x + " " + y);
		System.out.println(allInOne);
		System.out.println();

		Stream<StringBuilder> streaSizeCollect = Stream.iterate(new StringBuilder("A"), x -> x.length() <= 10,
				x -> x.append(x));
		StringBuilder allInOneCollect = streaSizeCollect.collect(() -> new StringBuilder(), (x, y) -> x.append(y + " "),
				(x, y) -> y.append(x + "-"));
		System.out.println(allInOneCollect);

		System.out.println();

		Stream<Integer> mulp = Stream.of(3, 5, 6);
		int result = mulp.reduce(0, (x, y) -> x * y);
		System.out.println(result);
	}
}
