package cas1;

import java.util.*;
import java.util.Arrays;

public class Nizovi {
	
	public static Scanner input;
	
	public static int[] prefixSum(int[] a) {
		int[] p = new int[a.length];
		p[0] = a[0];
		
		for(int i=1;i<a.length;i++)
			p[i] = p[i-1] + a[i];
		
		return p;
	}
	
	public static int maxFrequency(int[] a, int k) {
		 Arrays.sort(a);
		 
		 int[] pref_sum = prefixSum(a);
         System.out.println(a.length);
		 
		 int i=0;
		 int j=0;
		 int ans = 0;
		 
		 while(i < a.length) {
			 long p = a[i] * (i - j);

			 if(i == a.length - 1) {
				 System.out.println(p);
			 }
			 
			 if(i > 0)
                p -= pref_sum[i-1];
			 
             if(j > 0) 
				p += pref_sum[j-1];
			 
			 if(p > k)
				 j++;
			 else {
				 ans = Math.max(ans, i - j + 1);
                 i++;
			 }
		 }
		 		 
		 return ans;
    }
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		int[] num = new int[input.nextInt()];
		
		for(int i=0;i<num.length;i++)
			num[i] = input.nextInt();
		
		int k = input.nextInt();
		
		System.out.println(maxFrequency(num, k));
		
	}
}
