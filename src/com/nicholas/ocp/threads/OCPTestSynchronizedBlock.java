package com.nicholas.ocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OCPTestSynchronizedBlock {
	private static int i = 0;

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(2);
			A a = new A();
			service.execute(() -> increment(a));
			service.execute(() -> increment(a));
		} finally {
			service.shutdown();
		}
	}

	private static void increment(Object a) {
		synchronized (a) {
			i++;
			System.out.println("i " + i);
		}

	}
}

class A {
}

class B {
}
