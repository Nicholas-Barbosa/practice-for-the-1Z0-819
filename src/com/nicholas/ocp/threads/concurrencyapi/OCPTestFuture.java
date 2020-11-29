package com.nicholas.ocp.threads.concurrencyapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class OCPTestFuture {

	public static void main(String[] args) throws Exception {
		ExecutorService exe = Executors.newSingleThreadExecutor();
		List<Future<?>> lista = new CopyOnWriteArrayList<>();
		IntStream.range(1, 10).forEach(x -> lista.add(exe.submit(OCPTestFuture::te)));
		List<String> sList = new ArrayList<String>();
		
		
		
		
		System.out.println(lista.get(0).get());
	}

	private static void te() {

	}
}
