package cas1;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static int inc(int x) {
		return x++;
	}
	
	/*
	 * 0. Napisati metodu koja stampa niz arr
	 */
	
	public static void stampaj(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	
	/*
	 * 1. napisati metodu pronadji koja kao argumente uzima 
	 * niz cijelih brojeva, i jedan cio broj.
	 * Potrebno je vratitit indeks prvog pojavljivanja broja 
	 * koji je predat kao argument ili -1 ako broj nije pronadjen
	 */
	public static int pronadji(int[] a, int n) {
		for(int i=0;i<a.length;i++) {
			if(a[i] == n)
				return i;
		}
		
		return -1;
	}
	
	/*
	 * 2. napisati metodu najcesciElement koja nalazi element koji 
	 * se javlja najveci broj puta u nizu arr koji  se predaje kao argument
	 */
	
	public static int brPojavljivanja(int[] a, int x) {
		int br = 0;
		
		for(int i=0;i<a.length;i++)
			if(a[i] == x)
				br ++;
		
		return br;
	}
	
	public static int najcesciElement(int[] a) {
		int max_cnt = 0; 
		int max_vrij = a[0]; 
		
		for(int i=0;i<a.length;i++) {
			int cnt = brPojavljivanja(a, a[i]);
			
			if(cnt > max_cnt) {
				max_cnt = cnt;
				max_vrij = a[i];
			}
		}
		
		return max_vrij;
	}
	
	/*
	 * 3. napisati metodu najcesciElementSort koja nalazi element
	 * koji se javlja najveci broj puta u sortiranom nizu
	 */
	
	public static int najcesciElementSort(int[] a) {
		int temp_elem = a[0];
		int temp_cnt = 0;
		int max_cnt = 0;
		int max_elem = 0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i] == temp_elem) 
				temp_cnt++;
			else {
				temp_elem = a[i];
				temp_cnt = 1;
			}
			
			if(temp_cnt > max_cnt) {
				max_cnt = temp_cnt;
				max_elem = temp_elem;
			}
		}
		
		return max_elem;
	}
	
	/*
	 * 4. napisati metodu sortiraj, koja sortira niz cijelih brojeva
	 */
	
	public static void sortiraj(int[] a) {
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a.length-1;j++)
				if(a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
	}

	/*
	 * 5. napisati metodu bez duplikata, koja vraca niz koji sadrzi 
	 * sve elemente niza koji se predaje kao argument i ne sadrzi duplikate
	 * [4 5 2 1 2 5] -> [4 5 2 1]
	 */
	public static int[] bezDuplikata(int[] a) {
		int[] temp = new int[a.length];
		int br_elem = 0;
		
		for(int i=0;i<a.length;i++) {
			
			boolean pronadjen = false;
			for(int j=0;j<br_elem;j++) 
				if(a[i] == temp[j]) {
					pronadjen = true;
					break;
				}
			
			if(!pronadjen) 
				temp[br_elem++] = a[i];
			
		}
		
		int[] ret = new int[br_elem];
		for(int i=0;i<br_elem;i++)
			ret[i] = temp[i];
		
		return ret;
	}

	/*
	 * 6. Napisati medodu unija koja vraca 
	 * uniju dva skupa predstavljena nizovima cijelih brojva
	 */
	public static int[] unija(int[] a, int[] b) {
		int[] ret = new int[a.length + b.length];
		
		for(int i=0;i<a.length;i++)
			ret[i] = a[i];
		
		for(int i=0;i<b.length;i++)
			ret[a.length+i] = b[i];
		
		return bezDuplikata(ret);
	}
	
	/*
	 * 7. Napisati medodu maksimalanPodniz, koja nalazi maksimalan zbir uzastopnih
	 * elemenata niza arr koji se predaje kao argument
	 */
	
	public static int maksimalanPodniz(int[] a) {
		int max_zbir = 0;
		
		for(int poc=0;poc<a.length;poc++) {
			int zbir=0;

			for(int kraj=poc;kraj<a.length;kraj++) {
				zbir += a[kraj];
				
				if(zbir > max_zbir)
					max_zbir = zbir;
			}
		}
		
		return max_zbir;
	}
	
	public static int[] prefixNiz(int[] a) {
		int[] prefArr = new int[a.length];
		prefArr[0] = a[0];
		
		for(int i=1;i<a.length;i++)
			prefArr[i] = prefArr[i-1] + a[i];
		
		return prefArr;
	}
	
	public static int maksimalanPodnizPrefArr(int[] a) {
		
		int[] pref_arr = prefixNiz(a);
		int max_zbir = 0;
		
		for(int poc=0;poc<a.length;poc++) {
			int zbir=0;

			for(int kraj=poc;kraj<a.length;kraj++) {
				zbir = pref_arr[kraj];
				if(poc > 0)
					zbir -= pref_arr[poc - 1];
				
				if(zbir > max_zbir)
					max_zbir = zbir;
			}
		}
		
		return max_zbir;
	}
	
	public static int maksimalniPodnizLinear(int[] a) {
		int max_sum = 0;
		int curr_sum = 0;
		
		for(int i=0;i<a.length;i++) {
			if(curr_sum < 0)
				curr_sum = a[i];
			else
				curr_sum += a[i];
			
			if(curr_sum > max_sum)
				max_sum = curr_sum;
		}
		
		return max_sum;
	}
	
	/*
	 * 8. Polinom P(x) = a_0 + a_1*x + a_2*x^2 + a_3*x^3 + ... + a_x * x^n
	 * prestavljen je nizom [a_0, a_1, ... a_n]. Napisati medou 
	 * vrijednostPolinoma(float[] poly, float x), koja racuna vrijednost
	 * polinoma poly u cacki x.
	 * Primjer:
	 * Za polinom 1 + 2x + x^2 i x = 5 potrebno je vratiti 36.
	 */
	
	public static float vrijednostPolinoma(float[] poly, float x) {
		float rez = 0;
		int x_i = 1; //pamti koliko je x^i
		
		for(int i=0;i<poly.length;i++) {
			rez += poly[i] * x_i;
			x_i *= x;
		}
		
		return rez;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Test");
//		int x = 5;
//		int y = 6;
//		System.out.println(x+y+"=x");
		
		Scanner in = new Scanner(System.in);
//		int x = in.nextInt(); 
//		x=inc(x);
//		System.out.println(x);
		
//		int[] arr = new int[10];
//		arr[0] = 5;
//		arr[1] = 6;
//		arr[2] = 4;
//		
//		for(int i=0;i<10;i++)
//			System.out.print(arr[i]+" ");
//		
//		int n = in.nextInt();
//		int[] arr = new int[n];
//		
//		for(int i=0;i<n;i++)
//			arr[i] = in.nextInt();
//		
//		int x = in.nextInt();
//		System.out.println(pronadji(arr, x));
//		System.out.println(najcesciElement(arr));
		
//		Arrays.sort(arr);
//		stampaj(arr);
//		System.out.println();
//		System.out.println(najcesciElementSort(arr));
		
//		int[] brr = bezDuplikata(arr);
//		stampaj(brr);
		
//		System.out.print("Unesite broj elemenata skupa a: ");
//		int n = in.nextInt();
//		
//		int[] a = new int[n];
//		System.out.println("Unesite elemente skupa a");
//		for(int i=0;i<a.length;i++)
//			a[i] = in.nextInt();
//		
//		System.out.print("Unesite broj elemenata skupa b: ");
//		int m = in.nextInt();
//		
//		int[] b = new int[m];
//		System.out.println("Unesite elemente skupa b");
//		for(int i=0;i<b.length;i++)
//			b[i] = in.nextInt();
//		
//		stampaj(unija(a, b));
		
		
//		System.out.println(maksimalniPodnizLinear(arr));
		
		System.out.println("Unesite stepen polinoma: ");
		int n = in.nextInt();
		float[] arr = new float[n+1];
		
		System.out.println("Unesite koeficijente polinoma: ");
		for(int i=0;i<n+1;i++)
			arr[i] = in.nextFloat();
		
		System.out.println("Unesite x: ");
		float x = in.nextFloat();
		
		System.out.println("Vrijednost polinoma je: "+vrijednostPolinoma(arr, x));
		
		
	}
}
