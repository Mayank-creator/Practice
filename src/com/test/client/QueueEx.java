package com.test.client;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueEx {

	public static void main(String[] args) {
		Queue<String> queue = new PriorityQueue<String>();
		queue.add("B");
		queue.add("C");
		queue.add("A");
		for (String s : queue) {
			System.out.println(s);
		}

		queue.remove();
		System.out.println("After removing: " + queue);
		System.out.println("Poll Method " + queue.poll());
		System.out.println(queue);
	}

}
