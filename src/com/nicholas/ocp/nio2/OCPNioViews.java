package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class OCPNioViews {

	/*
	 * View e um conjunto de atributos relacionados de uma filoe system particular.
	 * Ele serve para reduzir as idas e vindas do file system, para recuperar
	 * metadados de algum file ou directory.
	 * 
	 * BasicFilAttributes, BasicFileAttributesView (view interface) -> Conjunto de
	 * atributos suportados por todos os sistema operacionais.
	 * 
	 * DosFileAttributes, DosFileAttributesView(view interface) -> Conjunto de
	 * atributos suportados por sistema dos/windows.
	 * 
	 * PosixFileAttributes,PosixFilesAttributesView(view interface) -> Conjunto de
	 * atributos suportados por sistema posix, como unix,linux,max,etc.
	 * 
	 * publis static <A extends BasicFileAttributes> A readAttributes(Path p,
	 * Class<A>type,LinkOption ...op)throws IOException ->le atributos de maneira
	 * read-only.
	 * 
	 * public static <A extends FileAttributeView>A getFileAttributeView(Path p,
	 * Class<A>type,LinkOption ...op)->Retorna um updatable view, podemos gravar e
	 * ler num mesmo objeto.
	 */

	public static void main(String[] args) throws IOException {
		BasicFileAttributes basic = readAttributes();
		System.out.println("Size(bytes): " + basic.size());
		System.out.println("Directory: " + basic.isDirectory());
		getAttributesView();

	}

	private static BasicFileAttributes readAttributes() throws IOException {
		Path path = Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2");
		return Files.readAttributes(path, BasicFileAttributes.class);
	}

	private static void getAttributesView() throws IOException {
		Path path = Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2");
		BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		BasicFileAttributes readOnly = view.readAttributes();

		// Modify file last modified time
		FileTime lastModifiedTime = FileTime.fromMillis(readOnly.lastModifiedTime().toMillis() + 10_000);
		view.setTimes(lastModifiedTime, null, null);
		System.out.println("Last modifed time after modified " + readOnly.lastModifiedTime());
	}
}
