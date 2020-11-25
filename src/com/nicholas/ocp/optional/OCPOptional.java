package com.nicholas.ocp.optional;

import java.util.Optional;

public class OCPOptional {
	/*
	 * Optional e criada como uma fabrica, usamos optional como forma de expressar,
	 * "nao sabemos" ou "nao disponivel"
	 * 
	 * Pense optional, como uma caixa que pode ou nao ter algo, sendo assim empty().
	 * 
	 * Ha metodos de tratar esse empty,como orElse(T other), orElseThrow(), etc.
	 * 
	 * Metodos de instancias de uma Optional.
	 * 
	 * 1-get -> se a optional estiver vazia lanca um NoSuchArgumentExecption,caso
	 * contrario retorna os valores
	 * 
	 * 2->ifPresent(Consumer c) -> se estiver empty nao faz nada, caso contrario
	 * executa o consumer com o valor
	 * 
	 * 3-isPresent() -> retorna false se estiver empty, ou true.
	 * 
	 * 4-orElse(T other) -> retorna o parametro tipo generico T se estiver empty, ou
	 * os valores
	 * 
	 * 5-orElseGet(Supplier) -> se estiver vazio retorna o resultado pela chamada de
	 * supplier.
	 * 
	 * 6-orElseThrow() -> lanca exception se estiver vazio, ou retorna os valores.
	 * 
	 * 7-orElseThrow(Supplier p) ->lanca a exception retornada,crida pelo supplier,
	 * ou os valores
	 * 
	 */

	public static void main(String[] args) {
		Optional<String> op = ops();
		op.ifPresent(System.out::println);
		System.out.println(op.get());
		System.out.println(op.orElseThrow());
		System.out.println(opsEmpty().orElseGet(() -> "orElseGet retorna o supplier"));
		System.out.println(opsEmpty().orElse("Este metodo retorna isso que passei"));
		System.out.println(opsEmpty().orElseThrow(() -> new IllegalArgumentException()));
	}

	public static Optional<String> ops() {
	
		return Optional.of("Nicholas");
	}

	public static Optional<String> opsEmpty() {
		return Optional.empty();
	}
}
