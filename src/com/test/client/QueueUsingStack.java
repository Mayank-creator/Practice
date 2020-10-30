package com.test.client;

import java.util.Stack;

/**
 * @author msgaur
 *
 */
public class QueueUsingStack {
	
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	
	
	static void enQueue(int x)
	{
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		stack1.push(x);
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
	}
	
	static int deQueue()
	{
		if(stack1.isEmpty())
		{
			System.out.println("Queue is Empty");
			System.exit(0);
		}
		return stack1.pop();
	}
	
	/**
	 * @param args
	 */
	public static void main(String... args)
	{
		QueueUsingStack.enQueue(1);
		QueueUsingStack.enQueue(2);
		QueueUsingStack.enQueue(3);
		System.out.println(QueueUsingStack.deQueue());
		System.out.println(QueueUsingStack.deQueue());
		System.out.println(QueueUsingStack.deQueue());
	}

}
