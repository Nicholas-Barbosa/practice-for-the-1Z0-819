package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OCPConcurrencyApi {

	/*
	 * O java fornece Concurrency Api para lidar com o trabalho complicado de
	 * administrar threads.ExecuterService interface, na qual defini servicos para
	 * criar e administrar threads para voce.
	 * 
	 * E recomendavel usar essa API a qualquer hora que vc precisa lidar com tarefas
	 * separadas, mesmo com single thread.
	 * 
	 * Peli fati de ExecutorSevice for uma interface, o java fornece a factory class
	 * Executors.
	 * 
	 * Factory pattern, e o padrao na qual os detalhes de implementacao do objeto
	 * sao omitidos de nos.
	 * 
	 * Pelo fato de ser uma unica thread, as tarefas sao executadas
	 * sequencialmentes.
	 */

	public static void main(String[] args)  {
		/*
		 * Quando criamos um thread executor, ele cria um no-deamon thread na primeira
		 * task.
		 * 
		 * Deamon thread, sao threads que nao previnam do programa terminar.
		 * 
		 * Se voce nao chamar o isShutDown(), seu programa ira correr pra sempre, ou ate
		 * seu pc nao aguentar mais.
		 * 
		 * O processo isShutDown(), involve primeiramente a rejeicao de qualquer nova
		 * task, enquanto ele continua a executar as tasks submetidas anteriormente.
		 * 
		 * Durante esse tempo, isShutdown() == true e isTerminated() == false
		 * 
		 * Quando todos as tarefas forem executadas e terminadas, ambos serao true!
		 * 
		 * Se voce enviar uma nova task para a thread,quando isShutdown, sera lancado
		 * RejectedExecutionException
		 * 
		 */
		ExecutorService threadExecuter = Executors.newSingleThreadExecutor();

		
		System.out.println("Begin");

		Runnable task1 = () -> {
			for (int i = 0; i < 1000; i++)
				System.out.println("task " + i);
		};
		threadExecuter.execute(task1);
		
		threadExecuter.execute(() -> System.out.println("executer2"));
		System.out.println("End");

		threadExecuter.shutdown();

	}
}
