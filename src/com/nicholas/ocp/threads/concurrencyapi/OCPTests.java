package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OCPTests {

	private static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) {
		ExecutorService thread = Executors.newFixedThreadPool(2);
		for (int i = 0; i <= 10; i++) {
			thread.execute(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(count.getAndIncrement());
			});
			System.out.println("Before thread");
		}
		thread.shutdown();
	}
}
