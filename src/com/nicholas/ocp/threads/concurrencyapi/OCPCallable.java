package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class OCPCallable {

	/*
	 * Callable como a Runnable e um interface funcional, possuindo um metodo
	 * call().
	 * 
	 * Este metodo retorna um valor e lanca uma checked exception.
	 * 
	 * Sendo assim, o get do future ira retornar algo diferente de null, diferente
	 * do Runnable que sempre retornava null.
	 * 
	 * Prefirivel usar callable inves de Runnable, pois seu metodo abstrato retorna
	 * algo rastreavel.
	 */

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService thread = null;
		try {
			thread = Executors.newSingleThreadExecutor();
			Future<Integer> f = thread.submit(() -> 10 + 10);
			System.out.println(f.get());
			System.out.println(f.isDone());
			System.out.println(f.isCancelled());

			/*
			 * Espera por um dia inteiro!!!!
			 * 
			 * System.out.println("terminated: " + thread.awaitTermination(1,
			 * TimeUnit.DAYS));
			 */

		} finally {
			thread.shutdown();
		}
		System.out.println("terminated: " + thread.awaitTermination(1, TimeUnit.DAYS));
		/*
		 * Forma de voce saber se as tarefas foram concluidas sem pegar o resultado das
		 * mesmas.
		 * 
		 * awaiTermination retorna true se as tarefas forem terminadas, ele espera pelo
		 * timeOut. Se for definido antes do shutDown(), ele espera pelo todo timeout
		 */
	}
}
