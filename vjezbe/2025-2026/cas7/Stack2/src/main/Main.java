package main;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static Scanner in = new Scanner(System.in);
	
	public static int priority(char operator) {
		if(operator == '+' || operator == '-')
			return 1;
		if(operator == '*' || operator == '/')
			return 2;
		
		return 0;
	}

	public static String infixToPostfix(String s) {
		String ret = "";
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(Character.isDigit(c)) {
				ret += c;
				continue;
			}
			
			if(c == '(') {
				stack.push(c);
				continue;
			}
			
			if(c == ')') {
				while(!stack.isEmpty() && stack.peek() != '(')
					ret += stack.pop();

				if(stack.isEmpty()) {
					return "Neispravan izraz";
				}
				stack.pop();
				continue;
			}
		
			
			while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
				ret += stack.pop();
			}
			stack.push(c);
		}
		
		while(!stack.isEmpty())
			ret += stack.pop();
		
		return ret;
	}
	
	int computePostfixValue(String s) {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String izraz = in.next();
		System.out.println(infixToPostfix(izraz));
	}

}
