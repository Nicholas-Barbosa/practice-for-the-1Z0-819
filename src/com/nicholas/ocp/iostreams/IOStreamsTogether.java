package com.nicholas.ocp.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IOStreamsTogether {

	public static void main(String[] args) {
		ExecutorService executor = null;
		try {
			CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
			executor = Executors.newFixedThreadPool(2);
			executor.submit(IOStreamsTogether::log);
			Future<Nicholas> response = executor.submit(() -> IOStreamsTogether.performTasks(cyclicBarrier));
			System.out.println("Response " + response.get());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		executor.shutdown();

	}

	private static void log() {
		try (var writer = new PrintWriter(
				new BufferedWriter(new FileWriter("C:\\Users\\Nicholas Henrique\\Desktop\\myLog.txt")))) {
			System.out.println("Starting logging");
			writer.println("----Starting logging!----");
			writer.format("Session started with %s", "Nicholas").println();
			writer.append("I will pass 1Z0-819!").println();
			writer.format(Locale.GERMANY, "Lets go %s in %d", "Berlin", 2022).println();
			writer.println("Bye tchus Tchau! See u in Berlin!!!");
			writer.print("----End logging----");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Logging finished!");
		}
	}

	private static Nicholas performTasks(CyclicBarrier barrier) {
		try {
			serializeNicholas();
			barrier.await();
			return deserializeNicholas();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void serializeNicholas() {
		try (var ser = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream("C:\\Users\\Nicholas Henrique\\Desktop\\myObject.txt")))) {
			System.out.println("Starting serializing");
			Nicholas nicholas = new Nicholas("Nicholas", "83025330", 16, "Brazil");
			ser.writeObject(nicholas);
			ser.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Serializing finished!");
		}
	}

	private static Nicholas deserializeNicholas() {
		try (var deser = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("C:\\Users\\Nicholas Henrique\\Desktop\\myObject.txt")))) {
			System.out.println("Starting deserializing!");
			return (Nicholas) deser.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

			System.out.println("Deserializing finished!");
		}
		return null;
	}
}
