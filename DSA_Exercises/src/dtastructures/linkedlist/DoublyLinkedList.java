package dtastructures.linkedlist;

public class DoublyLinkedList {

	private Node head;
	private int length;
	private Node tail;

	class Node {
		int value;
		Node next;
		Node prev;

		Node(int value) {
			this.value = value;
		}
	}

	public DoublyLinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		length = 1;
	}

	public Node getHead() {
		return head;
	}

	public int getLength() {
		return length;
	}

	public Node getTail() {
		return tail;
	}

	public void printList() {
		StringBuilder output = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			output.append(temp.value);
			if (temp.next != null) {
				output.append(" <-> ");
			}
			temp = temp.next;
		}
		System.out.println(output.toString());
	}

	public void makeEmpty() {
		head = null;
		length = 0;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			newNode.prev = current;
		}
		length++;
	}

	public void swapPairs() {
		Node dummyNode = new Node(0);
		dummyNode.next = head;
		Node previousNode = dummyNode;

		while (head != null && head.next != null) {
			Node firstNode = head;
			Node secondNode = head.next;

			previousNode.next = secondNode;
			firstNode.next = secondNode.next;
			secondNode.next = firstNode;

			secondNode.prev = previousNode;
			firstNode.prev = secondNode;

			if (firstNode.next != null) {
				firstNode.next.prev = firstNode;
			}

			head = firstNode.next;
			previousNode = firstNode;
		}

		head = dummyNode.next;
		if (head != null)
			head.prev = null;
	}

	public void reverse() {
		Node current = head;
		Node temp = null;

		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		temp = head;
		head = tail;
		tail = temp;
	}

	public void swapFirstLast() {
		if (length < 2)
			return;
		int temp = head.value;
		head.value = tail.value;
		tail.value = temp;
	}
	
	boolean isPalindrome() {
	    
	    Node starterPoint = head;
	    Node endingPoint = tail;
	    
	    for(int i =0;  i<length/2; i++) {
	        if(starterPoint.value != endingPoint.value) {
	            return false;
	        }
	        starterPoint=starterPoint.next;
	        endingPoint=endingPoint.prev;
	    }
	    
	    return true;
	    
	}

}
