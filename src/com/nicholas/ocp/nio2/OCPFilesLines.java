package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class OCPFilesLines {

	/*
	 * Este metodo e similar ao readAllLines(), mas ele retorna uma stream que e
	 * lazy e nao ha o possibilidade de OutOfMemory.
	 * 
	 * readAllLines, le o arquivo na memoria, lines() processa cada elementos.
	 * 
	 * public static Stram<String> lines(Path path)throws IOException
	 */
	private static final Path path = Path.of("C:\\Users\\Nicholas Henrique\\Documents\\nio.2\\readDestino.txt");

	public static void main(String[] args) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			lines.forEach(System.out::println);
		}
	}
}
