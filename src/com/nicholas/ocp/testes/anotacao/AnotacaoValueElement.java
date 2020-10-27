package com.nicholas.ocp.testes.anotacao;

@ValueTeste({})
public class AnotacaoValueElement {
	/*
	 * Anotacoes conhecidas como shorthand, sao aquelas que quando aplicadas so
	 * fornecem o elementValue, sem o elementName. Ha regras para usa-la.
	 * 
	 * 1-Na declaracao da anotacao deve conter um elemento chamado value,que pode
	 * ser default ou requirido.
	 * 
	 * 2-Nao pode haver outros elementos requiridos nessa anotacao.
	 * 
	 * 3-Nao pode fornecer valores para outros elementos ao usar a anotacao.
	 * 
	 * As anotacoes elas suportam shorthand notation ao passar um array de elemento
	 * unico(ocultacao de {}).
	 */
}

@interface ValueTeste {

	String[] value();

	int teste() default 2;
}
