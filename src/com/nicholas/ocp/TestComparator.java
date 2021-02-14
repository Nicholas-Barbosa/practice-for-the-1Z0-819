package com.nicholas.ocp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {

	private Integer age;

	public TestComparator(Integer age) {
		super();
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public static void main(String[] args) {
		List<TestComparator> lista = Arrays.asList(new TestComparator(20), new TestComparator(10));
		Collections.sort(lista, Comparator.comparing(a -> a.getAge()));
		System.out.println(lista);

		List<Integer> ls = Arrays.asList(10, 47, 33, 23);

		int max = ls.stream().max(Comparator.comparing(a -> a)).get();
		System.out.println(max); // 1

		int min = ls.stream().min(Comparator.comparing(a -> a)).get();
		System.out.println(min);
	}
}
