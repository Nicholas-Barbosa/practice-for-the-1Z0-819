package com.nicholas.ocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Food {
}

class Water {
}

public class OCPLiveness {
	/*
	 * Liveness e a capacidade de uma aplicacao ser executada em tempo habil.
	 * 
	 * Entao liveness probomes sao aqueles cujo a aplicacao trava ou nao responde.
	 * 
	 * Deadlock -> Ocorre quando duas ou mais threads estao bloqueadas para sempre,
	 * uma esperando a outra.
	 * 
	 * Starvation -> Ocorre quando uma unica thread esta para sempre banida de
	 * acessar um recurso compartilhado ou um lock.Ela ainda esta ativa mas nao
	 * consegue completar seu trabalho porque uma outra thread esta acessando um
	 * recurso constantemente.
	 * 
	 * Livelock -> Ocorre quando duas ou mais threads estao conceitualmente
	 * bloqueadas, no entando elas ainda estao ativas tentando completar seu
	 * trabalho. Caso especial de starvation onde duas ou mais threads estao
	 * tentando adquirir um lock e nao conseguem,recomecando o processo.
	 * 
	 * Este problema e muito comum ao tentar resolver deadlock
	 * 
	 */

	private void eatAndDrink(Food food, Water water) {
		synchronized (food) {
			System.out.println("got food!");

			move();
			synchronized (water) {
				System.out.println("got water!");
			}
		}
	}

	private void drinkAndEar(Food food, Water water) {
		synchronized (water) {
			System.out.println("got water!");

			move();
			synchronized (food) {
				System.out.println("got food!");
			}
		}
	}

	private void move() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Food food = new Food();
		Water water = new Water();
		OCPLiveness foxy = new OCPLiveness();
		OCPLiveness tails = new OCPLiveness();
		ExecutorService executor = null;
		try {
			executor = Executors.newScheduledThreadPool(10);
			executor.submit(() -> foxy.eatAndDrink(food, water));
			executor.submit(() -> tails.drinkAndEar(food, water));
		} finally {
			executor.shutdown();
		}
	}
}
