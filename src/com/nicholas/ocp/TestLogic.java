package com.nicholas.ocp;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TestLogic {

	private final Deque<String> nsuLidos = new ConcurrentLinkedDeque<>();

	private final Deque<String> nsuNaoLidos = new ConcurrentLinkedDeque<>();

	public static void main(String[] args) {
		TestLogic tesLogic = new TestLogic();
		// [000000000107295, 000000000107153, 000000000107552, 000000000107755,
		// 000000000107530, 000000000107506, 000000000107714, 000000000107841,
		// 000000000107268, 000000000107187, 000000000107503, 000000000107481,
		// 000000000107539, 000000000107742, 000000000107285, 000000000107531,
		// 000000000107597]
		tesLogic.nsuLidos.offer("000000000107295");
		tesLogic.nsuLidos.offer("000000000107153");
		tesLogic.nsuLidos.offer("000000000107597");

		tesLogic.nsuNaoLidos.offer("000000000107552");
		String firstNsuNaoLido = tesLogic.nsuNaoLidos.peekFirst();
		tesLogic.nsuLidos.removeIf(e -> e.compareTo(firstNsuNaoLido) > 0);
		System.out.println(tesLogic.nsuLidos.peekFirst());

		try {
			tesLogic.throwFirstException();
		} catch (Exception e) {
			System.out.println("excpetion!");
		}
	}

	public void throwFirstException() {
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
