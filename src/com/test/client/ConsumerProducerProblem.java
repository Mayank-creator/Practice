package com.test.client;

public class ConsumerProducerProblem {
	public static void main(String[] args) {
		CubbyHole c = new CubbyHole();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);
		p1.start();
		c1.start();
	}
}

class CubbyHole {
	int contents;
	boolean isAllowedToAdd = true;

	public synchronized int get() {
		while (isAllowedToAdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isAllowedToAdd = true;
		notifyAll();
		return contents;
	}

	public synchronized void put(int value) {
		while (!isAllowedToAdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contents = value;
		isAllowedToAdd = false;
		notifyAll();
	}
}

class Consumer extends Thread {
	CubbyHole c;
	int number;

	public Consumer(CubbyHole c, int number) {
		this.c = c;
		this.number = number;
	}
	@Override
	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = c.get();
			System.out.println("Consumer #" + this.number + " get: " + value);
		}
	}
}

class Producer extends Thread {

	CubbyHole c;
	int number;

	public Producer(CubbyHole c, int number) {
		this.c = c;
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			c.put(i);
			System.out.println("Producer #" + this.number + " put: " + i);
			try {
				sleep((int) Math.random() * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
