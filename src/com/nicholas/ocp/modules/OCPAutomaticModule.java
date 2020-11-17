package com.nicholas.ocp.modules;

public class OCPAutomaticModule {

	/*
	 * Unnamed modules, nao contem module-info.java e nem nome(kkkkk). Esta presente
	 * no modulepath, como seria um jar regular mas pelo fato de estar num
	 * modulepath e tratado como modulo.
	 * 
	 * Como nao tem module-info.java, todos seus pacotes sao exportados, e seu nome
	 * e definido automaticamente.
	 * 
	 * Um arquivo jar e um zip com um diretorio especial chamado META-INF, nao qual
	 * pode ter um ou mais arquivos. O manifest.mf esta sempre presente, ele
	 * especifica informacoes adicionais sobre seu jar, por exemplo em que versao do
	 * java foi construido, automtic-module-name no automtic module,para definir um
	 * nome ao modulo.
	 * 
	 * Steps que o java segue ao nomear um automatic module.
	 * 
	 * 1 -> Se foi definido o automatic-module-name, ele usara este nome como nome
	 * do modulo. Caso contrario segue os fluxos.
	 * 
	 * 2 -> Ira remover a extensao .jar do arquivo.
	 * 
	 * 3-> Ira remover a versao do arquivo.
	 * 
	 * 4-> Ira substituir caracteres especias(diferentes de numeros e letras) por
	 * pontos (.)
	 * 
	 * 5-> Ira remover qualquer sequencia de pontos ou pontos unicos.
	 * 
	 * 6->Ira remover pontos no inicio ou no fim do nome
	 */
}
