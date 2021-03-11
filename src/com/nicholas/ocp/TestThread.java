package com.nicholas.ocp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {

	public static void main(String[] args) {
		ExecutorService executor = null;
		try {
			executor = Executors.newSingleThreadExecutor();
			executor.submit(TestThread::executeThread);
			
		}finally {
			executor.shutdown();
			
		}
	}

	private static void executeThread() {
		ExecutorService executor = null;
		try {
			executor = Executors.newSingleThreadExecutor();
			executor.submit(() -> System.out.println("executeThread()"));

		} finally {
			executor.shutdown();
		}
	}
}
