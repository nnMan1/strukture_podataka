package queue;

import java.util.NoSuchElementException;

public class ListQueue {
	private static class Node {
		int value;
		Node next;
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	Node head = null;
	Node tail = null;
	
	boolean add(int e) {
				
		if(head == null) 
			head = tail = new Node(e, null);
		else {		
			tail.next = new Node(e, null);
			tail = tail.next;
		}		
		
		return true;
	}
	
	Integer remove() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		int value = head.value;
		
		if(head == tail) 
			head = tail = null;
		else
			head = head.next;		
		
		return value;
	}
	
	Integer pool() {
		if(isEmpty())
			return null;
		
		int value = head.value;
		
		if(head == tail) 
			head = tail = null;
		else
			head = head.next;		
		
		return value;
	}
	
	Integer element() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		return head.value;
	}
	
	Integer peek() {
		if(isEmpty())
			throw null;
		
		return head.value;
	}
	
	boolean isEmpty() {
		return head == null;
	}
	
	
}
