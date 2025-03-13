package cas3_stack_queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void ucitajNiz(int arr[]) {
		for(int i=0;i<arr.length;i++)
			arr[i] = in.nextInt();
	}
	
	public static void stampajNiz(int arr[]) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	
	/*
	 * 1. Napisati program koji provjerava da li je unijeti niz zagrada ispravan.
	 * Niz zagrada je ispravan ako se umetanjem broja jedan i operatora +
	 * na dogovarajucim pozicijama moze dobiti ispravan aritmeticki izraz
	 * Primjer:
	 * (()) => ispravan
	 * ()() => ispravan
	 * (())) => nije ispravan 
	 * ())( => nije ispravan
	 */
	
	public static boolean zagrade(String izraz) {
		
		Stack<Character> s = new Stack<>();
		
		for(int i=0;i<izraz.length();i++) {
			char c = izraz.charAt(i);
			
			if(c == '(' || c == '[' || c == '{') {
				s.push(c);
				continue;
			}
			
			if(s.empty())
				return false;
			
			if(c == ')' && s.peek() != '(')
				return false;			
			if(c == ']' && s.peek() != '[')
				return false;			
			if(c == '}' && s.peek() != '{')
				return false;	
			
			s.pop();
		}
		
		return s.empty();
	}

	/*
	 * 2. Napisati program koji učitava niz cijelih brojeva A dužine N, 
	 * a zatim napisati funkciju koja za svaki element niza štampa prvi 
	 * veći element koji se nalazi poslije njega u nizu. Za elemente za 
	 * koje ne postoji takav element, štampati -1. 
	 */
	public static void prviVeci(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			boolean pronadjen = false;
			
			for(int j=i+1;j<arr.length;j++)
				if(arr[i] < arr[j]) {
					System.out.print(arr[j]+" ");
					pronadjen = true;
					break;
				}
			
			if(!pronadjen)
				System.out.print(-1+" ");
		}
	}
	
	public static void prviVeciStack(int[] arr) {
		Stack<Integer> s = new Stack<>();
		int[] rez = new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			while(!s.empty() && arr[s.peek()] < arr[i])
				rez[s.pop()] = arr[i];
			
			s.push(i);
		}
		
		while(!s.empty())
			rez[s.pop()] = -1;
		
		stampajNiz(rez);
	}
	
	/*
	 * 3. Rasporediti vagone u redsljed 1234...
	 */
	public static void vagoni(int[] arr) {
		Stack<Integer> s = new Stack<>();
		int cur = 1;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<arr.length;i++) {
			q.add(1);
			s.push(arr[i]);
			
			while(!s.empty() && s.peek() == cur) {
				q.add(2);
				s.pop();
				cur++;
			}
			
;		}
								
		if(!s.empty())
			System.out.println(0);
		else {
			int op = 1;
			int cnt = 0;
			
			while(!q.isEmpty()) {
				if(q.peek() == op) {
					q.remove();
					cnt++;
				} else {
					System.out.println(op + " " + cnt);
					op = op == 1 ? 2 : 1;
					cnt = 0;
				}
			}
			
			System.out.println(op + " " + cnt);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyStack s1 = new MyStack();
//		Stack<Integer> s1 = new Stack<>();
//		
//		s1.push(5);
//		s1.push(4);
//		s1.push(9);
//		s1.push(3);
//		
//		System.out.println(s1.pop());
//		System.out.println(s1.pop());
//		s1.push(5);
//				
//		System.out.println(s1.pop());
//		System.out.println(s1.pop());
//		System.out.println(s1.pop());
		
//		String s = in.next();
//		System.out.println(zagrade(s));
		
		int n = in.nextInt();
		int[] arr = new int[n];
		ucitajNiz(arr);
		
		vagoni(arr);
		
		
	}

}
