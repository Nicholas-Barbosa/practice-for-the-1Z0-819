package com.nicholas.ocp;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockOCP {

	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		ReadWriteLockOCP myClass = new ReadWriteLockOCP();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> myClass.readLock(lock)).start();
		}
		new Thread(() -> myClass.writeLock(lock)).start();
	}

	public void readLock(ReadWriteLock lock) {
		try {
			lock.readLock().lock();
			System.out.println("Locked for read aquired! Time of sleep!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println("Thread waked up!");
			}
		} finally {
			lock.readLock().unlock();
		}
	}

	public void writeLock(ReadWriteLock lock) {
		try {
			System.out.println("Trying to acquire lock for write!");
			lock.writeLock().lock();
			System.out.println("Locked for write aquired! Time of sleep!");

		} finally {
			lock.writeLock().unlock();
		}
	}
}
