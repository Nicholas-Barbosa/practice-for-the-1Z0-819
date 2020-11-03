package com.nicholas.ocp.collection;

import java.util.Comparator;

public class TestGeneric<T> {

	T t;

	public TestGeneric(T t) {
		this.t = t;
	}

	public String toString() {
		return t.toString();
	}

	private <T> void println(T message) {
		System.out.print(t + "-" + message);
	}

	public static void main(String[] args) {
		new TestGeneric<String>("hi").println("1");
		new TestGeneric<String>("hola").<Boolean>println(true);
	}
}
