package com.nicholas.ocp.nio2;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OCPNio2TraversingDirectory {

	/*
	 * Traversing directory e o processo na qual voce comeca no diretorio pai e
	 * itera sobre seus filhos, ate que uma condicao seja atendida ou na ha mais
	 * elementos para iterar.
	 * 
	 * Ha duas estrategias de traversing directory, depth-first e breadth-first.
	 * 
	 * Depht-first, percorre a estrura comecando no root e vai ate um leaf linear e
	 * depois volta para cima, em direcao ao root percorrendo todos os paths que
	 * foram pulados ao longo do caminho.
	 * 
	 * Bredth-first, comeca a percorrer no diretorio pai e processa todos os
	 * elementos de cada profundidade(nivel), antes de prosseguir pro poximo nivel.
	 * 
	 * walk(Path start, FileVisitOption...op)/walk(Path start,int depthLimit,
	 * FileVisitOption ...op) -> Percorre a arvore de diretorio,comecando no start e
	 * usando estrategia depth-first. A stream e lazy evaluation,ajuda a evitar
	 * OutOfMemory
	 * 
	 * 
	 * find()->Percorre e filtra os resultados.
	 */

	private static final Path start = Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\nio.2");

	public static void main(String[] args) throws IOException {
		walk();
		find();
	}

	private static void walk() throws IOException {
		// depth limit default e Integer.MAX_VALUE, os sistemas operacionais nao
		// suportam valores maiores que o Integer.MAX_VALUE, sendo assim o valor defualt
		// percorre tudo.
		try (Stream<Path> paths = Files.walk(start, 3)) {
			paths.filter(path -> Files.isRegularFile(path)).forEach(System.out::println);
		}
		/*
		 * Por padrao este metodo nao segue symbolic links. Caso seja necessario o
		 * seguimento de symbolic links, usamos FileVisitOption.FOLLOW_LINKS. Esteja
		 * ciente que este uso pode resultar em muitos problemas como, se o symbolic
		 * link apontar pro root do file system, todos os arquivos do sistema serao
		 * pesquisados, pior ainda, pode desencadear um Cycle.
		 * 
		 * Cycle e uma dependencia circular infinita na qual uma entrada em um
		 * diretorio, aponta para seu ancestral.Aqui ira ocorrer um loop between entre e
		 * sai do diretorio como um loop, causando FileSystemLoopException
		 */

	}

	private static void find() throws IOException {
		/*
		 * Este metodo e mais eficiente que walk(), por usar view, entao ele
		 * automaticamente recupera os metadados para nos, e voce poder "embutir" o
		 * filter() da strem, dentro delo no parametro BiPredicate. Alem de nao nos
		 * preocupar sobre metodos que declaram uma checked exception.
		 */
		try (Stream<Path> walk = Files.find(start, 3, (p, b) -> b.isRegularFile())) {
			walk.forEach(System.out::println);
		}
	}

}
