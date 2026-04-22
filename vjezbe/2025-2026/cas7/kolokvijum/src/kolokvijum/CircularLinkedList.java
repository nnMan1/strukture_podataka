package kolokvijum;

public class CircularLinkedList {
	
	private static class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private Node tail = null; 
	
	public void insertAtStart(int data) {
		if(tail == null) {
			tail = new Node(data);
			tail.next = tail;
		} else 
			tail.next = new Node(data, tail.next);
	}
	
	public void insertAtEnd(int data) {
		if(tail == null) {
			tail = new Node(data);
			tail.next = tail;
		} else {
			Node novi = new Node(data, tail.next);
			tail.next = novi;			
			tail = novi;
		}
	}
	
	private void deleteNodeAfter(Node prev) {
		
		if(tail.next == tail) {
			//samo jedan element
			tail = null; 
		}
		
		Node it = prev.next;
		
		prev.next = it.next;
		if(it == tail) 
			tail = prev;
	}
	
	public boolean deleteNode(int value) {
		if(tail == null)
			return false;
				
		Node prev = tail;
		Node it = tail.next;
		
		while(true) {
			
			if(it.value == value) {
				deleteNodeAfter(prev);
				return true;
			}
			
			if(it == tail)
				break;
			
			prev = it;
			it = it.next;
		}
		
		return false;
		
	}
	
	public boolean deleteNodeLast(int value) {
		if(tail == null)
			return false;
				
		Node prev = tail;
		Node it = tail.next;
		
		Node toDeletePrev= null;
		
		while(true) {
			
			if(it.value == value) {
				toDeletePrev = prev;
			}
			
			if(it == tail)
				break;
			
			prev = it;
			it = it.next;
		}
		
		if(toDeletePrev != null) {
			deleteNodeAfter(toDeletePrev);
			return true;
		}
		
		return false;
	}
	
	public boolean search(int value) {
		if(tail == null)
			return false;
				
		Node it = tail.next;
		
		while(true) {
			
			if(it.value == value) {
				return true;
			}
			
			if(it == tail)
				break;
			
			it = it.next;
		}
		
		return false;
		
	}
	
	public void insertSorted(int data){
		if(tail == null) {
			insertAtStart(data);
			return;
		}
		
		Node it = tail.next;
		Node prev = tail;
		
		
		while(true) {
			
			if(it.value > data) {
				Node novi = new Node(data, it);
				prev.next = novi;
				return;
			}
			
			if(it == tail)
				break;
			
			prev = it;
			it = it.next;
		}
		
		insertAtEnd(data);
	}
	
	public void sort() {
		if(tail == null) {
			return;
		}
		
		CircularLinkedList list = new CircularLinkedList();
		
		Node it = tail.next;
		
		
		while(true) {
			
			list.insertSorted(it.value);
			
			if(it == tail)
				break;
			
			it = it.next;
		}
		
		this.tail = list.tail;
	}
	
	@Override
	public String toString() {
		if(tail == null)
			return "null";
		
		Node it = tail.next;
		String ret = "";
		
		while(true) {
			ret = ret + it.value + "->";
			
			if(it == tail)
				break;
			
			it = it.next;
		}
		
		ret += "null";
		
		return ret;
	}
}
