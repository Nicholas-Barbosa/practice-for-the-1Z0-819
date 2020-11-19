package com.nicholas.ocp.threads;

public class OCPThreadPolling {

	/*
	 * As vezes uma thread depende do resultado da outra para processar. Uma solucao
	 * e usar polling. Polling e um processo de checar datas num intervalo de tempo
	 * fixo.
	 * 
	 * Thread.sleep() implementa um polling. Ao usar este metodo no main(),a thread
	 * associada ao main ira pausar por x tempo definido no sleep, e a thread separa
	 * ira continuar. Ou seja, a current thread ira dormir por um numero especifico
	 * em milliseconds.
	 * 
	 * Lembre-se com polling ou sem polling, o resulta sera sempre indefinido.
	 * 
	 */
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Begin");

		Runnable task1 = () -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("i " + i);
				counter++;
			}

		};

		Runnable task2 = () -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("task2 " + i);
				counter++;
			}
		};
		new Thread(task1).start();

		new Thread(task2).start();
		/*
		 * Pedimos a thread main dormir 1 segundo enquanto a thread separada roda;
		 */
		Thread.sleep(1000);
		System.out.println("Counter " + counter);
	}
}
