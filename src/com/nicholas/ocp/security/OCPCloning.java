package com.nicholas.ocp.security;

import java.util.ArrayList;
import java.util.Set;

public class OCPCloning {

	/*
	 * Interface cloneable no java, permite que voce clone os objetos, por default e
	 * realizado uma shallow copy,ou seja, somente os top-level objects e primitivos
	 * sao clonados. Nenhum novo objeto dentro do objeto clonado, sera criado. Isto
	 * ajuda a realizar uma defensive copy.
	 * 
	 * Caso queira uma deep copy, de override no metodo copy().
	 * 
	 * Se a tua classe nao implementar cloneable, sera chamada o clone() do object e
	 * sera lancada uma exception!
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		StringBuilder myName = new StringBuilder("Nicholas");
		var objCities = new ArrayList<>(Set.of("Rio de janeiro", "Floripa", "Curitiba", "Santos", "Pernambuco"));
		CloningPojo mmo = new CloningPojo(myName.toString(), objCities, myName);
		CloningPojo mmClones = mmo.clone(myName.toString(), myName);
		System.out.println(mmo == mmClones);
		mmo.addCities("Salvador");
		mmo.appendSt("Barbosa");
		System.out.println(mmo.getCitiesSize() + " clone " + mmClones.getCitiesSize());
		System.out.println(mmo.getString() +" "+mmClones.getString());
	}

}
