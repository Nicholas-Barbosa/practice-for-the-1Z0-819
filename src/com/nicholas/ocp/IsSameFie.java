package com.nicholas.ocp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IsSameFie {

	public static void main(String[] args) throws IOException {
		/*
		 * Se ambos objetos forem iguais em termos de equals(), sera retornado true e
		 * nao havera a verificacao se ambos existem.
		 */
		Path path1 = Paths.get("equals/true");
		Path path2 = Paths.get("equals/true");
		System.out.println(Files.isSameFile(path1, path2));
		System.out.println(Path.of("a/../abc").normalize());
		System.out.println();
		System.out.println(Files.isSameFile(path1.resolve("C:\\Users\\Nicholas Henrique\\Documents\\nio.2\\a\\.."),
				path2.resolve("C:\\Users\\Nicholas Henrique\\Documents\\nio.2")));
	}
}













































