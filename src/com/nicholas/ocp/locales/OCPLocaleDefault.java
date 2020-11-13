package com.nicholas.ocp.locales;

import java.text.NumberFormat;
import java.util.Locale;

public class OCPLocaleDefault {
	/*
	 * Ao chamadar setDefault(), opcoes de formatcacoes e exibicao de datas sao
	 * internamente selecionadas.
	 * 
	 * Se vc quiser ter um controle mais refinado, use Local.Category
	 * 
	 * Java subdivide opcoes de formatacoes em categorias distintas no Category
	 * enum.
	 * 
	 * Cetogory, e um elemento aninhao no Locale, que aceita formatacoes, exibicoes
	 * distintas. Para o exame precisamos saber dois valors enums.
	 * 
	 * DISPLAY -> Categoria usada para exibicao de data.
	 * 
	 * FORMAT->Categoria usada para formatacao de datas,numeros e currency.
	 * 
	 */

	public static void main(String[] args) {
		double l= 90.9999;
		Locale.setDefault(Locale.Category.FORMAT, Locale.CANADA);
		System.out.println(NumberFormat.getCurrencyInstance().format(l));
	}
}
