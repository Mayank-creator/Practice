package com.test.client;

/**
 * @author msgaur
 *
 */
public class BubbleSort {

	public static void main(String[] args)
	{
		int array[] = {100, 20, 40, 30, 50, 1,2,3,4,5,6};
		bubbleSort(array);
		for(int i: array)
		{
			System.out.println(i);
		}
	}
	
	public static void bubbleSort(int[] array)
	{
		int temp = 0;
		for(int i = 0; i< array.length;i++)
		{
			for(int j=0; j< array.length-1-i;j++)
			{
				if(array[j] > array[j+1])
				{
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
