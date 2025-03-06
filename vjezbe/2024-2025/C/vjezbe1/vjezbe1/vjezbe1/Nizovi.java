package vjezbe1;

import java.util.Scanner;
import java.util.Arrays;

public class Nizovi {
	
	public static void printNiz(int[] niz) {
		for(int i=0;i<niz.length;i++)
			System.out.print(niz[i]+ " ");
	}
	
	public static int[] ucitajNiz() {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[] niz = new int[n];
		
		for(int i=0;i<n;i++)
			niz[i] = input.nextInt();
		
		return niz;
	}
	
	public static void sort(int[] niz) {
		Arrays.sort(niz);
//		for(int i=0;i<niz.length;i++) {
//			for(int j=0;j<niz.length-1;j++)
//				if(niz[j] > niz[j+1]) {
//					int tmp = niz[j];
//					niz[j] = niz[j+1];
//					niz[j+1] = tmp;
//				}
//		}
		
	}
	
	public static int brPojavljivanja(int[] niz, int el) {
		int br = 0;
		
		for(int i=0;i<niz.length;i++)
			if(niz[i] == el)
				br++;
		
		return br;
	}
	
	public static int najcesciElement(int[] niz) {
		int vrijednost = niz[0];
		int brPojavlj = 0;
		
		for(int i=0;i<niz.length;i++)
			if(brPojavljivanja(niz, niz[i]) > brPojavlj) {
				brPojavlj = brPojavljivanja(niz, niz[i]);
				vrijednost = niz[i];
			}
	
		return vrijednost;
	}

	public static int najcesciElementSortiran(int[] niz) {
		int cnt = 1;
		int max_cnt = 1;
		int val = niz[0];
		
		for(int i=1;i<niz.length;i++) {
			if(niz[i] == niz[i-1])
				cnt++;
			else
				cnt = 1;
			
			if(cnt > max_cnt) {
				max_cnt = cnt;
				val = niz[i];
			}
		}
		
		return val;
	}

	public static int[] nizPrefSuma(int[] niz) {
		int[] prefSum = new int[niz.length];
		
		prefSum[0] = niz[0];
		
		for(int i=1;i<niz.length;i++)
			prefSum[i] = prefSum[i-1] + niz[i];
		
		return prefSum;
	}
	
	public static int maxPodnizPrefixSum(int[] niz) {
		int[] prefSum = nizPrefSuma(niz);
		
		int ms = 0;
		
		for(int i=0;i<niz.length;i++)
			for(int j=i+1;j<niz.length;j++) {
				int s = prefSum[j];
				if(i > 0)
					s -= prefSum[i - 1];
				
				if(s > ms)
					ms = s;
			}
		
		return ms;
	}

	public static int maxPodniz(int[] niz) {
		int ms = 0;
		int cs = 0;
		
		for(int i=0;i<niz.length;i++) {
			cs += niz[i];
			
			if(cs < 0)
				cs = 0;
			
			if(cs >ms)
				ms = cs;
		}
		
		return ms;
	}
}
