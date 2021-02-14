package com.nicholas.ocp;

import java.util.HashMap;
import java.util.Map;

public class MapMethods {

	static class aS {
	}

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "um");
		map.put(2, "dois");
		map.put(3, "tres");
		map.computeIfPresent(1, (x, y) -> x + "" + y);
		map.computeIfAbsent(4, x -> "quatro");
		map.merge(100, "cem", (x, y) -> x + " remmaped " + y);
		System.out.println(map);
		
		MapMethods methods = new MapMethods();
		methods.nome = "Nicholas";
		methods.modifyMethods(methods);
		System.out.println(methods.nome);
	}

	public void modifyMethods(MapMethods maps) {
		this.nome = "Midified bithc!";
		maps = null;
	}

	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}
}
