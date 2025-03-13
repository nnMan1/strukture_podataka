package cas3_stack_queue;

public class MyStack {
	private int[] data = new int[10];
	private int popunjenost = 0;
	
	public void push(int x) {
		if(popunjenost == data.length) {
			int[] new_data = new int[2*popunjenost];
			for(int i=0;i<popunjenost;i++)
				new_data[i] = data[i];
			
			data = new_data;
		}
		
		data[popunjenost++] = x;
	}
	
	public int pop() {
		if(popunjenost == 0)
			return -1;
		
		return data[--popunjenost];
	}
	
	public int peek() {
		if(popunjenost == 0)
			return -1;
		
		return data[popunjenost-1];	
	}
}
