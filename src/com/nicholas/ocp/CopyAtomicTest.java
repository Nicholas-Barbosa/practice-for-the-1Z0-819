package com.nicholas.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class CopyAtomicTest extends AB1 implements I1  {
	private Map<String, String> cal = new ConcurrentHashMap<>();

	private List<String> lista = Arrays.asList("1", "2", "3", "4", "5");
	private Integer i = 0;

	public void addData() {
		if (cal.isEmpty()) {
			System.out.println("map empty add");
			cal.putAll(lista.parallelStream().collect(Collectors.toConcurrentMap(x -> x, v -> v)));
		}
	}

	public static void main(String[] args) {
		CopyAtomicTest cp = new CopyAtomicTest();
		System.out.println(" " + "hello".length());
		System.out.println(Math.min(0, 10));
		ExecutorService exe = null;
		try {
			exe = Executors.newCachedThreadPool();
			for (int i = 0; i < 10; i++) {
				exe.execute(cp::addData);
			}
		} finally {
			exe.shutdown();
		}

	}
}
interface I1{
	static void t() {}
}abstract class AB1{
	static void t() {}
}