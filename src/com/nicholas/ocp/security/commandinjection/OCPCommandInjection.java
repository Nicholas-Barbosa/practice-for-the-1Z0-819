package com.nicholas.ocp.security.commandinjection;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class OCPCommandInjection {

	/*
	 * Injection e um ataque onde um input perigoso corre em um programa como parte
	 * de um comando
	 * 
	 * Command Injection, tambem e um tipo de injection que usa comandos do sistema
	 * operacional para fazer coisas inesperadas.
	 * 
	 * O seguinte codigo realiza um travesing directory, suportando first depth. Ha
	 * um arquivo chamado secret.txt, onde o usuario nao pode acessar. Por isso
	 * iremos criar uma white list.
	 * 
	 */

	public static void main(String[] args) {
		Console console = System.console();
		if (console != null) {
			Path path = Path.of("C:\\Users\\Nicholas Henrique\\Documents\\nio.2");
			console.writer().println("Diretorio a percorrer: ");
			var diretorioCaminhar = console.readLine();
			if (diretorioCaminhar.equals("commandInjection")) {
				try (Stream<Path> files = Files.find((path = path.resolve(diretorioCaminhar)), Integer.MAX_VALUE,
						(p, bView) -> bView.isRegularFile())) {
					console.format("Lendo diretorio %s...", path);
					files.forEach(System.out::println);
					console.writer().println();
					console.writer().println("Digite sua senha");
					char[] senha = console.readPassword();
					Arrays.fill(senha, 'x');
					console.format("sua senha foi substituida internamente por: %s e marcada como nulla",
							senha.toString());
					senha = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				console.writer().println("Nao e possivel percorrer este diretorio!");
				main(new String[0]);
			}

			/*
			 * readPassword e mais seguro do que readLine, pois nao e armazenado como uma
			 * String, o java nao ira colocar num pool,onde poderia exisitir na memoria
			 * muito tempo depois que o seu codigo foi executado.
			 * 
			 * voce pode setar os elementos do array como nullos, do que esperar pelo
			 * garbage collector fazer isso.
			 * 
			 * Lembrando que grabage collector e o processo de liberar memoria no heap,
			 * deletando objetos nao acessiveis ao programa. Ninguem controla o garbage
			 * collector, so a JVM, mas voce pode fazer requisicoes que poderao ser aceitas
			 * ou nao, pela jvm, usando System.gc().
			 * 
			 * Este e o motivo de armazenar dados sensiveis na memoria, por pouco tempo.
			 */

		}
	}
}
