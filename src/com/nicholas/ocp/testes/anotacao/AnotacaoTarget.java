package com.nicholas.ocp.testes.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnotacaoTarget {

	/*
	 * Como sabemos, uma anotcao pode ser aplicada a qualquer tipo java.
	 * 
	 * Podemos limitar esse "recurso" usando a anotcao @Target, especificamente ela
	 * contem um elemento shorthand(value), que pega valores de um enum to tipo
	 * ElementType.
	 * 
	 * Valores do Enum
	 * 
	 * 1-TYPE,aplica-se a classes, interfaces, enums e anotacoes.
	 * 
	 * 2-FIELD, aplica-se a variavies de instancias, statics e valores de enum.
	 * 
	 * 3-METHOD,aplica-se a declaracoes de metodos.
	 * 
	 * 4-PARAMATER, aplica-se a metodos,construtores,expressoes lambdas.
	 * 
	 * 5-CONSTRUCTOR, aplica-se a construtores
	 * 
	 * 6-LOCAL_VARIABLE,aplica-se variavies locais.
	 * 
	 * 7-ANNOTATION_TYPE,aplica-se a anotacoes
	 * 
	 * 8-TYPE_USE, pode ser usado em qualquer declaracao tipo java. Exceto para
	 * metodos voids.
	 * 
	 * Anotacao @Retention. Essa anotcao serve para reter a anotacao em determinada circunstancia.Usa elemento value que recebe valores do RetentionPolicy enum.
	 * 
	 * 1-SOURCE -> usado em apenas source files, nao disponivel em tempo de compilacao.
	 * 
	 * 2-CLASS ->Armazena no .class e nao esta disponivel em tempo de execucao.
	 * 
	 * 3-RUNTIME ->Armazena no .class e esta disponivel em tempo de execucao
	 * 
	 * 
	 */

	@TesteTarget
	public static int teste;

	@TesteTarget
	public AnotacaoTarget() {
		// TODO Auto-generated constructor stub
	}
	
	@TesteTarget
	public int testegg() {
		return 10;
	}
}

@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.FIELD, ElementType.CONSTRUCTOR,ElementType.TYPE_USE })
@interface TesteTarget {
}
