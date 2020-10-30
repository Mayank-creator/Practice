package com.test.client;

public class InsertionSort {

	public static void main(String[] args) {
		int array[] = {20, 10, 1, 5, 4};
		insertionSort(array);
		for(int i: array)
		{
			System.out.println(i);
		}
	}
	
	public static void insertionSort(int array[])
	{
		int temp = 0;
		for(int i = 1; i< array.length; i++)
		{
			int j = i-1;
			int key = array[i];
			while(j > -1 && array[j] > key)
			{
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
 				j--;
			}
		}
	}

}
