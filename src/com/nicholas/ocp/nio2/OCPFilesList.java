package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class OCPFilesList {

	/*
	 * Este metodo permite vc listar todos os files e subdiretorios de um
	 * determinado diretorio, mas nao realizar um traversing directory. Sendo
	 * assim,ele percorre os files mais razos de seu diretorio
	 * 
	 * public static Stream<Path>list(Path dir)throws IOExcpetion
	 */

	private static final Path pathTarget = Paths
			.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2\\movingFilesWithList\\dest");

	public static void main(String[] args) throws IOException {
		try (Stream<Path> stream = Files
				.list(Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2\\movingFilesWithList"));) {
			Stream<String> filesMoved = stream.parallel().map(OCPFilesList::copyAllFiles)
					.filter(x -> !x.startsWith("Not"));
			System.out.println("Files moved " + filesMoved.count());
		}
		/*
		 * Este metodo e similar ao readAllLines, mas este usa streams e e lazy
		 * evaluation, as linhas so sao lidas quando realmente necessarios. O metodo
		 * read(), le todas as linhas em memoria e pode causar um OutOfMemory
		 */
	}

	private static String copyAllFiles(Path currentPath) {
		/*
		 * Inves de deep copy como move() a copy() fazem, realizamos uma deep copy. 
		 * Exceto por nao estarmos movendo um diretorio mas so arquivos.
		 */
		if (Files.isRegularFile(currentPath)) {
			try {

				Files.move(currentPath, pathTarget.resolve(currentPath.getFileName()), StandardCopyOption.ATOMIC_MOVE);
				return "Moved";
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "Not Moved";
	}
}
