package com.test.client;

public class BinarSearch {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		binarySearch(a, 2);
	}

	public static void binarySearch(int[] a, int key) {
		int mid = 0, left = 0, right = a.length - 1;
		while (left != right) {
			mid = (left + right) / 2;
			if (a[mid] == key) {
				System.out.println(key + " is present at index: " + mid);
			}

			if (key > a[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
	}

}