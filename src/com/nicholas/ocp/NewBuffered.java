package com.nicholas.ocp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NewBuffered {

	public static void main(String[] args) {
		try (var source = Files.newBufferedReader(Path.of("C:\\Users\\Nicholas Henrique\\Documents\\100388.txt"));
				var target = Files.newBufferedWriter(Path.of("C:\\Users\\Nicholas Henrique\\Documents\\1003882.txt"),
						StandardOpenOption.APPEND)) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
