package com.nicholas.ocp.threads.concurrencyapi.concurrentclasses;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class OCPCopyOnWrite {

	/*
	 * CopyOnWriteArrayList e CopyOnWriteArraySet, funciona de uma forma diferente
	 * das outras concurrent classes.
	 * 
	 * Todas vez em que a collection e modificado, sendo assim um elemento e
	 * adicionado ou removido, todos os dados sao copiados para uma nova estrutura
	 * subjacente.
	 * 
	 * Modificado, significar mudar a referencia da collection.
	 * 
	 * Uma nova estrutrua subjacente e criada mas a referencia para o objeto
	 * collection, continua a mesma.
	 * 
	 * Por isso, estas classes consomem muita memoria, so use se vc estiver mais
	 * lendo do que escrevendo.
	 * 
	 */
	public static void main(String[] args) {
		List<String> lista = new CopyOnWriteArrayList<>();
		lista.add("Nicholas");
		lista.add("Barbosa");
		lista.forEach(x -> {
			lista.add("Cestari");
		});
		System.out.println(lista);
		System.out.println("---HashSet---");
		Set<String> hashSet = new CopyOnWriteArraySet<>();
		hashSet.add("Nicholas");
		hashSet.add("Cestari");
		hashSet.forEach(x -> hashSet.add("Barbosa"));
		System.out.println(hashSet);
	}

}
