package com.nicholas.ocp.threads;

public class Concepts {

	/*
	 * Uma thread e a menor unidade que pode ser agendada pelo sistema operacional.
	 * 
	 * Process, e um grupo de threads associadas num share enviroment.
	 * 
	 * Single-thread process - > Processo com um unico thread
	 * 
	 * Multithreading process -> Processos com uma ou mais threads.
	 * 
	 * Quando dizemos share enviroment, signifa que threads num mesmo processo
	 * compartilham memorias e se comunicam entre si.
	 * 
	 * Task -> Single unit of work executada por uma thread.
	 * 
	 * Type of Threads
	 * 
	 * System Thread -> Criada pela JVM, e executada em background da sua aplicacao.
	 * Por exemplo, garbage collector usado pelo uso de memoria da sua aplicacao.
	 * 
	 * Quando o system thread encontra um problema e nao pode se recuperar, e
	 * lancado um Error.
	 * 
	 * User defined thread -> Sao aquelas threads definidas pelo usuario.
	 * 
	 * Pelo fato de houver varias threads, o sistema operaciona usa o thread
	 * scheduler para determinar qual thread executar.
	 * 
	 * Thread scheduler pode empregar um robin roudin schedule, que na qual cada
	 * thread recebe um numero igual de ciclos do CPU para executar numa ordem
	 * circular.Exemplo, 10 threads recebem 100miliseconds, quando a utilma terminar
	 * volta pra primeira.
	 * 
	 * Caso o tempo acabe(numero de ciclos do CPU) e thread nao finalizou sua
	 * tarefa, um switch context ocorre.
	 * 
	 * Swicth context e o processo de armazenar o estado atual da thread e depois
	 * restaurar para continuar a execucao. Claro que isso e custoso!!
	 * 
	 * Por fim, uma thread pode interromper outra Thread ou substitui-la, se a mesma
	 * tiver prioridade de therad maior que a outra.
	 * 
	 * Thread priority e um valor numerico associado a thread que e levado em
	 * consideracao pelo thread scheduler.
	 */
}
