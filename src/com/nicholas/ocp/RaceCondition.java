package com.nicholas.ocp;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceCondition {

	private final List<Integer> list = new CopyOnWriteArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = null;
		RaceCondition race = new RaceCondition();

		try {
			executor = Executors.newCachedThreadPool();

			for (int i = 0; i <= 10; i++) {
				System.out.println(i);
				final int iP = i;
				executor.execute(() -> race.checkMap(iP));
			}

		} finally {
			System.out.println("fana;yy");
			executor.shutdown();
		}
		executor.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println(race.list);

	}

	public void checkMap(int i) {
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.add(i);
	}

}
