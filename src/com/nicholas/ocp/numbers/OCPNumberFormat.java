package com.nicholas.ocp.numbers;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
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

	public static void main(String[] args) throws ParseException {
		double n = 10.3838;
		System.out.println("10 em china " + NumberFormat.getCurrencyInstance(Locale.ENGLISH).format(n));
		System.out.println(n + " em br " + NumberFormat.getCurrencyInstance().format(n));
		System.out.println(n + " em %% " + NumberFormat.getPercentInstance().format(n));
		System.out.println(n + " em inteiro " + NumberFormat.getIntegerInstance().format(n));
		/*
		 * Podemos criar nossas proprias formatacoes usando DecimalFormatter, seguintes
		 * caracteres modula a string produto do format()
		 * 
		 * # -> Omite posicoes onde nao ha numeros
		 * 
		 * 0 -> Poem zeros nas posicoes onde nao ha numeros
		 * 
		 * DecimalFormat extends NumberFormat
		 */
		System.out.println("----DecimalFormatter----");
		NumberFormat dc = new DecimalFormat("##.##");
		NumberFormat dc2 = new DecimalFormat("00.000");
		System.out.println("com # " + dc.format(1.55));
		System.out.println("com 0 " + dc2.format(1.55));
		System.out.println("----Parse----");
		/*
		 * Ao chamar um metodo como parse(), converte string num objeto ou primitivo.
		 * Ele leva o locale em consideracao.
		 */
		String example = "40.45";
		NumberFormat nm = NumberFormat.getInstance(Locale.FRANCE);
		System.out.println(nm.parse(example));

	}
}
