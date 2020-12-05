package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	 * 3-getName(int index) -> Retorna a referencia para cada elemento, tambem
	 * excluindo o Parent
	 * 
	 * 4-subpath(int begin, int end) -> Retorna um path com elementos destes
	 * indexes. Nao inclui o root como no getNameCount,getName.
	 * 
	 * 5-getFileName() -> Retorna um Path com o nome do current element.
	 * 
	 * 6-getParent() -> Retorna o elemento pai do arquivo ou diretorio. Retorna null
	 * se estiver operando no root ou topo do relative path.
	 * 
	 * 7-getRoot() -> Retorna o elemento path root. Null se estiver no relative
	 * path.
	 * 
	 * 8-isAbsolute() -> Retorna se o Path e absolute path
	 * 
	 * 9-toAbsolutePath() -> Se o Path nao for um Absolute Path, junta o current
	 * working directory com o Path. Se for relative retorna o proprio objeto.
	 * 
	 * 10-resolve() -> Concatena dois Path. O objeto que esta chamando este metodo
	 * servira como base para um novo Path, com o argumento de entrada anexado.
	 * 
	 * 11-revitalize() -> Cria um relative path com path symbols de um Path para
	 * outro. A idei e, quantos steps eu preciso pegar para ir de um Path a outro.
	 * 
	 * 12-normalize() -> Elimina os path symbols redundantes
	 * 
	 * 13-toRealPath() -> Como o normalize(), remove os path symbols e como no
	 * toAbsolutePath() se for relative junta o current working directory com o
	 * Path. Unico que lanca uma checked exception.
	 */
	public static void main(String[] args) throws IOException {
		Path path = Path.of("C:", "Users", "Nicholas Henrique", "Desktop", "myObject.txt");
		System.out.println("Elements " + path.getNameCount());
		int i = 0;
		while (i < path.getNameCount()) {
			System.out.println("Element " + path.getName(i));
			i++;
		}
		System.out.println("Elements of 0 to 5: " + path.subpath(0, 4));
		System.out.println("File Name: " + path.getFileName());

		Path parent = path;
		while ((parent = parent.getParent()) != null) {
			System.out.println("Parent: " + parent);
		}
		System.out.println("Root " + Paths.get("nicholas").getRoot());
		System.out.println("isAbsolute " + path.isAbsolute());
		/*
		 * toAbsolute junta System.getProperty("user.dir") com o Path
		 */
		System.out.println("toAbsolute" + Path.of("nicholas", "barbosa").toAbsolutePath());
		System.out.println("resolve " + path.resolve(Path.of("../nicholas", "barbosa")));

		Path path1 = Path.of("nicholas", "name.txt");
		Path path2 = Path.of("age", "age.txt");
		System.out.println(path1.relativize(path2));// ../../age/age.txt
		System.out.println(path2.relativize(path1));// ../../nicholas/name.txt

		/*
		 * Todas ocorrencias de . sao considerados redundantes. Se .. for procedido de
		 * um nao .., ambos sao redundantes
		 */
		Path pathNormalize = Path.of("file/bla/../realPath.txt");
		System.out.println(pathNormalize.normalize());
		System.out.println(pathNormalize.toRealPath(LinkOption.NOFOLLOW_LINKS));
	}
}
