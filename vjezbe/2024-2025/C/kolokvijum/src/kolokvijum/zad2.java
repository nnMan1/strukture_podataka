package kolokvijum;

import java.util.Scanner;
import java.util.Stack;

public class zad2 {
	public static Scanner in = new Scanner(System.in);
	
	public static void operacije(int[] arr1, int[] arr2) {
		int[] ops = new int[2 * arr1.length];
		int k = 0;
		int j = 0;
		
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<arr1.length;i++) {
			s.push(arr1[i]);
			ops[k++] = 1;
			
			while(!s.empty() && s.peek() == arr2[j]) {
				s.pop();
				j++;
				ops[k++] = 2;
			}
		}
		
		if(!s.empty()) {
			System.out.println("-");
		} else {
			for(int i=0;i<ops.length;i++) 
				System.out.println(ops[i] == 1 ? "push" : "pop");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		
		int[] arr1 = new int[n];
		for(int i=0;i<n;i++)
			arr1[i] = in.nextInt();
		
		int[] arr2 = new int[n];
		for(int i=0;i<n;i++)
			arr2[i] = in.nextInt();
		
		operacije(arr1, arr2);
	}

}
