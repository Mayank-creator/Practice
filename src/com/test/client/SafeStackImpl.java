package com.test.client;

interface IStack {
	void push(Object element);

	Object pop();

}

interface ISafeStack extends IStack {
	boolean isEmpty();

	boolean isFull();
}

class SafeStackImpl extends StackImpl implements ISafeStack {
	SafeStackImpl(int capacity) {
		super(capacity);
	}

	@Override
	public boolean isEmpty() {
		if (tos < 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isFull() {
		if (tos >= size - 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		SafeStackImpl stack = new SafeStackImpl(5);
		stack.push(10);
		stack.push(20);
		stack.pop();
		stack.peek();
	}
}

class StackImpl implements IStack {
	protected Object[] stackArray;
	protected int tos;
	protected int size;

	public StackImpl(int capacity) {
		this.size = capacity;
		this.stackArray = new Object[capacity];
		this.tos = -1;
	}

	@Override
	public void push(Object element) {
		if (!((SafeStackImpl) this).isFull()) {
			tos++;
			stackArray[tos] = element;
			System.out.println("Push element: " + stackArray[tos]);
		} else {
			System.out.println("Stack is Full");
		}

	}

	@Override
	public Object pop() {
		if (!((SafeStackImpl) this).isEmpty()) {
			int topPosition = tos;
			tos--;
			System.out.println("Deleted element: " + stackArray[topPosition]);
			return stackArray[topPosition];
		}
		return null; 
	}
	
	public Object peek() {
		return stackArray[tos];
	}


}
