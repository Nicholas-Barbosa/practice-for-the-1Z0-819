package com.nicholas.ocp.testes.anotacao;

import java.lang.annotation.Annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.reflections.Reflections;

@Refelection(name = "What a wonderful world!")
@VouPegarEssaAnotacao(value=2)
public class TestePegaAnotacao extends VouPegarPorInherited {
	@VouPegarEssaAnotacao(900)
	public static void main(@VouPegarEssaAnotacao(9020) String[] args) {
		Method[] methods = TestePegaAnotacao.class.getMethods();
		Annotation annotation = methods[0].getAnnotation(VouPegarEssaAnotacao.class);
		if (annotation instanceof VouPegarEssaAnotacao) {
			VouPegarEssaAnotacao customAnnotation = (VouPegarEssaAnotacao) annotation;
			System.out.println("value: " + customAnnotation.value());
		}

		System.out.println("----ANOTACOES DA CLASSE----");

		VouPegarEssaAnotacao vou[] = TestePegaAnotacao.class.getAnnotationsByType(VouPegarEssaAnotacao.class);
		List<VouPegarEssaAnotacao> listaVou = Arrays.asList(vou);
		listaVou.forEach(an -> System.out.println(an.value()));
		System.out.println("Scanning using Reflections:");

		Reflections ref = new Reflections("com.nicholas.ocp.testes.anotacao");
		for (Class<?> cl : ref.getTypesAnnotatedWith(VouPegarEssaAnotacao.class)) {
			VouPegarEssaAnotacao findable = cl.getAnnotation(VouPegarEssaAnotacao.class);
			System.out.printf("Found class: %s, with meta name: %s%n", cl.getSimpleName(), findable.name());
		}
	}

}

@Inherited
@Repeatable(Vous.class)
@Retention(RetentionPolicy.RUNTIME)
@interface VouPegarEssaAnotacao {
	int value();

	String name() default "Nicholas";
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Vous {
	VouPegarEssaAnotacao[] value();
}

@VouPegarEssaAnotacao(1)
@VouPegarEssaAnotacao(1)
@VouPegarEssaAnotacao(6)
class VouPegarPorInherited {
}

@Retention(RetentionPolicy.RUNTIME)
@interface Refelection {
	String name();
}