package cas3_stack_queue;

public class MyStack {
	private int[] elementi;
	private int popunjenost;
	
	public MyStack() {
		popunjenost=0;
		elementi = new int[10];
	}
	
	public void push(int x) {
		if(popunjenost == elementi.length) {
			int[] novi_elementi = new int[2*popunjenost];
			for(int i=0;i<popunjenost;i++)
				novi_elementi[i] = elementi[i];
			
			elementi = novi_elementi;
		}
		elementi[popunjenost++] = x;
	}
	
	public int pop() {
		if (popunjenost > 0) 
			return elementi[--popunjenost];
		
		return -1;
	}
	
	public int peek() {
		if (popunjenost > 0) 
			return elementi[popunjenost-1];
		
		return -1;
	}
}
