package com.nicholas.ocp.dates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class OCPDateTimeFormatter {

	/*
	 * Metodos para criar um DateTimeFormatter.
	 * 
	 * ofLocalizedDate(style) -> formatar data.
	 * 
	 * ofLocalizedTime(style) formatar hora.
	 * 
	 * ofLocalizedDateTime(dateStyle,timeStyle) -> formatar date e time.
	 * 
	 * ambos os metodos pegam um FormatStyle, alem de pegar a current locale.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(data.format(dt));
	}
}
