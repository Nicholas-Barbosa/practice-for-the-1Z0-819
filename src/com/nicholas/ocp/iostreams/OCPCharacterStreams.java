package com.nicholas.ocp.iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OCPCharacterStreams {

	/*
	 * int read() -> le um unico caracter e retorna -1 se nao houver mais
	 * caracteres.
	 * 
	 * int read(char[] b) -> le uma certa quantidade de carcateres de um input
	 * stream e os adiciona no array, retorna caracteres lidos no .
	 * 
	 * int read(char[] b, int offset,int length) ->le caracteres de uma input stream
	 * em um array de bytes, ate o limite determinado pelo parametro lenght.
	 * Adiciona os caracteres no array b, iniciando na posicao offset.
	 * 
	 * 
	 * void write(int byte) -> grava um caracter na stream
	 * 
	 * void write(char[]b) -> grava todos os caracteres do buffer na stream,
	 * 
	 * void write(char[]b,int offset,int lenght) -> grava todos os caracteres do
	 * buffer, comecando no offset. Limite de caracteres pelo lenght
	 * 
	 * Caracteres sao jogados para o array
	 */

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\reader.txt");
		File dest = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\writer.txt");

		char buffer[] = new char[1024];

		try (BufferedReader reader = new BufferedReader(new FileReader(file));
				BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
			int i;

			while ((i = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, 6);
				writer.flush();
				/*
				 * Flush solicita que todos os dados cacheados em memorias, sejam imediatamente
				 * gravados no file system
				 */
			}

		}
	}
}
