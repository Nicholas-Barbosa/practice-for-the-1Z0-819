package com.nicholas.ocp.iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OCPTestCharacterStreams {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\reader.txt");
		File dest = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\writer.txt");

		char buffer[] = new char[1024];

		try (BufferedReader reader = new BufferedReader(new FileReader(file));
				BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
			int i;

			System.out.println((i = reader.read(buffer, 10, 16)));
			writer.write(buffer, 10, 2);
			
		}
	}
}
