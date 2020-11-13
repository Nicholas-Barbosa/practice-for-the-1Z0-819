package com.nicholas.ocp.numbers;

import java.text.NumberFormat;
import java.util.Locale;

public class OCPNumberFormat {

	/*
	 * NumbersFormat, podemos formatar muitas coisas, nunmeros,currency,etc.
	 * 
	 * metodos para criar uma instancia de NumberFormat.
	 * 
	 * NumberFormat.getInstance()/getInstance(Local l) -> proposito de formatacao
	 * geral,
	 * 
	 * NumberFormat.getNumberInstance()/getNumberInstance(Local l) -> mesma coisa de
	 * getInstance()
	 * 
	 * NumberFormat.getCurrencyInstance()/getCurrencyInstance(Locale l) ->
	 * formatacao para numeros monetarios
	 * 
	 * NumberFormat.getPercentInstance()/getPercentInstance(Locale l)->formatacao
	 * para porcentagens
	 * 
	 * NumberFormat.getIntegerInstance()/getIntegerInstance(Locale l) -> formatacao
	 * para numero decimais em inteiros
	 * 
	 * 
	 */

	public static void main(String[] args) {
		int n = 10;
		System.out.println("10 em china " + NumberFormat.getCurrencyInstance(Locale.ENGLISH).format(n));

	}
}
