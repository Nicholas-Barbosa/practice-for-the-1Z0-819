package com.nicholas.ocp;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.print.DocFlavor.STRING;

public class Move {

	public static void main(String[] args) throws IOException {
		/*
		 * Exception se COPY_ATTRIBUTES for usado com um diretorio. Exception se o
		 * target e o source nao estiverem vazios.
		 */
		Path source = FileSystems.getDefault().getPath("./Zoo_en.properties/.");
//		System.out.println(
//				Files.move(Path.of("C:\\Users\\Nicholas Henrique\\Documents\\Certificados Sefaz\\2020-CDG\\move dir"),
//						Path.of("C:\\Users\\Nicholas Henrique\\Documents\\Certificados Sefaz\\moved"),
//						StandardCopyOption.REPLACE_EXISTING));

		System.out.println(
				Files.copy(Path.of("C:\\Users\\Nicholas Henrique\\Documents\\Certificados Sefaz\\2020-CDG\\chave2.txt"),
						Path.of("C:\\Users\\Nicholas Henrique\\Documents\\Certificados Sefaz\\chave2s.txt"),
						StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING));

	}
}
