package com.nicholas.ocp;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapMethods extends SuperGenric {

	public static void main(String[] args) {
		NavigableMap<String, String> mymap = new TreeMap<String, String>();
		mymap.put("a", "2");
		mymap.put("B", "2");

		NavigableMap<String, String> mymap2 = mymap.tailMap("B", false);
		System.out.println(mymap2 + " " + mymap2.size());
		System.out.println(mymap + " " + mymap.size());
	}

}

class SuperGenric {
	List<? extends Number> li() {
		return null;
	}
}