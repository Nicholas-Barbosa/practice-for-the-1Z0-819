package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OCPCyclicBarrier {

	/*
	 * Quando precisamos que tasks sejam realizadas sincronamente mas com multiplas
	 * threads, podemos usar o CyclicBarrier.
	 * 
	 * Por exemplo, temos 4 gaiolas para leoes que precisamos limpar. Primeiro, os
	 * leoes serao retirados de suas gaiolas.Depois, suas gaiolas serao limpadas e
	 * por fim os leoes serao adicionados novamente.Observe, estamos removendo leos
	 * em diferentes gaiolas, com multiplas threads.
	 * 
	 * No construtor da classe CyclicBarrier, passamos um valor especificando o
	 * numero de thrads a aguardar. A medida em que as threads vao terminando de
	 * executar suas tasks, vao chamando o metodo await(), elas entram em espera ate
	 * que todas as threads(perante ao numero passado no construtor, do
	 * CyclicBarrier) tambem chamam o await(), para liberar o barrier.
	 * 
	 * Por exemplo, temos 15 therads e o barrier suporta 5, o barrier sera chamado 3
	 * vezes quando todas as 5 threads chamarem o await().
	 * 
	 * Por isso, tenha ciencia do numero de threads no pool e no CycleBarrier. Outra
	 * coisa, tenha em mente de que o barrier pode levar um pouco de mais tempo, ja
	 * que threads esperar por outras threads.
	 */
	private static void removeLeao() {
		System.out.println("Removendo leao...");
	}

	private static void limpaGaiola() {
		System.out.println("limpando gaiola...");
	}

	private static void adicionaLeao() {
		System.out.println("adicionando leao...");
	}

	private static void executaTasks(CyclicBarrier c1) {
		try {
			removeLeao();
			c1.await();
			limpaGaiola();
			c1.await();
			adicionaLeao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExecutorService exe = null;
		try {
			exe = Executors.newFixedThreadPool(4);
			CyclicBarrier c = new CyclicBarrier(4);
			for (int i = 0; i < 4; i++) {
				exe.submit(() -> OCPCyclicBarrier.executaTasks(c));
			}
		} finally {
			exe.shutdown();
		}
	}
}
