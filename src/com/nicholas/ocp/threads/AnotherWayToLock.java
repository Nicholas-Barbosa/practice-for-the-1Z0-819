package com.nicholas.ocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AnotherWayToLock {

	private void eatAndDrink(Lock lock, Food2 food, Water2 water) {
		try {
			lock.tryLock(10, TimeUnit.MINUTES);

			System.out.println("Adquiriu o lock " + Thread.currentThread().getName() + " ,sleep");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void drinkAndWater(Lock lock, Food2 food, Water2 water) {
		try {
			lock.tryLock(10, TimeUnit.MINUTES);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ExecutorService exe = null;
		Food2 food = new Food2();
		Water2 water = new Water2();
		AnotherWayToLock way = new AnotherWayToLock();
		AnotherWayToLock way2 = new AnotherWayToLock();
		try {
			/*
			 * Com parametro fairness, temos a previsibilidade de qual thread ira entrar no
			 * lock. Ja que este parametro setado como true,concede o lock a threads na
			 * ordem em que foi solicitado.
			 */
			Lock lock = new ReentrantLock(true);
			exe = Executors.newFixedThreadPool(10);
			for (int i = 0; i < 10; i++) {

				exe.execute(() -> way.eatAndDrink(lock, food, water));
				exe.execute(() -> way2.drinkAndWater(lock, food, water));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			exe.shutdown();

		}
	}
}

class Food2 {
}

class Water2 {
}