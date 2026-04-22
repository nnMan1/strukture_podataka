package kolokvijum;

public class Main {
	
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		

		list.insertAtEnd(9);
		System.out.println(list);

		list.deleteNode(9);
		System.out.println(list);
		
		list.insertAtStart(3);
		list.insertAtStart(5);
		list.insertAtStart(7);
		list.insertAtStart(3);
		
		System.out.println(list);

		list.insertAtEnd(9);
		
		System.out.println(list);
		
		list.deleteNode(9);
		System.out.println(list);
		
		list.deleteNodeLast(3);
		System.out.println(list);
		
		System.out.println(list.search(7) ? "Sadrzi 7" : "Ne sadrzi 7");
		System.out.println(list.search(9) ? "Sadrzi 9" : "Ne sadrzi 9");

		list.sort();
		System.out.println(list);
		list.insertSorted(4);
		System.out.println(list);
		list.insertSorted(29);
		System.out.println(list);
		
	}

}
