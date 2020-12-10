package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class OCPNio2Together {

	/*
	 * Path methods
	 * 
	 * 1-getNameCount
	 * 
	 * 2-getName(int i)
	 * 
	 * 3-subpath(int i,int exclusive)
	 * 
	 * 4-getFileName
	 * 
	 * 5-getParent
	 * 
	 * 6-getRoot
	 * 
	 * 7-isAbsolutePath
	 * 
	 * 8-toAbsolutePath
	 * 
	 * 9-relativize
	 * 
	 * 10-normalize
	 * 
	 * 11-toRealPath
	 * 
	 * 12-toString
	 * 
	 * 13-resolve
	 * 
	 * Files methods
	 * 
	 * 1-isSameFile
	 * 
	 * 2-exists
	 * 
	 * 3-copy
	 * 
	 * 4-move
	 * 
	 * 5-createDirectory
	 * 
	 * 6-createDerectories
	 * 
	 * 7-delete
	 * 
	 * 8-deletIfExists
	 * 
	 * 9-newBufferedReader
	 * 
	 * 10-newBufferedWriter
	 * 
	 * 12-isRegularFile
	 * 
	 * 13-isDirectory
	 * 
	 * 14-isSymbolicLink
	 * 
	 * 15-readAllLines
	 * 
	 * 16-lines
	 * 
	 * 17-isWriteble
	 * 
	 * 18-isExecutable
	 * 
	 * 19-isReadable
	 * 
	 * 20-size
	 * 
	 * 21-getLastModified
	 * 
	 * 22-BasicFileAttributes readAttributes
	 * 
	 * 23-FileAttributesView getFileAttributesView
	 * 
	 * 24-list
	 */
	private static final Path pathFolder = Path.of("C:\\Users\\Nicholas Henrique\\Documents\\nio.2");

	public static void main(String[] args) throws IOException {
		copy();
		bufferedAppend();
		isSameFile();
	}

	private static void copy() throws IOException {
		Files.copy(pathFolder.resolve("readOrigem.txt"), pathFolder.resolve("destino.txt"),
				StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
	}

	private static void bufferedAppend() throws IOException {
		var inputStream = Files.newBufferedReader(pathFolder.resolve("readOrigem.txt"));
		var outputStream = Files.newBufferedWriter(pathFolder.resolve("append.txt"), StandardOpenOption.APPEND);
		try (inputStream; outputStream) {
			String line;
			while ((line = inputStream.readLine()) != null) {
				outputStream.write(line);
			}
			outputStream.flush();
		}
	}

	private static void isSameFile() throws IOException {
		/*
		 * toRealPath(), alem de chamar o toAbsolutePath() tambem chama o normalize(). O
		 * reviatalize() como isSameFile() tambem chamam o normalize()
		 */
		Path pathOne = pathFolder.resolve("readOrigem.txt");
		Path pathTwo = pathFolder.resolve("nio2/../readOrigem.txt");
		System.out.println(Files.isSameFile(pathOne, pathTwo));
		System.out.println(Files.isHidden(pathTwo));
		System.out.println(pathOne.relativize(pathTwo));

	}

	public void usePrintWriter(PrintWriter pw) {
		boolean bval = true;
		pw.write("");
	}
}
