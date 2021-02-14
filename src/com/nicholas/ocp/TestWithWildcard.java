package com.nicholas.ocp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TestWithWildcard {

	public static void get(List<? extends IOException> lista) {
		FileNotFoundException file = (FileNotFoundException) lista.get(0);
	}

	public static void main(String[] args) {
		List<IOException> lista = new ArrayList<>();
		lista.add(new IOException());
		TestWithWildcard.get(lista);
		
	}

}
