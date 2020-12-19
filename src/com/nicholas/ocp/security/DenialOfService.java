package com.nicholas.ocp.security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DenialOfService {

	/*
	 * DenialofService e um ataque,onde o hacker faz uma ou mais requisicoes, com a
	 * intencao de interferir nas requisicoes legitimas.
	 * 
	 * Normalmente para se derrubar seu alvo, e necessario varias ataques ou so uma,
	 * sendo ela muito grande.
	 * 
	 * Deniel of service normalmente possui uma unica fonte, ou nao. Distribuited
	 * denial of service possui varias sources distribuidas fazendo ataques ao mesmo
	 * tempo. Em outras palavras, e um denial of service distribuida.
	 */

	private static Long countLines(Path path) throws IOException {
		/*
		 * Este inofensivo metodo,podeira derrubar nossa aplicacao se por exemplo, nao
		 * fechassemos seu resource.
		 */
		try (Stream<String> linesStream = Files.lines(path)) {
			return linesStream.count();
		}
	}

	private static Integer overflow() {
		/*
		 * Integer possui um valor maximo, se o mesmo for ultrapasso ocorre overflow. A
		 * variavel viira negativo.
		 */
		return Integer.MAX_VALUE + 1;
	}

	public static void main(String[] args) throws IOException {
		var path = Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2\\readOrigem.txt");
		System.out.println("lines: " + DenialOfService.countLines(path));
		System.out.println("Overflow " + overflow());

		/*
		 * Inclusion e um ataque, onde multiplos files ou componentes estao num unico
		 * file.Qualquer file que vc nao crie,e suspeito!Alguns podem aparecer menores
		 * do que realmente sao(como zip bomb).
		 */

	}
}
