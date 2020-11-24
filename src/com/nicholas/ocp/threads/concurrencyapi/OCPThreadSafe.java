package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class OCPThreadSafe {

	/*
	 * Thread safety, refere-se a propriedade na qual o objeto garante que nao ira
	 * ocorrer interferencias de outras threads num determinado processo.
	 * 
	 * Por exemplo, estamos usando uma thread pool para incrementar uma variavel.
	 * Pelo fato de duas ou mais threads estiverem realizando uma operacao,uma
	 * thread ira ler o valor antigo sem a outra thread escrever o novo valor.
	 * 
	 * Isso se torna redundante, ja que duas threads estao atribuindo a uma mesma
	 * variavel, alem de uma estar sobre escrevendo o resultado da outra.
	 * 
	 * A operacao increment nao e thread safe, podemos usar atomic classes para
	 * isso.
	 * 
	 * Atomic significa,uma operacao ser realizada como single unit of execution,
	 * onde nao ha interferencias de outras threads.
	 * 
	 * Qualquer thread que tentar interferir,ira aguardar.
	 * 
	 * AtomicBoolean -> Valor boolean que pode ser autualizado automaticamente
	 * 
	 * AtomicInteger -> Valor int que pode ser atualizado automaticamente
	 * 
	 * AtomicLong -> Valor long que pode ser atualizado automaticamente.
	 * 
	 * Metodos para essas classes.
	 * 
	 * get() -> recupera o current value.
	 * 
	 * set() -> semelhante ao =
	 * 
	 * setAndGet() -> Seta automaticamente o valor e retorna o valor antigo.
	 * 
	 * incrementAndGet() -> Semelhante ao pre increment
	 * 
	 * getAndIncrement() -> Semelhante ao pos incremento.
	 * 
	 * decrementAndGet() -> Semelhante ao pre decremento.
	 * 
	 * getAndDecrement() -> Semelhante ao pos decremento.
	 */
	static AtomicInteger count = new AtomicInteger(0);

	private int sheepCount = 0;

	public void incrementAndReport() {
		++sheepCount;
		
	}

	public static void main(String[] args) {
		/*
		 * Como alguma thread tem que lidar com a operacao atomicamente, duas irao
		 * incrementar e sobre escrever o valor da outra.
		 */
		ExecutorService executers = Executors.newCachedThreadPool();
		try {

			OCPThreadSafe tSafe = new OCPThreadSafe();
			IntStream.range(0, 1000).forEach(x -> executers.submit(tSafe::incrementAndReport));
			IntStream.range(0, 1000).forEach(x -> executers.submit(count::incrementAndGet));
			executers.submit(() -> System.out.println("oie"));
			System.out.println("with atomic " + count.get());
			System.out.println("no atomic " + tSafe.sheepCount);
			System.out.println("END");
			/*
			 * No atomic, as threads estao lendo sem esperar a outra thread escrever. Estao
			 * passando por cima uma da outra, overwriting o resultado.
			 */
		} finally {
			executers.shutdown();
		}
	}
}
