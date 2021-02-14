package com.nicholas.ocp;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CopyOption {

	/*
	 * APPEND-> se estiver aberto para leitura, adiciona os valores no final.
	 * 
	 * CREATE -> Cria arquivo se nao exisitr.
	 * 
	 * CREATE_NEW -> Cria o arquivo se nao exisitir, se nao falha(exception)
	 * 
	 * READ-> Abre para leitura
	 * 
	 * TRUNCATE_EXISITING ->Se estiber aberto para gravacao, apaga e cria um novo
	 * 
	 */

	public static void main(String[] args) {
		Path read = Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2\\readDestino.txt");
		Path write = Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2\\readDestinoV2.txt");
		try (var reader = Files.newBufferedReader(read);
				var writer = Files.newBufferedWriter(write, StandardOpenOption.TRUNCATE_EXISTING)) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String myName = "Nicholas";
		String myNameV2 = "Nich" + "olas";
		System.out.println(myName == myNameV2);

	}
}
