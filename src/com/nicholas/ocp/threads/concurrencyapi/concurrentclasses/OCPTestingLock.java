package com.nicholas.ocp.threads.concurrencyapi.concurrentclasses;

import java.util.concurrent.Executors;

public class OCPTestingLock {

	public static void main(String[] args) {
//		Lock lock = new ReentrantLock();
//		System.out.println(lock.tryLock());
//		lock.unlock();
//		System.out.println(lock.tryLock());
//		lock.unlock();
//		new Thread(() -> System.out.println(lock.tryLock())).start();
//		;
		var myES = Executors.newSingleThreadExecutor();
		myES.submit(() -> {
			System.out.println("TASK1");
		}); // 1
		myES.submit(() -> System.out.println("TASK2"));// 2
	}
}
