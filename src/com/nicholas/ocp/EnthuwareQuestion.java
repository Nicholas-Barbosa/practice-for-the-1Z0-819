package com.nicholas.ocp;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

class Baap {
	public int h = 4;

	public int getH() {
		System.out.println("Baap " + h);
		return h;
	}
}

class Beta extends Baap {
	public int h = 44;

	@Override
	public int getH() {
		System.out.println("Beta " + h);
		return h;
	}
}

public class EnthuwareQuestion {
	public static void main(String[] args) {

		Baap b = new Beta();
		System.out.println(b.h + " " + b.getH());
		Beta bb = (Beta) b;
		System.out.println(bb.h + " " + bb.getH());

		AtomicInteger ai = new AtomicInteger();
		Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
		stream.forEach(s -> {
			System.out.println(ai.incrementAndGet());
		});
		System.out.println(ai);
	}
}