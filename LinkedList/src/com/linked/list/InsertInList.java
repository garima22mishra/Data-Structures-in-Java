package com.linked.list;

public class InsertInList {

	Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	void printList() {
		Node n=head;
		while(n != null) {
			System.out.println(n.data+" ");
			n = n.next;
		}
	}
	
	void push(int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	void insert(Node prev, int data) {
		if(prev == null) {
			return;
		}
		
		Node newNode = new Node(data);
		newNode.next = prev.next;
		prev.next = newNode;
	}
	
	@SuppressWarnings("null")
	void append(int data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		Node newNode = new Node(data);
		
		Node n = head;
		
		while(n != null) {
			n = n.next;
		}
		
		n.next = newNode;
		return;
	}
	
	public static void main(String[] args) {
		InsertInList obj = new InsertInList();
		obj.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		
		obj.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		
		System.out.println("Created a linked list : \n");
		obj.printList();
		
		System.out.println("\n Inserting 0 in the begining: \n");
		obj.push(0);
		obj.printList();
		
		System.out.println("\n Inserting 2 after 4: \n");
		obj.insert(fourth, 2);
		obj.printList();
		
		System.out.println("\n Inserting 7 at the end: \n");
		obj.append(7);
		obj.printList();

	}

}
