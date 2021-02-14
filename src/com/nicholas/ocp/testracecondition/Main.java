package com.nicholas.ocp.testracecondition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {

	private final Map<String, String> map = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8).parallel().peek(x -> System.out.println(x)).count());
	}

	public synchronized void empty() {
		if (map.isEmpty()) {
			System.out.println("Is empty");
			map.put("n", "not");
		}
	}

	public int makeThreads(int is) {
		System.out.println("Make threads!");
//		ExecutorService executor = null;
//		try {
//			executor = Executors.newCachedThreadPool();
//			for (int i = 0; i < 10; i++) {
//				executor.execute(() -> empty());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			executor.shutdown();
//		}
		return 0;
	}
}
