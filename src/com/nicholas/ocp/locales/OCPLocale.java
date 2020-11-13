package com.nicholas.ocp.locales;

import java.util.Locale;

public class OCPLocale {

	public static void main(String[] args) {
		/*
		 * 
		 * Primeiro temos o codigo da lingua em minusculo, segundo codigo do pais em
		 * maiusculo.
		 * 
		 * Codigo da lingua e requirido mas do pais e opcional.
		 */
		System.out.println("----Criando locale a partir de um construtor----");
		System.out.println(new Locale("en", "EN"));
		System.out.println("----Pegando current locale----");
		System.out.println(Locale.getDefault());
		System.out.println("----Locale com metodo statico----");
		System.out.println(Locale.CHINA);
		System.out.println("----Locale com Builder pattern----");
		System.out.println(new Locale.Builder().setRegion("EN").setLanguage("en").build());
		System.out.println("----Default() setando o default()----");
	
		Locale.setDefault(Locale.US);
		System.out.println(Locale.getDefault());
	}
}
