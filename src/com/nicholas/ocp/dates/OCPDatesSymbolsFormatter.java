package com.nicholas.ocp.dates;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class OCPDatesSymbolsFormatter {

	/*
	 * Simbolos comuns ao trabalhar com datas
	 * 
	 * Y -> ano
	 * 
	 * M->mes
	 * 
	 * d->dia
	 * 
	 * h->hora
	 * 
	 * m->miunutos
	 * 
	 * s->segundos
	 * 
	 * a->am/pm
	 * 
	 * z-> time zone name
	 * 
	 * Z-> time zone offset.
	 * 
	 * Alguns simbolos sao aplicados unicamenta a algumas classes.
	 * 
	 * LocalDate -> Y,m e d
	 * 
	 * LocalTime ->h,m,s
	 * 
	 * LocalDateTime -> y,d,M,h,m,s
	 * 
	 * ZonedDateTime -> y,M,d,h,m,s,z,Z
	 * 
	 * As classes com data/time, possuem um metodo chamado format(DateTimeFormatter)
	 * e que pega um formatter, enquanto o formatter tbm possui o metodo format que
	 * pega uma local
	 * 
	 */

	public static void main(String[] args) {
		var data = LocalDate.now();
		var formatter = DateTimeFormatter.ofPattern("d 'de' MMM 'de' YYYY");
		System.out.println("com .format " + data.format(formatter) + " formatter.format() " + formatter.format(data));
		System.out.println();
		/*
		 * Lembre-se de usar simbolos suportados por cada classe, o seguinte nao
		 * executa.Estamos usando m no lugar de M.
		 */
		var formatterErrado = DateTimeFormatter.ofPattern("d 'de' m 'de' YYYY");
		System.out.println(formatterErrado.format(data));
	}
}
