package com.nicholas.ocp.threads.concurrencyapi.concurrentclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OCPSynchronizedCollectionMethods {

	/*
	 * Caso queria transformar uma collection ja existente, e uma concurrent
	 * collection, use os metodos synchronized definidos na propria classe
	 * Collections.
	 * 
	 * Estes metodos operam na collection dado e retornam uma referencia do mesmo
	 * tipo da collection subjacente
	 * 
	 */

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		List<String> concurrent = Collections.synchronizedList(lista);
		for (int i = 0; i < 10; i++) {
			lista.add("element " + i);
		}
		concurrent.forEach(x -> concurrent.add("Nicholas"));
		/*
		 * Ainda e lancado uma ConcurrentModificationExecption, diferente das concurrent
		 * classes
		 */
	}
}
