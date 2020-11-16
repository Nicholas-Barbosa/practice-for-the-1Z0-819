package com.nicholas.ocp.modules;

public class OCPNamedModule {

	/*
	 * Highlights do module-info.java
	 * 
	 * exports<package> -> Permite que outros modulos acessem este pacote.
	 * 
	 * exports<package> to<module> -> Permite que um modulo especifico acesse este
	 * pacote.
	 * 
	 * requires<module> -> Especifica que o modulo depende de outro modulo.
	 * 
	 * requres transitive<module> -> Este modulo e outros modulos que usam este
	 * modulo, dependem de outro modulo.
	 * 
	 * uses<interface> -> Especifica que este modulo usa um servico.
	 * 
	 * provide<interface>with<class> -> Especifica que este modulo fornece uma
	 * implementacao do servico.
	 * 
	 * ClassPath vs Module path
	 * 
	 * A aplicacao pode acessar qualquer tipo no class path, que esteja exposto com
	 * um modificado de acesso, como public.
	 * 
	 * No module path, o tipo deve ser exposto como public, deve estar no pacote
	 * exportado do outro modulo e declarar um require.
	 * 
	 * NamedModules -> Contem um module-info.java que contem o nome do modulo. Este
	 * arquivo fica no root do jar a lado de outros pacotes. Alem de estar no module
	 * path e nao no class path.
	 */
}
