package com.nicholas.ocp.threads.concurrencyapi.concurrentclasses;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class OCPSkipList {

	/*
	 * ConcurrentSkipListMap e ConcurrentSkipListSet, sao concurrent versions de
	 * TreeMap e TreeSet.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Map<Integer, String> properties = new ConcurrentSkipListMap<>();
		properties.put(1, "um");
		// properties.put(2, "dois");
		System.out.println(properties);
		for (Integer key : properties.keySet()) {

			properties.put(3, "tres");
			System.out.println("key " + key + " value " + properties.get(key));
		}
		System.out.println(properties);
		/*
		 * Observe, o java so itera nos elementos que foram criados junto com
		 * ele.Evitando assim o loop infinito.
		 */
		System.out.println("Vez do TreeSet");
		Set<Integer> in = new ConcurrentSkipListSet<>();
		in.add(1);
		in.add(2);
		for (Integer v : in) {
			in.remove(v);
			in.add(4);
		}
		System.out.println(in);
	}
}
