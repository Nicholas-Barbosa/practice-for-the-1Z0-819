package com.nicholas.ocp.threads.concurrencyapi.concurrentclasses;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class OCPBlockingQueue {

	/*
	 * BlockingQueue interface e como a interface Queue, exceto que ha overload
	 * metodos que esperar ate alguma operacao terminar.
	 * 
	 * BlockingQueue herda todos os metodos de Queue.
	 * 
	 * Metodos de BlockingQueue que esperam pela conclusao da operacao do metodo.
	 * 
	 * offer(element,long timeOut,TimeUnit t) -> Adiciona o elemento na queue e
	 * espera pelo timeOut, retorna false se o timeOut for atingido antes do espaco
	 * estiver disponivel.
	 * 
	 * poll(long timeOut,TimeUnit t) -> Retorna e remove o elemento na primeira
	 * posicao da queue, espera pelo timedOut e retorna null se o timedOut for
	 * atingido antes do item estiver disponivel
	 * 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		/*
		 * Pelo nome, o LinkedQueue usa um LinkedList entre o seus elementos
		 */
		BlockingQueue<String> queue = new LinkedBlockingDeque<>();
		System.out.println(queue.offer("Nicholas", 1, TimeUnit.SECONDS));
		System.out.println(queue.poll(1, TimeUnit.NANOSECONDS));
		System.out.println(queue);
	}
}
