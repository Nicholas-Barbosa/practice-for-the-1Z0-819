package com.nicholas.ocp.nio2;

import java.nio.file.Path;

public class OCPInteractingWithPaths {

	/*
	 * Muitos metodos do Path, incluem varargs opcionais, que sao os seguintes->
	 * 
	 * LinkOption.NOFOLLOW_LINKS, CopyOption e OpenOption sao as interfaces
	 * herdadas. Nao segue o symbolic link.
	 * 
	 * StandardCopyOption.ATOMIC_MOVE, CopyOPtion interface herdada. Move um file
	 * como um atomic file no file system.
	 * 
	 * CREATE_ATTRIBUTES, Copia atributos existente para um novo file.
	 * 
	 * REPLACE_EXISTINGS, Substitui o file existente
	 * 
	 * StandardOpenOption, OpenOption interface herdada. Se o file estiver aberto
	 * para gravacao, ira anexar ao fim.
	 * 
	 * CREATE, Cria um novo file
	 * 
	 * CREATE_NEW , Cria um novo file se este realemente nao existir
	 * 
	 * READ, Abre o acesso para leitura
	 * 
	 * TRUNCATE_EXISTING, Se o file estiver aberto para gravacao, exclui o file e
	 * anexa ao inicio.
	 * 
	 * WRITE, Abre o acesso para gravacao
	 * 
	 * FileVisitOption.FOLLOW_LINKS, inverso do LinkOption. Ele segue o symbolic
	 * link
	 * 
	 * Alguns metodos nao exigem que o path realmente exista no file system. A JVM
	 * conecta com o file system para determinar os componentes do path, diretorio
	 * pai de um file,etc.Como regra geral, aqueles metodos que declaram
	 * IOException, geralmente EXIGEM que o path exista.
	 * 
	 * Motivos comuns para IOException
	 * 
	 * 1-Perda de conexao com o file system
	 * 
	 * 2-File ou Diretorio existem mas nao podem ser acessados ou modificados.
	 * 
	 * 3-File nao pode ser substituido
	 * 
	 * 4-File ou diretorio tem que existir mas nao existem.
	 * 
	 * Metodos para interagir com Paths
	 * 
	 * 1-toString() -> Retorna uma String representando o path.
	 * 
	 * 2-getNameCount() -> Retorna o numero de elementos do path, excluindo o Parent
	 * 
	 * getName(int index) -> Retorna a referencia para cada elemento, tambem
	 * excluindo o Parent
	 * 
	 */
	public static void main(String[] args) {
		Path path = Path.of("C:", "Users", "Nicholas Henrique", "Desktop", "myObject.txt");
		System.out.println("Elements " + path.getNameCount());
		int i = 0;
		while (i < path.getNameCount()) {
			System.out.println("Element " + path.getName(i));
			i++;
		}
	}
}
