package com.nicholas.ocp.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OCPByteStreamWriterReader {

	/*
	 * read() -> Le um byte por vez.
	 * 
	 * read(byte[]b) -> Le uma certa quantidade de bytes de uma input stream, os
	 * adiciona no array b, retorna o numero de bytes lidos no array.
	 * 
	 * read(byte[]b,int offset,int lenght) -> Le os bytes de uma input stream em um
	 * array de bytes, ate o limite length. Armazena os bytes no array b, tomando
	 * como posiciao inicial o offset bytes lidos no array b comecando na posicao
	 * offeset
	 * 
	 * write(int i) -> grava um unico byte
	 * 
	 * write(byte[]b) -> grava o array de valores dentro da stream
	 * 
	 * write(bythe[]b,int offset,int lenght) ->> grava o array comecando na posicao
	 * offset, usando o parametro lentght como limitador de bytes.
	 * 
	 * 
	 */

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\input.txt.txt");
		File dest = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\output.txt");

		byte buffer[] = new byte[1024];

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {

			int i = 0;
			int bytes;
			while ((bytes = in.read()) != -1) {
				buffer[i] = (byte) bytes;
				i++;
			}
			out.write(buffer);
			out.flush();

		}
		/*
		 * Buffered e prefirivel usar do que FileInputStream mesmo com read(byte[]),
		 * pois as classes Buffered possuem series de melhorias de desempenhos para
		 * gerenciamento de dados na memoria
		 * 
		 * Exemplo, BufferedInputStream, capaz de recuperar e armazenas mais dados em
		 * memoria do que um unico read(byte[]b). Para sucessivas chamadas de read() com
		 * um array, usando uma classe Buffered havera melhorias de performance em
		 * multiplas situacoes, cujo os resultados poderao ser retornados diretamente da
		 * memoria e nao do file system.
		 */

	}
}
