package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Test {
	static Path p1 = Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2");

	public static void main(String[] args) throws IOException {
		Stream<Path> list = Files.list(p1);
		System.out.println(list.count());
	}
}
