package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

	public static void main(String[] args) throws Exception {
		/*
		 * Quando criamos um thread executor, ele cria um no-deamon thread na primeira
		 * task.
		 * 
		 * Deamon thread, sao threads que nao irao prevenir da JVM sair quando o
		 * programa terminar. Se todas as threads que estao rodando no teu programa,
		 * forem deamon threads, seu programa ira terminar.
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
		 * RejectedExecutionException.
		 * 
		 * Enviando tasks. Metodos de ExecutorService para enviar tasks a thread.
		 * 
		 * 1-void execute(Runnable r) -> Executa task.
		 * 
		 * 2-Future<?>submit(Runnable r) -> Executa a runnable task e retorna um Future
		 * como resultado
		 * 
		 * 3-<T>Future<T>(Callable<T< c) -> Executa a callble task e retorna um
		 * Future<T>
		 * 
		 * 4-<T>List<Future<T>>invokeAll(Collection<? extends Callable>c) -> Executa as
		 * tasks da collection, espera todas completarem e retorna uma List<Future<>> na
		 * mesma ordem da original collection.
		 * 
		 * 5-><T>Future<T> invokeAny(Collection<? extends Callable>c) -> Executa todas
		 * as threads da collection, espera pelo menos uma terminar, discarta as
		 * restantes e retorna um Future.
		 * 
		 * Observe, o metodo execute() retorna um void ou seja null. Este metodo e
		 * conhecido como "fire-and-forget", pelo fato de vc executar a task mas nao ter
		 * nenhum retorno sobre ela.
		 * 
		 * Future Interface methodos.
		 * 
		 * 1-boolean isDone() -> Retorna true se as tasks foram completadas.
		 * 
		 * 2-boolean isCancelled() -> Retorna true se as tasks foram canceladas antes de
		 * serem concluidas.
		 * 
		 * 3-boolean cancell(...) -> Tenta cancelar as tasks, retorna true se conseguir
		 * ou false se nao conseguir ou as tasks ja foram concluidas.
		 * 
		 * 4-get() -> obtem o resultado da task mas espera por tempo inderteminado ate
		 * que a mesma esteja concluida.
		 * 
		 * 5-get(TimeUnit t,long timedOut)-> Obtem o resultado da task, espera por tempo
		 * especificado. Se o timedout for alacancado e a thread nao estiver pronta,
		 * throws TimedOutException
		 */
		ExecutorService threadExecuter = null;
		try {
			threadExecuter = Executors.newSingleThreadExecutor();

			System.out.println("Begin");

			Runnable task1 = () -> {
				for (int i = 0; i < 10; i++)
					System.out.println("task " + i);
			};
			Future<?> future = threadExecuter.submit(task1);

			threadExecuter.execute(() -> System.out.println("executer2"));
			/*
			 * Exception
			 */
			System.out.println("Task1 terminada " + future.get(1, TimeUnit.NANOSECONDS));
			System.out.println("End");

		} finally {
			threadExecuter.shutdown();
		}
	}
}
