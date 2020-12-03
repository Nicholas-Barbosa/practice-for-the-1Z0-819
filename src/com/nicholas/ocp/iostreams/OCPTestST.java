package com.nicholas.ocp.iostreams;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class OCPTestST {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\tes", "systemIn.txt");
		try (var out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				var intp = new BufferedReader(new InputStreamReader(System.in))) {

			String lineToInsert = intp.readLine();
			out.write(lineToInsert);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// byteStreams();
	}

	private static void byteStreams() {
		File file = new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\tes", "systemIn.txt");
		try (var out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
				var intp = new BufferedReader(new InputStreamReader(System.in))) {

			int bits;
			while ((bits = intp.read()) != -1) {
				out.write(bits);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
