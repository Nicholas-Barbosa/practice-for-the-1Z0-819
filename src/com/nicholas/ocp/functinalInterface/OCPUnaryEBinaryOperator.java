package com.nicholas.ocp.functinalInterface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OCPUnaryEBinaryOperator {

	/*
	 * Estas duas interfaces, sao um caso especial de BiFunction. UnaryOperator<T>
	 * extends Function<T,R>
	 * 
	 * BinaryOperator<T> extends BiFunction<T>
	 * 
	 * E requirido que retorno de seu metodo apply(T) seja do mesmo tipo do
	 * parametro. Entao passou String como generic, o retorno deve ser String!
	 */

	public static void main(String[] args) {
		BinaryOperator<String> s = String::concat;
		System.out.println(s.apply("n", "n"));
		UnaryOperator<String> up = String::toUpperCase;
		System.out.println(up.apply("nicholas"));
	}
}
