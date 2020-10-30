package com.test.client;

/**
 * @author msgaur
 *
 * @param <K>
 * @param <V>
 */
public class CustomHashMap<K, V> {
	private Entry<K, V>[] buckets;
	private static final int INTIAL_CAPACITY = 1 << 4;
	private int size = 0;

	public CustomHashMap() {
		this(INTIAL_CAPACITY);
	}

	public CustomHashMap(int capacity) {
		buckets = new Entry[capacity];
	}

	static class Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % INTIAL_CAPACITY;
	}

	public void put(K key, V value) {
		int index = hash(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
		if (buckets[index] == null) {
			buckets[index] = newEntry;
			size++;
		} else {
			Entry<K, V> current = buckets[index];
			while (current.next != null) {
				if (current.key.equals(key)) {
					current.value = value;
					return;
				}
				current = current.next;
			}
			if (current.key.equals(key)) {
				current.value = value;
			} else {
				current.next = newEntry;
				size++;
			}
		}
	}

/**
 * @param key
 * @return value
 */
public V get(K key) {
    Entry<K, V> bucket = buckets[hash(key)];
    while (bucket != null) {
        if (bucket.key.equals(key)) {
            return bucket.value;
        }
        bucket = bucket.next;
    }
    return null;
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomHashMap<String, String> myMap = new CustomHashMap<>();
	    myMap.put("USA", "Washington DC");
	    myMap.put("Nepal", "Kathmandu");
	    myMap.put("India", "New Delhi");
	    myMap.put("Australia", "Sydney");
	    System.out.println(myMap.get("India"));
	}
}
