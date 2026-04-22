package stack;

import java.util.EmptyStackException;

public class ArrStack {
	
	private int[] data;
	private int pop;
	
	public ArrStack(int cap) {
		this.data = new int[cap];
	}
	
	public void push(int x) {
		if(pop == data.length) {
//			throw new StackOverflowError();
			int[] newData = new int[2 * data.length];
			for(int i=0;i<data.length;i++)
				newData[i] = data[i];
			
			data = newData;
		}
			
		data[pop++] = x;
	}
	
	public int peek() {
		if(pop == 0)
			throw new EmptyStackException();
		
		return data[pop - 1];
	}
	
	public int pop() {
		if(pop == 0)
			throw new EmptyStackException();
		
		return data[--pop];
	}
	
	public boolean empty() {
		return pop == 0;
	}
	
}
