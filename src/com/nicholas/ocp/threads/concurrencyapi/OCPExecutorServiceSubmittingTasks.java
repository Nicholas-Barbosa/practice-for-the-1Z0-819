package com.nicholas.ocp.threads.concurrencyapi;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class OCPExecutorServiceSubmittingTasks {

	public static void main(String[] args) {
		/*
		 * 1-void execute(Runnable r) -> Executa a runnable task
		 * 
		 * 2-Future<?>submit(Runnable r) -> Exceuta a runnable task e retorna uma
		 * instancia de Future como resultado
		 * 
		 * 3-<T>Future<T>submit(Callable<T>) -> Executa a callable task e retorna um
		 * Future.
		 * 
		 * 4-<T>List<Future<T>>invokeAll(Collection<? extends Callable) -> Executa a
		 * collection de tasks sincronamente, espera pelos resultados e retorna uma
		 * List. Onde cada Future e uma task.Mesma ordem da original collection
		 * 
		 * 5-V invokeAny(Collection<?extends Callable)-> Executa as tasks, espera por
		 * pelo menos uma terminar e retorna uma objeto.Alem de descartar as tasks nao
		 * terminadas.
		 * 
		 * Quando dizemos sincrono nos metodos invokeAny e invokeAll, siginifa que a JVM
		 * espera as tasks dessa thread terminar para ai sim voltar ao escopo do
		 * programa.
		 * 
		 */
		ExecutorService service = null;
		try {

			service = Executors.newSingleThreadExecutor();
			Runnable r1 = () -> System.out.println("executing runnable task");
			Callable<String> c1 = () -> {

				return "executing callable task";

			};

			service.execute(r1);
			System.out.println(service.submit(c1).get());
			System.out.println("A JVM ira espera as seguintes threads executarem para imprimer END!");
			List<String> results = service.invokeAll(List.of(c1, c1, c1, c1)).stream().map(x -> {
				try {
					return x.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toList());
			results.forEach(System.out::println);

			String anyResult = service.invokeAny(List.of(c1, c1, c1, c1, c1));
			System.out.println("Any result " + anyResult);
			System.out.println("END");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}
}
