package kolokvijum;

import java.util.*;

 

public static int razlika(int arr[]) {
	int cnt = 0;
	
	for(int i = 0; i < arr.length;i ++) {
		 for(int j = 0;j < arr.length - 1;j++) {
			 if(a[j] != a[j + 1])
				 cnt++;
			 
		 }
	}
}
public static void ucitaj_niz(int arr[]) {
	Scanner in = new Scanner(System.in);
	
	for(int i = 0; i < arr.length;i ++) {
		arr[i] = in.nextInt();
		
	}
}
public class Main {
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		
		
        ucitaj_niz(arr);
		razlika(arr);
		
		
	}
}
