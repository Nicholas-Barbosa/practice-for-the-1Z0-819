package com.nicholas.ocp.security;

import java.util.HashSet;
import java.util.Set;

public class MainImmutableObject {

	public static void main(String[] args) {
		var objCities = new HashSet<>(Set.of("Rio de janeiro", "Floripa", "Curitiba", "Santos", "Pernambuco"));
		MyImmutableObject mmo = new MyImmutableObject("Nicholas", objCities);
		System.out.println(objCities == mmo.getCities());
		System.out.println();
		objCities.add("Salvador");
		System.out.println(objCities.size() + " " + mmo.getCitiesSize());
	}
}
