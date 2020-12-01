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
	 * read(byte[]b) -> Le os valores dentro do buffer(array), retorna o numero
	 * maximo de bytes lidos.
	 * 
	 * read(byte[b],int offset,int lenght) -> Le os valores dentro do buffer ate o
	 * length , comecando com a posicao offset.Retorna o nmumero de bytes lidos
	 * 
	 * write(int i) -> grava um unico byte
	 * 
	 * write(byte[]b) -> grava um array de valores dentro da stream
	 * 
	 * write(bythe[]b,int offset,int lenght) ->> grava um array comecando na posicao
	 * offset, limitando com length numa stream
	 * 
	 */

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\input.txt.txt");
		File dest = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\output.txt");

		byte buffer[] = new byte[1024];

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {

			while (in.read(buffer) != -1) {

				out.write(buffer);

			}

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
