package com.linked.list;

public class DeleteNode {

	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	void printList() {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	void delete(int position) {
		if (head == null) {
			return;
		}

		Node prev = head;

		if (position == 1) {
			head = prev.next;
		}

		for (int i = 1; prev != null && i <= position - 1; i++) {
			prev = prev.next;
		}

		if (prev == null || prev.next == null) {
			return;
		}

		Node new_node = prev.next.next;
		prev.next = new_node;
	}
	
	// To delete an entire linked list
	public void deleteList() {
		head = null;
	}

	public static void main(String[] args) {
		DeleteNode obj = new DeleteNode();
		obj.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		obj.head.next = second;
		second.next = third;

		obj.printList();

		obj.delete(2);

		obj.printList();
	}

}
