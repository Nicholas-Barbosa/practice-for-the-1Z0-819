package com.nicholas.ocp.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OCPStream {

	/*
	 * Streams sao sequencias de dados.
	 * 
	 * Stream pipeline sao operacores que correm num stream.
	 * 
	 * Pipeline flow, resumidamente....
	 * 
	 * Pense num stream como linha de montagem de uma fabrica, cada processo e
	 * sequencial e importante.Pode haver varios estagios entre eles, e oq vai para
	 * frente nao volta para tras.
	 * 
	 * Alguns estagios dependem de outros estagios estarem prontos.
	 * 
	 * Ha tres partes de um stream pipeline
	 * 
	 * 1-Source -> Onde vem o stream
	 * 
	 * 2-Intermediate Operations -> A stream e convertida em outras streams. Pode
	 * haver muitas ou poucas intermediate operations.Como streams sao lazy
	 * evaluation, sao criadas quando sao necessarias, intermediate operations nao
	 * rodam ate que o terminal operation rode.
	 * 
	 * 3-Terminal Operations -> Realmente e produzido um resultado. Como as streams
	 * so podem ser usadas uma vez, a stream nao esta mais disponivel apos a
	 * conclusao do terminal operation.
	 * 
	 * Ha algumas diferencas entre Intermediate Operations e Terminal Operations, oq
	 * acontece nesses processos sao detalhes de implementacao.
	 * 
	 * 1-Terminal Operation requer uma parte util do pipeline(intermediate
	 * operations), intermediate nao.
	 * 
	 * 2-Intermediate operations podem exisitar varias veses num pipeline, terminal
	 * nao.
	 * 
	 * 3-O tipo de retorno do intermediate e uma stream, o terminal nao e.
	 * 
	 * 4-Apos terminal operation, a stream nao e mais valida,o mesmo nao ocorre para
	 * intermediate operations.
	 * 
	 * 5-Executado na chamada de metodo, nao para intermediate, espera o terminal
	 * operation correr para ai sim correr.Terminal operation sim.
	 * 
	 * Implementar streams, e como dar instrucoes ao chefe, neste caso o java.
	 * 
	 * Os trabalhadores nao comecam ate que o chefe(java) lhe diga para comecar, e o
	 * java espera ate que ele ve o terminal operation realmente comecar, para
	 * permititir que os trabalhos comecem(Intermediate operations nao corre ate que
	 * terminal operations corre). Ele ve o trabalho e para a linha de monatagem
	 * quando tudo esta completo.
	 * 
	 */

	public static void main(String[] args) {
		/*
		 * Finity stream
		 * 
		 * tres maneiras de criar uma stream finita
		 */

		Stream<String> empty = Stream.empty();

		Stream<String> single = Stream.of("1");

		Stream<String> notSingle = Stream.of("1", "2");

		/*
		 * Lembre-se o metodo of converte um varargs numa stream.
		 * 
		 * Ha um metodo para converter uma collection numa stream.
		 */

		var lista = new ArrayList<String>();
		Stream<String> streamCollection = lista.stream();
		streamCollection.forEach(System.out::println);

		List<String> lista2 = List.copyOf(lista);
		lista.add("Nicholas");
		System.out.println(lista2);
	}
}
