package com.test.client;

import java.util.HashMap;
import java.util.Map;

import com.test.entity.Book;

/**
 * @author msgaur
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Book book = new Book();
		Book book1 = new Book();
		Map<Book, Integer> map = new HashMap<Book, Integer>();
		map.put(book, 1);
		map.put(book1, 2);
		for(Map.Entry<Book, Integer> e : map.entrySet())
		{
			System.out.println(e.getValue());
		}
	}
}