package com.nicholas.ocp.iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OCPReaderReadLine {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\reader.txt");
		File dest = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\writerLine.txt");

		try (BufferedReader reader = new BufferedReader(new FileReader(file));
				BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
			String i;

			while ((i = reader.readLine()) != null) {
				writer.write(i);
				writer.newLine();
				writer.write("Quebra de linha");
				writer.flush();

			}

		}
	}
}
