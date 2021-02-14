package com.nicholas.ocp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SupSuv {

	String s = this.toString();
	static int id = 90;

	void printName() {
		System.out.println("Barbosa");
	}

	public SupSuv() {
		printName();
	}

	<T extends Number> List<T> ls(T t) {

		return null;
	}

	public static void main(String[] args) {
		SupSuv sup = new Childse();
		System.out.println(sup.id);
		Object[] sa = { 100, 1000 };
		Collections.sort(Arrays.asList(sa), null);
		System.out.println(sa[0] + " " + sa[1]);
		String arr[] = { "a", "aa" };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}

class Childse extends SupSuv {
	static int id = 900;

	<T> List<T> ls(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	void printName() {
		System.out.println("Nicholas");
	}

}
