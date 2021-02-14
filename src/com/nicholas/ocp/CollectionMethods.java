package com.nicholas.ocp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectionMethods {

	public static void main(String[] args) throws InterruptedException {
		NavigableMap<Integer, Integer> myMap = new TreeMap<>();
		myMap.put(1, 1);
		myMap.put(2, 2);
		myMap.put(3, 3);
		myMap.put(4, 4);
		Map<Integer, Integer> mySubMap = myMap.subMap(1, true, 4, true);
		Map<Integer, Integer> myTailMap = myMap.tailMap(1);
		mySubMap.replace(4, 900);
		myTailMap.put(6, 5);
		System.out.println(mySubMap);
		System.out.println(myTailMap);
		List<String> lista = new ArrayList<>();
		lista.add("1");
		lista.add("2");
		lista.add("3");
		List<String> myListView = lista.subList(0, 3);

		myListView.add("76");
		System.out.println(myListView);
	}

	public CollectionMethods() {

	}
}
