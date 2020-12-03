package com.nicholas.ocp.iostreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OCPSystemIn {

	public OCPSystemIn() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*
		 * InputStream wrap um InputStream e convrte pra Reader
		 */
		try (var out = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.format("Ur message: %s", out.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
