package com.nicholas.ocp.collection;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListOcp {

	public static void main(String[] args) {
		var queue = new LinkedList<String>();
		queue.offer("Nicholas");
		queue.offer("Barbosa");
		System.out.println(queue.poll());
		System.out.println(queue.peek());
	}
}
