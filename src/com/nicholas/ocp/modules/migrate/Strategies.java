package com.nicholas.ocp.modules.migrate;

public class Strategies {

	class BottomUp {
		/*
		 * Esta estrategia e a mais facil util quantem o poder de transformar aplicacoes
		 * que ainda nao foram migradas. Segue os passos a seguir
		 * 
		 * 1-> Escolha o projeto de nivel mais baixo, sendo eles aqueles que possuem
		 * menos requires possiveis.
		 * 
		 * 2-> Mova-o do classpath para o module path(automatic module).
		 * 
		 * 3-Adicione o module-info.java, contendo exports, requires o nome do modulo e
		 * tudo que vc necessita. A partir de agora, seu modulo deixa de ser automatic
		 * module, para named module.
		 * 
		 * 4-Garanta que os outros projetos estejam no classpath, sendo assim unnamed
		 * modules.
		 * 
		 * 5-Repita para os proximos projetos de niveis mais baixos.
		 */
	}

	class TopDown {
		/*
		 * Util quando vc nao tem o controle de todos os jars de sua aplicacao. Por
		 * exemplo, outro time tem seu proprio projeto e vc n quer perder tempo para
		 * migrar.
		 * 
		 * 1-Migre todos os projetos do classpath para o module path.
		 * 
		 * 2-Escolha um projeto de nivel mais ALTO(aquele que possue mais
		 * dependencias,requires)
		 * 
		 * 3-Adicione o module-info.java para converter de automatic module, para named
		 * module. Adicione requires,exports,etc. Como os modulos do require sao
		 * automatic modules, o java ira criar automaticamente os nomes dos modulos,
		 * seguindo os passos que ja estudamos. A menos que automatic-module-name seja
		 * especificado no META-INF/manifest.mf
		 * 
		 * 4-> Repita esses passos para os proximos high level prjects!
		 */
	}

	/*
	 * Um projeto de baixo nivel de dependencias no bottomUp, sao primariamente
	 * named modules, no topDown sao automatic modules.
	 * 
	 * Um projeto de alto nivel de dependencias no bottomUp, sao unnamed modules, ja
	 * no topDown sao named modules!
	 */
}
