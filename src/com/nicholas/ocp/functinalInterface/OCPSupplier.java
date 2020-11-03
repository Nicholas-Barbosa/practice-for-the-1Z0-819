package com.nicholas.ocp.functinalInterface;

import java.time.LocalDate;
import java.util.function.Supplier;

public class OCPSupplier {
	/*
	 * Supplier e uma das interfaces funcionais padroes do java, ela possui get(),
	 * que pega um generico, que por convencao e denominado de T. Este generico e o
	 * retorno tipo do metodo.
	 * 
	 * Comumente usada para forncer,retornar valores.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		Supplier<LocalDate> s1 = LocalDate::now;
		Supplier<LocalDate> s2 = () -> LocalDate.now();
		System.out.println(s1.get().getDayOfMonth());
		System.out.println(s2.get().getDayOfMonth());
	}
}
