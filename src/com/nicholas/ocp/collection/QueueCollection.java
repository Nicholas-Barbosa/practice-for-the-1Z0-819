package com.nicholas.ocp.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {

	/*
	 * Usamos queue para processar elementos em determinada ordem.
	 * 
	 * Normalmente na ordem FIFO(first-in,first-out) ou LIFO(last-in,last-out).
	 * 
	 * Implementacoes da Queue.
	 * 
	 * Unica,como ja visto a LinkedList. Alem da LinkedList ser uma List,ela e uma
	 * double-ended queue(Fila dupla), a vantagem de uma double-ended queue, e que
	 * ela pode adicionar, remover elementos tanto no inicio tanto no final da
	 * queue. A desvantagem e que ela pouca performatica com index arbitrarios.
	 * 
	 * Metodos da Queue.
	 * 
	 * boolean add(E element) Adiciona o elemento a queue e retorna true ou lanca
	 * uma exception.
	 * 
	 * E element() retorna o proximo elemento ou lanca um exception se a queue
	 * estiver vazia.
	 * 
	 * boolean offer(E element) Irmao do add, adiciona o elemento a qeue, retorna
	 * true ou false, mas nao lanca a exception.
	 * 
	 * E remove() retorna o elemento e remove esse elemento da queue ou lanca uma
	 * exception se a queue estiver vazia.
	 * 
	 * E poll() Irmao do remove,retorna o elemento e remove este elemento, mas nao
	 * lanca uma exception se a queue estiver vazia, mas sim null.
	 * 
	 * E peak() Irmao e element(), retorna o proximo elemento da queue, mas nao
	 * lanca uma exception se tiver vazia e sim um null.
	 */

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.add("Nicholas");
		queue.offer("Barbosa");

		System.out.println(queue.element());//Nicholas
		System.out.println(queue.peek());//Nicholas

		System.out.println(queue.poll());//Nicholas
		System.out.println(queue.remove());//Barbosa
		System.out.println(queue.poll());//null

		System.out.println(queue.peek());//null
		System.out.println(queue.element());// exception
	}
}
