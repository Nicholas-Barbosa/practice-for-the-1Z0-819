package com.nicholas.ocp.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class OCPDates {

	/*
	 * Classes do java 11 para expressarmos datas, java.time.LocalDate -> data,
	 * 
	 * java.time.LocalTime -> hora
	 * 
	 * java.time.LocalDateTime -> dia e hora.
	 * 
	 * java.time.ZonedDateTime -> dia e hora numa zona especifica.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		System.out.println();
		var nowTime = LocalTime.now();
		System.out.println(nowTime);
		System.out.println("----OF Method----");
		var dataOf = LocalDateTime.of(2020, Month.NOVEMBER, 11, 23, 16);
		System.out.println(dataOf);
		/*
		 * Java usa o T para separar a data com a hora ao converter para string
		 */
		System.out.println("----DateTimeFormatter----");
		System.out.println(dataOf.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		/*
		 * System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_TIME));
		 * 
		 * Exception, tipos diferentes da problema. Estamos convertendo um localDate num
		 * localTimefi
		 */
		System.out.println(dataOf.format(DateTimeFormatter.ofPattern("dd 'de' MMM 'de' YYYY 'AS(T)' hh 'e' mm 'munutos'")));
		
	}
}
