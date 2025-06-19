package com.dss.collection.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		priorityQueue.add(10);
		priorityQueue.add(100);
		priorityQueue.add(30);
		priorityQueue.add(90);
		priorityQueue.add(15);
		System.out.println(priorityQueue);
		Iterator<Integer> itr = priorityQueue.iterator();
		while (itr.hasNext()) {
System.out.println(priorityQueue.poll());

		}
	}

}
