package kolokvijum;
import java.util.Arrays;
import java.util.Scanner;

public class zad1 {

	public static Scanner in = new Scanner(System.in);
	
	public static int[] maxSum(int[] arr) {
		int max_sum = 0;
		int curr_sum = 0;
		int max_sum_start = 0;
		int max_sum_end = 0;
		int curr_sum_start = 0;
		
		for(int i=0;i<arr.length;i++) {
			curr_sum += arr[i];
			if(curr_sum < 0) {
				curr_sum = 0;
				curr_sum_start = i+1;
				continue;
			}
			
			if(curr_sum > max_sum) {
				max_sum = curr_sum;
				max_sum_start = curr_sum_start;
				max_sum_end = i;
			}
		}
		
		int ret[] = new int[max_sum_end - max_sum_start + 1];
		
		for(int j = 0, i=max_sum_start;i<=max_sum_end;j++, i++)
			ret[j] = arr[i];
		
		return ret;
			
	}
	
	public static int arrSum(int[] arr) {
		int s = 0;
		for(int i=0;i<arr.length;i++)
			s += arr[i];
		
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		
		int sub1[] = maxSum(arr);
		
		for(int i=0;i<n;i++)
			arr[i] *= -1;
		
		int sub2[] = maxSum(arr);
		
		if(arrSum(sub1) > arrSum(sub2)) {
			for(int i=0;i<sub1.length;i++)
				System.out.print(sub1[i] + " ");
		} else {
			for(int i=0;i<sub2.length;i++)
				System.out.print(-sub2[i] + " ");
		}
		

	}

}
