package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OCPExecutors {

	/*
	 * Metodos da factory class Executors, para se ter uma instancia de
	 * ExecutorService/ScheduledExecutorService
	 * 
	 * 1-ExecutorService new SingleThreadExecutor() -> Cria um single thread
	 * executor que usa uma single worker thread operando numa queue ilimitada,
	 * queue de tasks.Tasks sao processadas na ordem em que foram enviadas.
	 * 
	 * 2-ScheduleExecutorService newSingleThreadScheduledExecutor() -> Cria uma
	 * single thread executor que suporta scheduled tasks.
	 * 
	 * 3-ExecutorService newCachedThreadPool() -> Cria um thread pool de tamanho
	 * dinamico, onde sao alocadas novas therads de acordo com a necessidade. Por
	 * exemplo, todas as threads estao ocupadas processando outras tasks ou
	 * realmente nao ha nenhuma thread.
	 * 
	 * 4-ExecutorService newFixedThreadPool(int) -> Cria um thread pool de tamanho
	 * fixo, numero de threads de acordo com o numero especificado.
	 * 
	 * 5-ScheduledExecutorService newScheduledPool(int) -> Indentico ao
	 * fixedThreadPool, exceto por aceitar threads que suportam
	 * agendamentos(ScheduledThreadExecutor)
	 * 
	 * Quando um pool fica sem threads disponiveis, as tasks sao interrompidas ate
	 * que se haja threads disponiveis.
	 * 
	 * Quando ha mais threads disponiveis que tasks, as tasks sao executadas
	 * concorrentemente.
	 * 
	 * Lembrando que thread pool e um conjunto de threads reutilizaveis pre
	 * instanciadas, que quando disponiveis, executam tasks.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(2);
			service.execute(() -> {
				for (int i = 0; i < 200; i++) {
					System.out.println(i);
				}
			});

			service.execute(() -> System.out.println("available -> " + Runtime.getRuntime().availableProcessors()));
		} finally {
			service.shutdown();
		}
	}
}
