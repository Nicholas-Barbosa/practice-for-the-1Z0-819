package com.nicholas.ocp.file;

import java.io.File;
import java.util.Arrays;

public class OCPFile {

	/*
	 * java.io.File
	 * 
	 * Classe usada para obter informacoes de arquivos ou diretorios.
	 * 
	 * Lembrando que file e um registro dentro do dispositivo de aramzenamento
	 * persistente(hard disk, memory card), que contem dados.Normalmente estes files
	 * sao organizados em hierarquicamente usando diretorios.
	 * 
	 * Diretorios sao lugares onde pode conter arquivos ou outros diretorios.
	 * 
	 * Para o java interagir com arquivos, ele precisa de conectar com o file
	 * system, nao qual e o cara responsavel por ler e escrever arquivos ou
	 * diretorios.
	 * 
	 * Root direcotory, e o diretorio superior que herda todos os diretorios e
	 * files.
	 * 
	 * Path e uma String que representa o diretorio ou o file.
	 * 
	 * Dependendo do sistema operacional, os diretorios e arquivos sao seperados por
	 * slash(/),o lado direito e pai do lado esquerdo.
	 */

	public static void main(String[] args) {
		// String parent, String child
		File file = new File("c://", "IOFile");
		if (file.exists()) {
			if (file.isFile()) {
				System.out.println("File, Absolute path: " + file.getAbsolutePath());
				System.out.println("File, name: " + file.getName());
				System.out.println("File, parent: " + file.getParent());
				System.out.println("File, lenght in bytes: " + file.length());
				System.out.println("File, last modified: " + file.lastModified());
			} else {
				System.out.println("Directory, Absolute path: " + file.getAbsolutePath());
				System.out.println("Directory, name: " + file.getName());
				System.out.println("Directory, parent: " + file.getParent());
				System.out.println("Directory, lenght in bytes: " + file.length());
				System.out.println("Directory, last modified: " + file.lastModified());
				System.out.println("---Files---");
				Arrays.asList(file.listFiles()).forEach(System.out::println);
			}
		} else
			System.out.println("Ur File instance does not exists");
	}
}
