package com.nicholas.ocp;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class ArrayEquals {

	public static void main(String[] args) {
		int[] firstArray = { 1, 2 };
		int[] secondArray = firstArray.clone();
		System.out.println(firstArray.equals(secondArray));
		
	}
}
