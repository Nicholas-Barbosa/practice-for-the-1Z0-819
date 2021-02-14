package com.nicholas.ocp;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreads {

	public static void main(String[] args) {
		ScheduledExecutorService executor = null;

		try {
			executor = Executors.newScheduledThreadPool(10);
			ScheduledFuture<?> s = executor.scheduleWithFixedDelay(() -> new ScheduledThreads().task(), 1, 2,
					TimeUnit.SECONDS);
			System.out.println(s.get());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}

	}

	public String task() {
		try {

			System.out.println("Thread " + Thread.currentThread().getName() + " sleeping...");
			Thread.sleep(5000);
			System.out.println("Thread " + Thread.currentThread().getName() + " waked up");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "done";
	}
}
