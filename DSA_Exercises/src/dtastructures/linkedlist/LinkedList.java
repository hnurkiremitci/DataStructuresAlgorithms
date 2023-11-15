package dtastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}

	}

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public void getHead() {
		if (head == null) {
			System.out.println("Head: null");
		} else {
			System.out.println("Head: " + head.value);
		}
	}

	public void getTail() {

		if (head == null) {
			System.out.println("Tail: null");
		} else {
			System.out.println("Tail: " + tail.value);
		}
	}

	public void getLength() {
		System.out.println("Length: " + length);
	}

	public void makeEmpty() {
		head = null;
		tail = null;
		length = 0;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;

		}
		length++;
	}

	public Node findMiddleNode() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public boolean hasLoop() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public Node findKthFromEnd(int k) {
		Node slow = head;
		Node fast = head;

		for (int i = 0; i < k; i++) {
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public void partitionList(int x) {
		if (head == null)
			return;

		Node dummy1 = new Node(0);
		Node dummy2 = new Node(0);
		Node prev1 = dummy1;
		Node prev2 = dummy2;
		Node current = head;

		while (current != null) {
			if (current.value < x) {
				prev1.next = current;
				prev1 = current;
			} else {
				prev2.next = current;
				prev2 = current;
			}
			current = current.next;
		}

		prev2.next = null;
		prev1.next = dummy2.next;

		head = dummy1.next;
	}

	public void removeDuplicates() {
		Set<Integer> values = new HashSet<>();
		Node previous = null;
		Node current = head;
		while (current != null) {
			if (values.contains(current.value)) {
				previous.next = current.next;
				length -= 1;
			} else {
				values.add(current.value);
				previous = current;
			}
			current = current.next;
		}
	}

	public int binaryToDecimal() {
		int number = 0;
		Node current = head;

		while (current != null) {
			number = number * 2 + current.value;
			current = current.next;
		}
		return number;

	}

	public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;
    
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;
    
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }
    
        Node currentNode = previousNode.next;
    
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }
    
        head = dummyNode.next;
    }

}
