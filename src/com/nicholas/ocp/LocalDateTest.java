package com.nicholas.ocp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {

	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")));
		String dataStr = "2020-11-11 12:20";
		System.out.println(LocalDateTime.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")));
	}
}
