package com.test.client;

public class CustomLinkedList {

	Node head;

	public static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * Insert data in linkedlist
	 * 
	 * @param list
	 * @param data
	 * @return
	 */
	public CustomLinkedList insert(CustomLinkedList list, int data) {
		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}

	public void printList(CustomLinkedList linkedList) {
		Node currNode = linkedList.head;
		while (currNode != null) {
			System.out.println(currNode.data);
			currNode = currNode.next;
		}
	}

	public CustomLinkedList deleteByKey(CustomLinkedList list, int key) {
		Node prevNode = null;
		Node currNode = list.head;

		if (currNode != null && currNode.data == key) {
			list.head = currNode.next;
			return list;
		}

		while (currNode != null && currNode.data != key) {
			prevNode = currNode;
			currNode = currNode.next;
		}
		if (currNode != null) {
			prevNode.next = currNode.next;
		}
		return list;
	}

	void detectLoop() {
		Node slow_p = head, fast_p = head;
		int flag = 0;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			System.out.println("Loop found");
		else
			System.out.println("Loop not found");
	}

	public Node reverseLinkedList()
	{
		Node previousNode = null;
		Node nextNode = null;
		Node currentNode = head;
		if(currentNode == null)
		{
			return null;
		}
		while(currentNode != null)
		{
			previousNode = currentNode;
			currentNode = currentNode.next;
			previousNode.next = nextNode;
			nextNode = previousNode;
			
		}
		
		return  head = nextNode;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.insert(linkedList, 1);
		linkedList.insert(linkedList, 2);
		linkedList.insert(linkedList, 3);
		linkedList.insert(linkedList, 4);
		linkedList.insert(linkedList, 5);
		linkedList.reverseLinkedList();
		linkedList.printList(linkedList);
		//linkedList.head.next.next.next.next.next = linkedList.head;
		//linkedList.detectLoop();

		/*
		 * linkedList.printList(linkedList); linkedList.deleteByKey(linkedList, 2); linkedList.printList(linkedList);
		 */
	}
}
