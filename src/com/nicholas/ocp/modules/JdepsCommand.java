package com.nicholas.ocp.modules;

public class JdepsCommand {

	/*
	 * Usamos o jdeps, para mostrar as dependencias do aplicativo.
	 * 
	 * java -jdeps arq.jar -> ira mostar todos os modulos usados, pacotes dos
	 * modulos que estao sendo usados e os pacotes da nossa aplicacao com seus
	 * respectivos imports.
	 * 
	 * 
	 * java -jdeps arq.jar -s ou --summary -> ira mostar somente os modulos usados e
	 * nao os pacotes.
	 * 
	 * comandos como java, possuem ferramentes para descrever um modulo(-d ou
	 * --describe-module), listar modulos disponiveis(--list-modules), resolucao
	 * logica(--show-module-resolution). Com comando jar, tambem podemos descrever
	 * um modulo, usando jar -f myu.jar -d ou --describe-module
	 */
}
