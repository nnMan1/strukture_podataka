package queue;

import java.util.NoSuchElementException;

public class ArrQueue {
	
	int first = 0;
	int last = 0;
	int[] data;
	
	public ArrQueue(int cap) {
		this.data = new int[cap];
	}
	
	boolean add(int e) {
		if(last == data.length) {
			if(first == 0) {
				//povecaj kapacitet niza 
				//ili vrati false
				throw new IllegalStateException("Queue je vec pun");
			}
			
			for(int i=first;i<last;i++) 
				data[i-first] = data[i];
			
			last = last - first;
			first = 0;			
		} 

		data[last++] = e;
		return true;
	}
	
	Integer remove() {
		if(first == last)
			throw new NoSuchElementException();
		
		return data[first++];
	}
	
	Integer pool() {
		if(first == last)
			return null;
		
		return data[first++];
	}
	
	Integer element() {
		if(first == last)
			throw new NoSuchElementException();
		
		return data[first];
	}
	
	Integer peek() {
		if(first == last)
			return null;
		
		return data[first];
		}
	
		boolean isEmpty() {
			return first == last;
	}
	
	
	@Override
	public String toString() {
		String str = "";
		
		for(int i=first;i<last;i++)
			str = str + data[i] + " "; 
		
		return str;
	}
}
