package com.nicholas.ocp.modules;

public class OCPUnamedModule {

	/*
	 * Unamed modules, como os automatic modules sao jar regulares, ao contrario que
	 * estao no class path e nao no modulepath.
	 * 
	 * Por este motivo, qualquer arquivo module-info.java sera ignorado e seus
	 * pacotes nao estarao visiveis para outros modulos, pois nao serao exportados.
	 */
}
