package com.nicholas.ocp;

public class TesteEasy implements X1 {

	@Override
	public void bater() {
		// TODO Auto-generated method stub
		System.out.println("batendo na classe!");
	}

	public static void main(String[] args) {
		X1 x1 = new TesteEasy();
		x1.bater();
		
	}
}

interface X1 {
	default void bater() {
		System.out.println("Bater x1 na interface!");
	}
}