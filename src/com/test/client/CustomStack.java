package com.test.client;

/**
 * @author msgaur
 * Custom Stack using array
 *
 */
public class CustomStack {
	int size;
	int[] array;
	int top;

	public CustomStack(int size) {
		this.size = size;
		this.array = new int[size];
		this.top = -1;
	}

	public static void main(String[] args) {
		CustomStack stack = new CustomStack(5);
		stack.push(10);
		stack.push(20);
		stack.pop();
		stack.peek();
	}

	public void push(int element) {
		if (!isFull()) {
			top++;
			array[top] = element;
			System.out.println("Push element: " + array[top]);
		} else {
			System.out.println("Stack is Full");
		}
	}

	public int pop() {
		if(!isEmpty())
		{
		int topPosition = top;
		top--;
		System.out.println("Deleted element: " + array[topPosition]);
		return array[topPosition];
		}
		else
		{
			System.out.println("Stack is Empty");
			return -1;
		}
	}

	public int peek() {
		System.out.println("Element at top: " + array[top]);
		return array[top];
	}

	public boolean isFull() {
		return (size - 1 == top);
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}
