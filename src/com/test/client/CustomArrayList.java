package com.test.client;

public class CustomArrayList<E> {

	private static final int INTIAL_CAPACITY = 5;
	private Object[] data;
	private int index;
	private int size;

	public CustomArrayList() {
		this.data = new Object[INTIAL_CAPACITY];
		size = INTIAL_CAPACITY;
	}

	public void add(Object object) {
		System.out.println("index:" + this.index + " size:" + this.size + " data size:" + this.data.length);
		if (index == size - 1) {
			increaseSizeAndReallocate();
		}
		data[index] = object;
		index++;
	}

	private void increaseSizeAndReallocate() {
		size = size + INTIAL_CAPACITY;
		Object[] newData = new Object[size];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
		System.out.println("**index:" + this.index + " size:" + this.size + " data size:" + this.data.length);
	}

	public int size() {
		return index;
	}

	public Object get(int i) throws Exception {
		if (i > index - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		}
		if (i < 0) {
			throw new Exception("Negative Value");
		}
		return data[i];
	}

	public void remove(int i) throws Exception {
		if (i > index - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		}
		if (i < 0) {
			throw new Exception("Negative Value");
		}
		for (int x = i; x < data.length-1; x++) {
			data[x] = data[x + 1];    
		}
		index--;
	}

	public static void main(String[] args) throws Exception {
		CustomArrayList<String> a = new CustomArrayList<String>();
		a.add("1");
		a.add("2");
		System.out.println(a.size());
		a.remove(1);
	}

}
