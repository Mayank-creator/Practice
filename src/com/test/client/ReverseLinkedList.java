package com.test.client;

public class ReverseLinkedList {
	Node head;

	public static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	public boolean insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return true;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
			return true;
		}
	}
	void printList() 
    { 
		Node currNode = head;
        while (currNode != null) { 
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    }
	public void reverse()
	{
		Node currentNode = head;
		Node previousNode = null;
		Node next = null;
		while(currentNode != null)
		{
			next = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = next;
			
		}
		head = previousNode;
	}
	public static void main(String[] args) 
    { 
		ReverseLinkedList list = new ReverseLinkedList(); 
		list.insert(1);
		list.insert(2);
		list.insert(3);
  
        System.out.println("Given Linked list"); 
        list.printList(); 
        list.reverse();
        System.out.println("Given Linked list");
        list.printList();
       
    } 
}
