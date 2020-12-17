package com.nicholas.ocp.security;

import java.util.ArrayList;
import java.util.Set;

public final class CloningPojo implements Cloneable {

	private final String name;
	private final ArrayList<String> cities;
	private final StringBuilder string;

	public CloningPojo(String name, ArrayList<String> cities, StringBuilder stringBuilder) {
		super();
		this.name = name;
		/*
		 * Defensive copy,pois a copy e feit caso o outro codigo faca algo inesperado.
		 * Como direcao defensiva.
		 */
		this.cities = new ArrayList<>(cities);
		this.string = new StringBuilder(stringBuilder);
	}

	public String getName() {
		return name;
	}

	public Set<String> getCities() {
		return Set.copyOf(cities);
	}

	public int getCitiesSize() {
		return this.cities.size();
	}

	public void addCities(String city) {
		this.cities.add(city);
	}

	public StringBuilder getString() {
		return new StringBuilder(string);
	}

	public void appendSt(String word) {
		this.string.append(word);
	}

	protected CloningPojo clone(String name, StringBuilder string) throws CloneNotSupportedException {
		@SuppressWarnings("unchecked")
		ArrayList<String> cloned = (ArrayList<String>) cities.clone();
		return  new CloningPojo(name, cloned, string);
	}
}
