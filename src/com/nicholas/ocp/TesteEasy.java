package com.nicholas.ocp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TesteEasy implements X1 {

	@Override
	public void bater() {
		// TODO Auto-generated method stub
		System.out.println("batendo na classe!");
	}

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		lock.unlock();

	}
}

interface X1 {
	default void bater() {
		System.out.println("Bater x1 na interface!");
	}
}