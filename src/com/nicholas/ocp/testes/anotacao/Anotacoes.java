package com.nicholas.ocp.testes.anotacao;

import com.nicholas.ocp.testes.anotacao.Exercise.Teste;
@TesteDocumented
public class Anotacoes {

	/*
	 * Metadado -> Qualquer dado que descreve outro dado.
	 * 
	 * Purpose de uma anotacao -> Atribuir atributos de metadados para uma
	 * classe,metodo,variavel ou outras anotacoes.
	 * 
	 * Regras de anotacoes
	 * 
	 * 1-Elas funcionam como interfaces.
	 * 
	 * 2-As anotacoes estabelecem ralcoes que tornam mais facil o gerenciamento de
	 * dados da aplicacao.
	 * 
	 * 3-Descrevem informacoes especializadas na declaracao onde sao definidas
	 * 
	 * 4-Elas sao metadados opcionais,nao fazem opcionais.
	 * 
	 * Criando uma anotacao, para declarar uma anotacao usamos @interface(tudo em
	 * minusculo).
	 * 
	 * Sim,usamos uma anotacao para criar outra.
	 * 
	 * Se a anotacao nao tiver nenhum elemento implementado, podemos ocultar o ().
	 * 
	 * Elemento e um atributo que armazena valores sobre usos particulares de uma
	 * anotacao.
	 * 
	 * ->Os elementos podem ser tipos primitos, Class, String, enum ou array(1
	 * dimensao) de qualquer um desses tipos.
	 * 
	 * Um anotacao que nao possui nenhum elemento e chamado de marker annotation.
	 * 
	 * Ao implementar uma anotacao, qualquer elemntos que n possui um valor
	 * default,e considerado requirido.
	 * 
	 * Default como no switch, deve ser constante e nao nullo.
	 * 
	 * Como em metodos abstratos, elementos de anotacoes sao implicitamente public abstract.
	 * 
	 * Como variaveis de interfaces, variaveis de anotacoes sao constantes implictamentes!(PUBLIC STATIC FINAL)
	 * 
	 * 
	 */
	{
		System.out.println(Teste.A);
	}

	static private @interface teste {
		int numerico() default 2;
	}
}

@interface Exercise {
	enum Teste {
		A, B, C
	}

	int optc = 0;

	int numerico() default optc;

	Teste testeComEnum();
}
