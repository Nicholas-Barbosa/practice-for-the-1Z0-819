package com.nicholas.ocp.iostreams;

import java.io.Console;
import java.util.Arrays;

public class OCPConsole {

	/*
	 * Singleton class porque e fornecia com uma factory metodo e e criada apenas
	 * uma instancia dela pela jvm.
	 */
	public static void main(String[] args) {
		Console console = System.console();

		if (console != null) {
			String name = console.readLine("Ur name:");
			console.writer().format("Hi %s!", name).println();
			int age = Integer.parseInt(console.readLine("How old are you?"));
			console.writer().printf("%s %d years", name, age).println();
			char password[] = console.readPassword("%s what is your password?", name);
			char passwordConfirm[] = console.readPassword("Repeat your pass:");
			boolean passEqual = Arrays.equals(password, passwordConfirm);
			console.format("%s, your password is %s", name, passEqual);

			/*
			 * Diferencas entre readPassword
			 * 
			 * 1-O texto digitado pelo usuario nao e exibido e repetido para ele.
			 * 
			 * 2-O resultado e armazenado num array de char, inves de uma String
			 */
			if (!passEqual) {
				console.writer().println();
				console.printf("%s, your first password: %s and your pass confirmation: %s", name,
						Arrays.toString(password), Arrays.toString(passwordConfirm));
			}
		} else
			System.err.println("Console not avaliable!");
	}

}
