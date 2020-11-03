package com.nicholas.ocp.functinalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class OCPConsumerBi {

	/*
	 * Consumer e BiConsumer pegam 1 e 2 parametros respectivamente.
	 * 
	 * O accept retorna um void, usamos quando pegamos dois parametros e nao
	 * queremos retornar nada.
	 */

	public static void main(String[] args) {
		Consumer<String> c = System.out::println;
		c.accept("Nicholas");
		BiConsumer<String, String>c2 = (s1,s2) -> System.out.println("s1 " + s1 +" s2 " +s2);
		c2.accept("Nicholas", "Barbosa");
	}
}
