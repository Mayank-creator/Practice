package com.test.client;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Computation1 implements Runnable {
	public static int product = 0;

	@Override
	public void run() {
		product = 2 * 3;
		try {
			CyclicBarrierEx.cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

	}
}

class Computation2 implements Runnable {
	public static int sum = 0;

	@Override
	public void run() {
		sum = 10 + 20;
		try {
			CyclicBarrierEx.cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}

public class CyclicBarrierEx implements Runnable {
	public static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

	public static void main(String[] args) {
		// parent thread
		CyclicBarrierEx test = new CyclicBarrierEx();
		Thread t1 = new Thread(test);
		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Number of parties required to trip the barrier = " + cyclicBarrier.getParties());
		System.out.println("Sum of product and sum = " + (Computation1.product + Computation2.sum));
		Computation1 computation1 = new Computation1();
		Computation2 computation2 = new Computation2();

		Thread t1 = new Thread(computation1);
		Thread t2 = new Thread(computation2);

		t1.start();
		t2.start();

		try {
			CyclicBarrierEx.cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Sum of product and sum = " + (Computation1.product + Computation2.sum));
		cyclicBarrier.reset();
		System.out.println("Barrier reset successful");
	}

}
