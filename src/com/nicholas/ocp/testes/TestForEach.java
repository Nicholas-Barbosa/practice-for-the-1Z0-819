package com.nicholas.ocp.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestForEach {

	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<>();
		lista.add("Nicholas");
		lista.forEach(s -> {
			s = new String("barbosa");
		});
		System.out.println(lista);
	}
}
