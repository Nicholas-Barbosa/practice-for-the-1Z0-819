package com.nicholas.ocp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class FloatTest {

	public static void main(String[] args) {
		/*
		 * Dividir pontos flutuantes por zero retorna infinity ou negative_infinity.
		 * Valores integrais por zero retorna ArithmeticException
		 * 
		 */
		double f = (double) 10 / 0;
		System.out.println(f);

		Deque<Integer> d = new ArrayDeque<>();
		d.offer(1);
		d.offer(2);
		d.push(3);
		System.out.println(d.peek());
		System.out.println(d.peekFirst());
		System.out.println(d.element());

		/*
		 * push adiciona o elemento no inicio da queue, offer adiciona no fim da queue.
		 * Pop, offer, remove removem o primeirpo elemento da queue.
		 */
	}
}
