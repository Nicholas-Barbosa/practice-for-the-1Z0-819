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
		Runnable myRunnable = () -> {
			for (int i = 0; i < 10; i++)
				System.out.println("i " + i);
			counter++;
		};

		new Thread(myRunnable).start();
		/*
		 * Pedimos a thread main dormir 1 segundo enquanto a thread separada roda;
		 */
		Thread.sleep(100);
		System.out.println("Counter " + counter);
	}
}
