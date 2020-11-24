package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OCPLockFramework {

	/*
	 * Synchronized block suporta um conjunto limitado de funcionalidades.
	 * 
	 * A Concurrency API inclue a Lock Interface, que e conceitualmente semelhante
	 * ao synchorinized.
	 * 
	 * Sua implementacao(service provider) e a ReentantLock, que e uma classe
	 * simples que suporta mutual exclusion(synchronized) e implementa a interface
	 * Lock.
	 * 
	 * 
	 * 
	 * Metodos de Lock
	 * 
	 * 1-lock() -> Solicita um lock e bloqueia ate que o mesmo seja obtido.
	 * 
	 * 2-unLock() -> Relase o lock.
	 * 
	 * 3-tryLock() -> Solicita o lock e retorna imediatamente. Nao espera pelo lock,
	 * se outra thread ja o pegou. Retorna um boolean definindo o resultado.
	 * 
	 * 4-tryLock(long time,TimeUnit t) -> Versoa hibrida de lock() e tryLock(),como
	 * no tryLock() ele solicita a lock e retorna um boolean, mas como no lock ele
	 * espera se o lock estver sendo usado por outra thread.
	 * 
	 * A Lock interface, mantem um contado de lock, ou seja, deve haver o mesmo
	 * numero de unLock() perante a lock().
	 * 
	 * Lock tem algumas features adicionais em relacao ao synchroinized.
	 * 
	 * 1-Abilidade para solictar um lock sem block.
	 * 
	 * 2-Abilidade para solicitar um lock e espera por um tempo especificado.
	 * 
	 * 3-O lock pode ser criado com a propriedade boolean fairness, nao qual define
	 * que o lock sera alocado para as threads na ordem em que foram enviadas.
	 * 
	 * Deve haver o lock antes do codigo protegido e o unLock() antes de sair do
	 * codigo protegido.
	 */
	private static int i = 0;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		Lock lock = new ReentrantLock(true);
		try {

			for (int i = 0; i < 10; i++) {
				executor.submit(() -> OCPLockFramework.increment(lock));
			}
		} finally {
			executor.shutdown();

		}
	}

	private static void increment(Lock lock) {

		try {
			System.out.println(lock.tryLock(10, TimeUnit.SECONDS));
			System.out.println("incrementing i " + (++i));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();

		}

	}
}
