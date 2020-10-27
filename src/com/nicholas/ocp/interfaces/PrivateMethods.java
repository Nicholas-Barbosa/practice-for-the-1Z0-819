package com.nicholas.ocp.interfaces;

public interface PrivateMethods {

	/*
	 * Duas regras de definição
	 * 
	 * 1-Para ser private,deve ter private keyword e implementar um body
	 * 
	 * 2-Podem ser chamados por metodos de instancias(default ou outros privates)
	 * 
	 */
	
	private void m1() {
		
	}
	
	default void mk2() {
		m1();
	}
	
	static void mkS() {
		
	}
}
