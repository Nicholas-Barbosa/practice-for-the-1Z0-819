package com.nicholas.ocp;

import java.util.List;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;

public class DeadlockExa {
	public static void main(String[] args) {
		
		
		final DeadlockExa alphonse = new DeadlockExa("Alphonse");
		final DeadlockExa gaston = new DeadlockExa("Gaston");
		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(alphonse);
			}
		}).start();
	}

	private final String name;

	public DeadlockExa(String name) {
		super();
		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public void bow(DeadlockExa bower) {
		synchronized (this) {

			System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());

			synchronized (bower) {

				bower.bowBack(bower);
			}
		}
	}

	public void bowBack(DeadlockExa bower) {
		DoubleFunction<String> db = s -> s + "";
		System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());

	}

}
