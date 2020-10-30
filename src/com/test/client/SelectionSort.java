package com.test.client;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = {20, 30, 10, 40, 5 };
		selectionSort(array);
		for(int i: array)
		{
			System.out.println(i);
		}
	}

	public static void selectionSort(int[] array) {
		int min = 0;
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}

	}
}
