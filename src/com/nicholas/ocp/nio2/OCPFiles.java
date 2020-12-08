package com.nicholas.ocp.nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

public class OCPFiles {

	/*
	 * Esta classe helper Files interage com arquivos e diretorios, como a io.File!.
	 * 
	 * Metodos
	 * 
	 * 1-boolean exists(Path p) -> Retorna se o path existe ou nao no file system
	 * 
	 * 2-boolean isSameFile(Path p, Path p2) -> Retorna se os paths sao o mesmo
	 * file. Se um dos paths nao existirem, e lancado IOException. Este metodo pode
	 * ser usado para verificar se os paths estao no mesmo diretorio. Ha uma excecao
	 * ao lancar um exception, se os dois objetos paths forem iguais em termos de
	 * equals(), e retorando true independente se um dos paths existam no file
	 * system. Segue symbolic links.
	 * 
	 * 3-Path createDirectory(Path p, FileAttribute<?>...) -> Cria um diretorio se o
	 * mesmo nao existir, caso exista ou o caminho do path nao exista, IOException!
	 * 
	 * 4-createDirectories(Path p,FileAttribue<?>...) -> Funciona como o mkdirs(),
	 * cria o diretorio, mesmo os diretorios pais nao existindo, ele criar tambem!
	 * Se os diretorios ja existirem, ele faz nada.
	 * 
	 * 5-Path copy(Path source,Path target,CopyOption op...); long copy(InputStream
	 * source, Path target, CopyOption op...); long copy(Path p,OutPutstream op,
	 * CopyOption op...) -> Estes metodos movem files ou diretorios de um lugar ha
	 * outro. Caso o target ja exista e sem usar o
	 * StandardCopyOption.REPLACE_EXISTING, sera lancado uma exception. Observer que
	 * ha versoes com I/O, a versao com InputStream, le os bytes do stream e grava
	 * num File. A versao com OutputStream le os bytes do file e grava num
	 * outputstream.
	 * 
	 * Path move(Path source,Path target,CopyOption op...) -> Como no copy(), este
	 * metodo ira mover, renomear arquivos e diretorios. Tambem lanca IOException se
	 * o target ja existir e nao for passado um StandardOption.REPLACE_EXISTING.
	 * 
	 * Podemos passar StandarOption.ATOMIC_MOVE, como em threads, este file ou
	 * diretorio sera movido numa unidade unica de operacao.
	 * 
	 * void delete(Path p) -> Deleta o diretorio se somente estiver vazio. Caso o
	 * path nao exista sera lancado uma IOException.
	 * 
	 * boolean deleteIfExists(Path p) -> Deleta diretorio se estiver vazio ou um
	 * file como o delete(), mas nao lanca uma exception se o path nao existir.
	 * Retorna true ou falso dependendo da operacao.
	 * 
	 * BufferedReader newBufferedReader(Path p); BufferedWriter
	 * newBufferedWiter(Path p) sao metodos para trabalhar com I/O streams.
	 * 
	 * List<String>readAllLines(Path p) -> le todas as linhas do path e grava em
	 * memoria numa collection.
	 * 
	 * exists() e o unico metodo de Files que nao declara uma checked excpetion!
	 */

	private static final Path pathToWork = Path.of("C:\\Users\\Nicholas Henrique").resolve("Documents\\nio.2");

	public static void main(String[] args) throws IOException {
		System.out.println("Path exists: " + exists());
		System.out.println("Same file: " + isSameFile());
		// System.out.println("Path created: " + createDirectory());
		System.out.println("Paths created: " + createDirectories());
		System.out.println("Path moved: " + copy());
		System.out.println("Directory deleted: " + deleteIfExists());
		newBufferedMethodsReadAllLines();
		System.out.println("Lines: " + readAllLines());
		System.out.println("Moved " + move());
	}

	private static boolean exists() {
		return Files.exists(pathToWork);
	}

	private static boolean isSameFile() throws IOException {
		return Files.isSameFile(pathToWork, pathToWork);
	}

	private static Path createDirectory() throws IOException {
		return Files.createDirectory(pathToWork.resolve("subDirectory"));
	}

	private static Path createDirectories() throws IOException {
		return Files.createDirectories(pathToWork.resolve("sub/sub1/end"));
	}

	private static Path copy() throws IOException {
		return Files.copy(Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\writerLine.txt"),
				pathToWork.resolve("moved.txt"), StandardCopyOption.REPLACE_EXISTING);
	}

	private static Path move() throws IOException {
		/*
		 * Como no copy(), nao e movido um file para outro diretorio sem especificar
		 * todo o path.
		 */
		return Files.move(Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\writerLine.txt"),
				pathToWork.resolve("movedFiles/moved.txt"), StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.ATOMIC_MOVE);
	}

	private static boolean deleteIfExists() throws IOException {
		return Files.deleteIfExists(pathToWork.resolve(Paths.get("folderToDeleteByFiles")));
	}

	private static void newBufferedMethodsReadAllLines() throws IOException {
		BufferedReader reader = Files.newBufferedReader(pathToWork.resolve("readOrigem.txt"));
		BufferedWriter writer = Files.newBufferedWriter(pathToWork.resolve("readDestino.txt"));
		try (reader; writer) {
			String line;
			while ((line = reader.readLine()) != null) {
				int i = 0;
				while (i <= 100) {
					writer.write(line + " log number #" + (i++));
					writer.newLine();

				}
				writer.flush();
			}
		}

	}

	private static String readAllLines() throws IOException {
		Path path = pathToWork.resolve("readDestino.txt");
		List<String> lines = Files.readAllLines(path);
		return lines.parallelStream().collect(Collectors.joining(";"));
	}
}
