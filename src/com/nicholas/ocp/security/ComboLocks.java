package com.nicholas.ocp.security;

import java.util.Map;

//Extensibility
final public class ComboLocks {

	/*
	 * 
	 * Esta classe possui uma variavel de instancia que armazena senhas para os
	 * cadeados de cada animal. Poderiamos ter marcado a variavel de instancia como
	 * public, mas se tornaria vulneravel a outras classes, alem de ter um
	 * encapsulamento pobre. Principio chave de seguranca e limitar a acessibilidade
	 * tanto quanto possivel, isto e chamado de principle of least privilege.
	 * 
	 * Escrevemos metodos publicos que fornecem as fiuncionalidades necessarias.
	 * Limitamos o acesso da variavel como private. E boa pratica usar private ou
	 * private-package em variaveis de instancias sempre que possivel. Claro,
	 * private-package e melhor do que public e private e melhor do que private
	 * -package.
	 * 
	 * Caso estamos trabalhando com modulos, exportamos pacotes seguros para um
	 * modulo especifico
	 * 
	 * exports package to specific.module.
	 * 
	 * Esta classe foi marcada como final, pois estamos restringindo a
	 * extensibilidade. Poderiamos ter criado uma covariante desta classe, dando
	 * override no metodo isComboValid, criando uma versao do mal do isComboValid,
	 * mandando por exemplo as senhas por email caso sejam validadas.
	 * 
	 * Final keyworkd impede sub classes dessa classe
	 */

	// Access control
	private Map<String, String> combos;

	public boolean isComboValid(String animal, String combo) {
		var correctCombo = combos.get(animal);
		return combo.equals(correctCombo);
		/*
		 * Fornecemos por meio de um metodo, oq precisamos e deixamos limitado as
		 * senhas.
		 */
	}
}
