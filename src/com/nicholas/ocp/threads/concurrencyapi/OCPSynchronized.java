package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OCPSynchronized {

	/*
	 * Como as classes atomicas executam somente single variaveis, ela fica inviavel
	 * se quisermos executar uma seria de comando ou chamadas de metodos.
	 * 
	 * Um solucao e usar monitor,tambem chamado de lock. Monitor e uma estrutura que
	 * suporta mutual exclusion,na qual e a propriedade de, no maximo uma thread ser
	 * executada num seguimento de codigo por vez.
	 * 
	 * Qualquer objeto pode ser monitor, adicionar o synchorinized keyword.
	 * 
	 * Se o lock estiver disponivel,a primeira thread ira entrar no block, acessando
	 * o lock ela previne de outras threads entrarem no mesmo lock.Enquanto a thread
	 * esta executando sua task no lock, todas as outras threads irao tentar entrar
	 * no mesmo lock e irao esperar a thread no lock terminar sua execucao. Somente
	 * quando a thread no lock termina sua execucao, ela "lanca" o lock para as
	 * outras threads.
	 */
	private static int i = 0;

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		try {
			for (int i = 0; i < 10; i++) {
				service.submit(OCPSynchronized::increment);
			}
		} finally {
			service.shutdown();
		}
	}

	synchronized private static void increment() {
		/*
		 * Observe, a proxima thread que na qual e aleatoria, ira esperar esta thread
		 * neste lock terminar(incrementar a variavel e reportar), para ai sim executar
		 * definitavamente sua task.
		 */
		System.out.println("incrementing i " + (++i));
		/*
		 * ou
		 * 
		 * synchronized(OCPSynchronized.class){...}
		 */
	}
}
