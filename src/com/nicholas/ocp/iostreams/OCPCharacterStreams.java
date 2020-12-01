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
	 * int read(char[] buffer) -> le todos os carcateres do buffer, retorna
	 * caracteres lidos.
	 * 
	 * int read(char[] buffer, int offset,int length) ->le caractres do buffer
	 * inciando na posicao offset ate a length
	 * 
	 * void write(int byte) -> grava um caracter
	 * 
	 * boid write(char[]buffer) -> garava todos os caracteres do buffer
	 * 
	 * void write(char[]buffer,int offset,int lenght) -> grava todos os caracteres
	 * do buffer, comecando no offset ate o lenght
	 * 
	 */

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\reader.txt");
		File dest = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\writer.txt");

		char buffer[] = new char[1024];

		try (BufferedReader reader = new BufferedReader(new FileReader(file));
				BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
			int i;

			while ((i = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, i);
				writer.flush();
				/*
				 * Flush solicita que todos os dados cacheados em memorias, sejam imediatamente
				 * gravados no file system
				 */
			}

			/*
			 * Poderiamos usar readLine inves de read
			 */

		}
	}
}
