package com.nicholas.ocp.threads.concurrencyapi;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OCPScheduleExecutorService {

	/*
	 * Esta interface de therads, serve para executar tarfeas repetidamente no
	 * futuro. Similar a ExecutorService interface, ela pode pegar uma instancia com
	 * Executors factory class.
	 * 
	 * Metodos para criar executar uma task como ScheduleExcecutorService.
	 * 
	 * 1-schedule(Runnable r, long delay, TimeUnit t) -> Executa a runnable task
	 * apos o delay especificado.
	 * 
	 * 2-schedule(Callable c, long delay, TimeUnit t) -> Executa a callable task
	 * apos o delay especifado.
	 * 
	 * 3-scheculeAtFixedRate(Runnable r,long initialDelay,long period) -> Executa a
	 * runnable task apos o delay especificado, cria e executas novas tasks durante
	 * o periodo, independente se as tasks anteriores foram concluidas.
	 * 
	 * 4->scheduleWithFixedDelay(Runnable r,long initialDelay,long delay) -> Executa
	 * a task apos o delay inicial, posteriormente executa de novo com um delay
	 * entre a ultima a executar e a nova a executar. Ou seja, delay entre
	 * execucoes.
	 * 
	 * Se uma task executar as 12pm e demorar 5 minutos e o delay entre execucoes
	 * for de 2 minutos, ela ira executar de novo as 12:07pm
	 * 
	 * Este mesmo exemplo com atFixedRate, comecaria as 12pm, executaria de novo as
	 * 12:05, independente se a task anterior terminou ou nao.
	 * 
	 * Ou seja, fixedRate executa a task a cada periodo, certo. Enquanto
	 * withFixedDelay executa com um delay entre o termino da ultima.
	 * 
	 * Observacao, executa tudo junto. A jvm nao espera executar uma task pra voltar
	 * no escopo da aplicacao como no ExecutorService.
	 * 
	 * 
	 */

	public static void main(String[] args) {

		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService executor2 = Executors.newSingleThreadScheduledExecutor();
		Runnable task2 = () -> {

			System.out.println("Executing the task2 fixedRate!");

		};

		Runnable task3 = () -> {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Executing the task3 fixedDelay!");
		};
//		executor.schedule(task, 1, TimeUnit.MINUTES);
//		executor.submit(() -> System.out.println("teste "));
		executor.scheduleAtFixedRate(task2, 0, 1, TimeUnit.SECONDS);
		executor2.scheduleWithFixedDelay(task3, 0, 1, TimeUnit.SECONDS);

	}
}
