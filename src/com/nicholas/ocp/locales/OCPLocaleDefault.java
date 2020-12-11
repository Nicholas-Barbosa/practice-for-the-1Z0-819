package com.nicholas.ocp.locales;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Locale.Category;

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
		double l = 90.9999;

		LocalDate local = LocalDate.now();

		System.out.println(local.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
				.withLocale(new Locale.Builder().setLanguage("en").build())));

		Locale.setDefault(Category.FORMAT,Locale.GERMANY);
		System.out.println(NumberFormat.getCurrencyInstance().format(l));

	}
}
