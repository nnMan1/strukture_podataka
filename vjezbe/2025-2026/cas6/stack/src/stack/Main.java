package stack;

import java.util.Stack;

public class Main {
	
	public static void testArrStackPush() {
		
		System.out.println("===============Testing push operation===============");
		ArrStack stack1 = new ArrStack(3);
		stack1.push(5);
		stack1.push(6);
		stack1.push(4);
		stack1.push(59);
		System.out.println("===============Push test passed===============");
	}
	
	public static void testArrStackPeek() {
		System.out.println("===============Testing push operation===============");
		ArrStack stack1 = new ArrStack(5);
		stack1.push(5);
		stack1.push(4);
		
		int a = stack1.peek();
		int b = stack1.peek();
		
		if(a != 4 || b != 4)
			System.out.println("===============Peek test failed===============");
		else 
			System.out.println("===============Peek test passed===============");
	}
	
	public static void testArrStackPop() {
		System.out.println("===============Testing push operation===============");
		ArrStack stack1 = new ArrStack(5);
		stack1.push(5);
		stack1.push(4);
		
		int a = stack1.pop();
		int b = stack1.pop();
		
		if(a != 4 || b != 5)
			System.out.println("===============Pop test failed===============");
		else 
			System.out.println("===============Pop test passed===============");
	}
	
	public static void testArrStackEmpty() {
		System.out.println("===============Testing empty operation===============");
		ArrStack stack1 = new ArrStack(5);
		
		if(!stack1.empty()) {
			System.out.println("===============Empty test failed===============");
			return;
		}
		
		stack1.push(5);
		stack1.push(4);
		
		if(stack1.empty()) {
			System.out.println("===============Empty test failed===============");
			return;
		}
		
		int a = stack1.pop();
		int b = stack1.pop();
		
		if(!stack1.empty()) {
			System.out.println("===============Empty test failed===============");
			return;
		}
		
		System.out.println("===============Empty test passed===============");
	}
	
	

	public static void main(String[] args) {
		
		testArrStackPush();
		testArrStackPeek();
		testArrStackPop();
		testArrStackEmpty();
		
		ListStack s = new ListStack();
		
		s.push(5);
		s.push(7);
		s.push(9);
		s.push(3);
		
		// uzima vrijednost koja se nalazi na vrhu stakca
		System.out.println(s.peek());
		System.out.println(s.peek());
		System.out.println(s.pop()); //vraca vrijednost na vrhu stacka i uklanja je sa stacka
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
//		s.pop();
//		s.pop();
//		s.pop();
		System.out.println(s.empty()); //da li je stack prazan
		
//		Stack<Integer> s = new Stack<>();
//		
//		//dodavanje u stack
//		s.push(5);
//		s.push(7);
//		s.push(9);
//		s.push(3);
//		
//		// uzima vrijednost koja se nalazi na vrhu stakca
//		System.out.println(s.peek());
//		System.out.println(s.peek());
//		System.out.println(s.pop()); //vraca vrijednost na vrhu stacka i uklanja je sa stacka
//		System.out.println(s.peek());
//		System.out.println(s.pop());
//		System.out.println(s.peek());
////		s.pop();
////		s.pop();
////		s.pop();
//		System.out.println(s.empty()); //da li je stack prazan

	}

}
