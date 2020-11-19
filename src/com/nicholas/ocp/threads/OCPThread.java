package com.nicholas.ocp.threads;

public class OCPThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++)
			System.out.println("running " + i);

	}

	/*
	 * Um dos jeitos mais faceis de criar um thread, e usar java.lang.Thread class.
	 * 
	 * Seguimos duas etapas,
	 * 
	 * Para definir uma instancia da classe Thread que ira executar sua Task, ha
	 * duas formas.
	 * 
	 * 1->Fornecemos um objeto Runnable ou expressao lambda para o construtor da
	 * Thread
	 * 
	 * 2-> Extends Thread e override run method.
	 * 
	 * After all, call .start(); -> Cria a Thread
	 */

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Begin");
		
		Runnable run2 = () -> System.out.println("run2");
		new Thread(run2).start();
		
		new Thread(new OCPThread()).start();

		new OCPExtendsThread().start();
		
		System.out.println("END");
	}
}
