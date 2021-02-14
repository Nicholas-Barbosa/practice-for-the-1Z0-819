package com.nicholas.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyAll {

	public static void main(String[] args) {
		ExecutorService executor = null;
		try {
			/*
			 * Thread pool e um grupo de threads reutilizaveis pre instanciadas que estao
			 * disponiveis para executar conjunto de tasks
			 */
			executor = Executors.newCachedThreadPool();

			List<Callable<String>> tasks = new ArrayList<Callable<String>>();
			for (int i = 0; i < 10; i++) {
				tasks.add(() -> new InvokeAnyAll().task());
			}
			String results = executor.invokeAny(tasks);
			System.out.println(results);
//			results.forEach(f -> {
//				try {
//					System.out.println(f.get());
//				} catch (InterruptedException | ExecutionException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}

	public synchronized String task() {
		try {
			System.out.println("Thread " + Thread.currentThread().getName() + " sleeping...");
			Thread.sleep(5000);
			System.out.println("Thread " + Thread.currentThread().getName() + " waked up");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "done " + Thread.currentThread().getName();
	}
}
