package matrice_i_nizovi;

import java.util.Arrays;
import java.util.Scanner;

public class Nizovi {
	
	public static int[] ucitajNiz() {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		
		in.close();

		return arr;
	}
	
	public static void stampajNiz(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void uvecajElementeNiza(int[] arr) {
		for(int i=0;i<arr.length;i++)
			arr[i] ++;
	}
	
	public static int najcesciElementSortiran0(int[] arr) {
		int maxBrPojav = 0;
		int maxBrPojavElem = -1;
		
		for(int i=0;i<arr.length;i++) {
			int trenBrPojav = 0;
			
			for(int j=0;j<arr.length;j++)
				if(arr[i] == arr[j])
					trenBrPojav ++;
			
			if(trenBrPojav > maxBrPojav) {
				maxBrPojav = trenBrPojav;
				maxBrPojavElem = arr[i];
			}
		}
		
		return maxBrPojavElem;
	}
	
	public static int najcesciElementSortiran(int[] arr) {
		
		if(arr.length == 0)
			return -1;
		
		int maxBrPojav = 1;
		int maxBrPojavElem = arr[0];
		int trenBrPojav = 1;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i] == arr[i-1]) 
				trenBrPojav++;
			else
				trenBrPojav = 1;
			
			if(trenBrPojav > maxBrPojav) {
				maxBrPojav = trenBrPojav;
				maxBrPojavElem = arr[i];
			}
		}
		
		return maxBrPojavElem;
	}
	
	public static void sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++)
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
		}
	}
	
	public static int najcesciElement(int[] arr) {
//		sort(arr);
		int[] arrCopy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(arrCopy);
		return najcesciElementSortiran(arrCopy);
	}
}
