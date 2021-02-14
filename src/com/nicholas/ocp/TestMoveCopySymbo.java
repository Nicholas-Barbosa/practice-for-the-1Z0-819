package com.nicholas.ocp;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMoveCopySymbo {

	private static final Path path = FileSystems.getDefault()
			.getPath("C:\\Users\\Nicholas Henrique\\Documents\\symbolic test\\sym");

	public static void main(String[] args) throws IOException {

		Path target = Path.of("C:\\Users\\Nicholas Henrique\\Documents\\symbolic test\\sym32Copied");
		System.out.println(Files.copy(new FileInputStream(path.toFile()), target));
////
//		System.out
//				.println(Files.isSameFile(Path.of("C:\\Users\\Nicholas Henrique\\Documents\\symbolic test\\sym3copied"),
//						Path.of("C:\\Users\\Nicholas Henrique\\Documents\\Certificados Sefaz\\2020-CDG\\chave2.txt")));

		Path p1 = Paths.get("C:/photos/goa");
		Path p2 = Paths.get("D:/index.html");
		Path p3 = p1.relativize(p2);
		System.out.println(p3);
		/*
		 * Conclusao, usando move(),se o target for um symbolic link ele ira copiar o
		 * symbolic link e nao o target do symbolic link.
		 * 
		 * Com copy(Path p,Path p, CopyOption...op) por default ele ira copiar o target
		 * do symbolic link, passando LinkOption.NOFOLLOW_LINKS copia o symbolic link.
		 * 
		 * copy(InputStream in, target, options) -> copia o symbolic link.NOFOLLOW_LINKS
		 * nao e suportador
		 * 
		 * copy(Path source,OutputStream o) -> copia o symbolic link.
		 */
	}
}
