package com.nicholas.ocp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestInputCharacterStreams {

	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new FileReader("C:\\Users\\Nicholas Henrique\\Documents\\test.txt"));
		try (reader) {
			reader.read();
		} finally {

		}
	}
}
