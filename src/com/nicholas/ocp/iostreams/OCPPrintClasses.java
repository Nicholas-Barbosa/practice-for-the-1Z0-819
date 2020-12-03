package com.nicholas.ocp.iostreams;

import java.io.IOException;
import java.io.PrintWriter;

public class OCPPrintClasses {

	/*
	 * PrintWriter e PrintStream sao uteis para gravar dados numa stream. Essas, sao
	 * as unicas classes de I/O que nao possuem input stream correspondente.
	 * 
	 * PrintWriter trabalhar em cima de um writer(character streams),enquanto
	 * PrintStream trabalha em cima de uma OutputStream (byte stream).
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("---- Construtores de PrintStream");
		System.out.println("public PrintStream(OutputStream out)");
		System.out.println("public PrintStream(File file) throws FileNotFoundException");
		System.out.println("public PrintStream(String path) throws FileNotFoundException");
		System.out.println();

		System.out.println("---- Construtores de PrintWriter");
		System.out.println("public PrintStream(Writer out)");
		System.out.println("public PrintStream(File file) throws FileNotFoundException");
		System.out.println("public PrintStream(String path) throws FileNotFoundException");
		System.out.println(
				"public PrintStream(OutputStream out), PrintWriter pode receber um OutputStream para misturar entre caracteres e bytes");
		/*
		 * Observer, essas classes print , possuem construtores que pegam como argumento
		 * um file ou um path, para dar o wrap no low-level stream automaticamente.
		 * 
		 */
		try (PrintWriter out = new PrintWriter(
				"C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\print classes\\prnt.txt")) {
			out.println(10);
			out.write("Meu nome é Enéas");
			/*
			 * Metodo print(), ele executa o String.valueOf() no argumento, depois chama o
			 * write da stream subjacente para gravar na stream.
			 * 
			 * println() faz a mesma coisa, mas ela da uma quebra de linha apos a String.
			 * 
			 * format() -> Formata a String, %s aplica-se a qualquer tipo, %d aplica-se a
			 * tipos inteiros, %f -> pontos flutuantes, %n -> quebra de linha.
			 * 
			 */
			out.format("My name is %s", "Nicholas");
			/*
			 * Duas instancias de PrintStream para fornecer informacoes, System.out e
			 * System.err
			 */
			System.out.format("My name is %s and Im %d years old %n%s", "Nicholas", 16, "after \\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("Writer completado");
		}
	}
}
