package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OCPAtomicMove {
	private static final Path p = Path.of("C:\\Users\\Nicholas Henrique\\Documents\\nio.2");

	public static void main(String[] args) throws IOException {

		ExecutorService executor = null;
		try {
			executor = Executors.newFixedThreadPool(2);
			executor.execute(() -> System.out.println(Files.exists(p.resolve("movedFiles\\moved - Copia.txt"))));
			executor.execute(OCPAtomicMove::move);
		} finally {
			executor.shutdown();
		}
	}

	private static void move() {
		try {
			Files.move(p.resolve("moved - Copia.txt"), p.resolve("movedFiles\\moved - Copia.txt"),
					StandardCopyOption.ATOMIC_MOVE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
