package com.nicholas.ocp.streams.parallel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OCPParallelStreams {
	/*
	 * Ate agora trabalhamos com serial streams.Serial stream e uma stream na qual
	 * os resuultados sao ordenados, sendo uma entrada processada por vez.
	 * 
	 * Parallel stream e uma stream que e capaz de processar resultados
	 * concorrentemente.Parallel stream pode mexer e muito com a performance de sua
	 * aplicacacao, mas tambem mexe com a ordem dos resultados.
	 * 
	 * Parallel Decompostion, processo na qual as tasks sao qeubradas em pequenos
	 * pedacos que podem ser processadas concorentemente, depois sao montadas
	 * novamente
	 * 
	 */

	public static void main(String[] args) {
		/*
		 * Metodos que dependem da ordem, tem os mesmos resultados tanto num serial
		 * stream tanto num parallel stream.Claro, eles sao menos performaticos.
		 */
		ExecutorService pooledExecutor = null;
		try {
			pooledExecutor = Executors.newFixedThreadPool(2);

			pooledExecutor.execute(OCPParallelStreams::executeSerial);

			pooledExecutor.execute(OCPParallelStreams::executeParallel);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			pooledExecutor.shutdown();
		}

	}

	private static void executeParallel() {
		/*
		 * Tanto o map quanto o allMatch sao aplicados concorrentemente.
		 * 
		 * Stream pipeline num parallel stream, e equivalente a mandar multiplas
		 * runnable tasks a um pooled thread executor, ja que os resultados das
		 * opearacoes pipelines nao sao ordenadas e nem previsiveis
		 */
		long startParallel = System.currentTimeMillis();
		List.of(1, 2, 3, 4, 5).parallelStream().map(x -> OCPParallelStreams.doWork(x)).allMatch(x -> x < 10);
		long taken = (System.currentTimeMillis() - startParallel) / 1000;
		System.out.println("Time parallel stream: " + taken + " seconds!");

	}

	private static void executeSerial() {
		long start = System.currentTimeMillis();
		List.of(1, 2, 3, 4, 5).stream().map(x -> OCPParallelStreams.doWork(x)).allMatch(x -> x < 10);
		long taken = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Time serial stream: " + taken + " seconds!");
	}

	private static int doWork(int input) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return input;
	}
}
