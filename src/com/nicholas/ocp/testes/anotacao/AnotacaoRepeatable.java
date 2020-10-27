package com.nicholas.ocp.testes.anotacao;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@InheritedTeste(value = 1, name = "Nicholas")
@InheritedTeste(value = 2, name = "Barbosa")
@InheritedTeste(value = 3, name = "Nicholas")
public class AnotacaoRepeatable {

	/*
	 * Ultima anotacao especifica que precisamos saber!Usamos @Repeatable para
	 * especificar uma anotacao mais de uma vez numa mesma declaracao.
	 * 
	 * *Uma anotacao sem @Reoeatable, so pode ser usada uma vez so.
	 * 
	 * *Para declarar uma repeatable, precisamos definir uma annotation type
	 * conntainig.
	 * 
	 * Uma annotation containning type e uma anotacao separada que inclui um
	 * elemento value(), com um array do tipo particular da repeatable annotation.
	 * 
	 * Por convencao, a annotation containing e em plural do nome da repeatable
	 * annotation,
	 */

	public static void main(String[] args) throws Exception {
		Method[] methods = AnotacaoRepeatable.class.getMethods();
		Annotation annotation = methods[0].getAnnotation(InheritedTeste.class);
		if (annotation instanceof InheritedTeste) {
			InheritedTeste customAnnotation = (InheritedTeste) annotation;
			System.out.println("name: " + customAnnotation.name());
			System.out.println("value: " + customAnnotation.value());
		}
	}
}

@Documented
@Repeatable(Containing.class)
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedTeste {
	int x = 10;

	String name();

	int value();
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface Containing {

	InheritedTeste[] value();
}

@Documented
@interface teste {
	/**
	 * @author: nicholas
	 */
	InheritedTeste[] value() default {};
}