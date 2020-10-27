package com.nicholas.ocp.testes;

public class AnonymousClass {
	/*
	 * Caso especial da local class, não possui nome.
	 */
	public abstract class interf {
		abstract void m1();
	}

	public abstract interface Interfs {
		abstract void m1();
	}

	public void an() {
		interf in = new interf() {
			public void m1() {

			}
		};
		Interfs i3n = new Interfs() {
			
			@Override
			public void m1() {
				// TODO Auto-generated method stub

			}
		};
	}
}
