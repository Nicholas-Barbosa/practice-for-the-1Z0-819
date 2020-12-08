package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

public class OCPFilesMeta extends OCPFiles {

	/*
	 * Files methods para recuperar metadados de um file, ou recuperar file
	 * attribute
	 * 
	 * boolean isDirectory(Path p,LinkOption ..op) -> retorna se o path e um
	 * diretorio existente, ou se e um symbolic link que refere a um diretorio
	 * existente
	 * 
	 * boolean isSymbolicLink(Path p) -> retorna se o path e um symbolic link
	 * independente se exista ou nao o target.
	 * 
	 * boolean isRegularFile(Path p,LinkPtion ...op) -> Retorna se o path e um
	 * regular file. Java define um regular file, um file que pode conter conteudos,
	 * oposto de symbolic link, direcotiries ou files nao regulares no sistema
	 * operacional
	 * 
	 * boolean isHidden(Path p) throws IOException -> retorna se o path existe e e
	 * oculto no SO.
	 * 
	 * boolean isReadable(Path p) -> retorna se o path e legivel, habil para ser
	 * lido.
	 * 
	 * boolean isWritable(Path p) -> retorna se o path e acessivel a modificacoes.
	 * 
	 * boolean isExecutable(Path p) -> retorna se o path e um executavel, habil de
	 * ser executado no SO.
	 * 
	 * long size(Path p )throws IOException -> tamanho em bytes do file. Este
	 * tamanho e conceitual e pode divergir do tamanho no dispositivo de
	 * armazenamento.
	 * 
	 * FileTime getLastModifiedTime(Path p, LinkOption ...p) -> Objeto FileTime
	 * representando o timestamp da ultima vez da modificacao do arquivo.
	 */

	private static final Path pathArq = pathToWork.resolve("readDestino.txt");

	public static void main(String[] args) throws IOException {
		System.out.println("Diretorio: " + isDirectory());
		System.out.println("Symbolic link: " + isSymbolicLink());
		System.out.println("Regular file: " + isRegularFile());
		System.out.println("Hidden: " + isHidden());
		System.out.println("Writeble: " + isWriteble());
		System.out.println("Readeble " + isReadable());
		System.out.println("Executable: " + isExecutable());
		System.out.println("size in bytes: " + sizeInBytes());
		System.out.println("last modified: " + lastModified().to(TimeUnit.HOURS));

	}

	private static boolean isDirectory() {
		return Files.isDirectory(pathToWork);
	}

	private static boolean isSymbolicLink() {
		return Files.isSymbolicLink(pathArq);
	}

	private static boolean isRegularFile() {
		return Files.isRegularFile(pathArq);
	}

	private static boolean isHidden() throws IOException {
		return Files.isHidden(pathToWork);
	}

	private static boolean isWriteble() {
		return Files.isWritable(pathToWork);
	}

	private static boolean isReadable() {
		return Files.isReadable(pathToWork);
	}

	private static boolean isExecutable() {
		return Files.isExecutable(pathToWork);
	}

	private static long sizeInBytes() throws IOException {
		return Files.size(pathArq);
	}

	private static FileTime lastModified() throws IOException {
		return Files.getLastModifiedTime(pathArq);
	}
}
