package com.nicholas.ocp.threads.concurrencyapi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OCPTestWithCollections {

	private static Queue<Integer> queue = new LinkedList<>();
	private static Integer i = 0;
	static {
		queue = Stream.of(0, 1, 2, 3, 4, 5, 6, 7).collect(Collectors.toCollection(LinkedList::new));
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(6);
			for (int i2 = 0; i2 <= 5; i2++) {
				service.submit(OCPTestWithCollections::removeDaQueue);

			}

		} finally {
			/*
			 * Rejeita qualquer nova task enviada ao thread executor enquanto continua a
			 * executar as tasks ja enviadas
			 */
			service.shutdown();
		}
	}

	private synchronized static void removeDaQueue() {
		queue.remove(++i);
		System.out.println("queue elements " + queue);
	}
}
