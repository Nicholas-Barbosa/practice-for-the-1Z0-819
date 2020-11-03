package com.nicholas.ocp.calendar;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Principal {

	public static void main(String[] args) {
//		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en","in"));
//		System.out.println(format.format(12324.134));
		Queue<Integer> d = new LinkedList<>();
		d.offer(1);
		d.offer(2);
		d.offer(3);
		System.out.println(d.poll());
		System.out.println(d.poll());
		System.out.println(d.poll());
		System.out.println();
		Deque<Integer> d2 = new ArrayDeque<>();
		d2.push(1);
		d2.push(2);
		d2.push(3);
		System.out.println(d2.pollFirst());
		System.out.println(d2.poll());
		System.out.println(d2.pollLast());
	}

}
