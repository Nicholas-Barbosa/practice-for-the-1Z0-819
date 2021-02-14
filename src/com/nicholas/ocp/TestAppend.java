package com.nicholas.ocp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TestAppend {

	public static void main(String[] args) throws Exception {

		var r = Files.newBufferedReader(
				Path.of("C:\\Users\\Nicholas Henrique\\Documents\\Certificados Sefaz\\2020-CDG\\chave.txt"));
		var w = Files.newBufferedWriter(
				Path.of("C:\\Users\\Nicholas Henrique\\Documents\\Certificados Sefaz\\2020-CDG\\chave2.txt"),
				StandardOpenOption.CREATE);
		String currentLine = null;
		while ((currentLine = r.readLine()) != null)
			w.write(currentLine);

		
	}
}
