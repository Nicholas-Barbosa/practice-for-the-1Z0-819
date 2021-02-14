package com.nicholas.ocp;

import java.util.stream.Stream;

public class TestInstanceOf {

	public static void main(String[] args) {
		DadD child = new DadD();
		System.out.println(child instanceof Child);
		Stream.of(10, 1, 20).sequential().forEach(System.out::print);

	}
}

interface Dad {
}

class Child extends DadD implements Dad {
}

class DadD {
}