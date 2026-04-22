package stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class ListStack {

	private LinkedList<Integer> data = new LinkedList<Integer>();
		
	public void push(int x) {
		data.addFirst(x);
	}
	
	public int peek() {
		if(data.isEmpty())
			throw new EmptyStackException();
		
		return data.getFirst();
	}
	
	public int pop() {
		if(data.isEmpty())
			throw new EmptyStackException();
		
		int val = data.getFirst();
		data.removeFirst();
		return val;
	}
	
	public boolean empty() {
		return data.isEmpty();
	}

}
