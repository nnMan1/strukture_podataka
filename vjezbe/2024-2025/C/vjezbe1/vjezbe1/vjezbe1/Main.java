package vjezbe1;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static float vrijednostPolinoma(float[] poly, float x) {
		float p = 1;
		float rez = 0;
		
		for(int i=0;i<poly.length;i++) {
			rez += poly[i] * p;
			p *= x;
		}
		
		return rez;
	}
	
	public static void main(String[] args) {
		//System.out.print("Ovo je prvi cas iz Struktura podataka.");	
		Scanner input = new Scanner(System.in);
//		int x = input.nextInt();
//		int y = input.nextInt();
//		
//		System.out.println("" + x + y + " su vreijednosti koje je korisnik unio");
		
//		int[] niz = new int[10]; //niz inicijalizovan nulama
//		
//		niz[0] = 5;
//		niz[1] = 7;
//		niz[2] = 6;
//		
//		for(int i=0;i<niz.length;i++)
//			System.out.print(niz[i]+" ");
		
//		int[] niz = {31, 28, 31, 30 , 31 , 30, 31, 31, 30 , 31 ,30, 31};
		
		/*1. Ucita niz i sortiraju elementi niza
		 * Pvo se ucitava duzina niza a zatim elementi niza*/
		
		/*
		 * 2. naci element koji se javlja najveci broj puta u sortiranom nizu
		 * metoda uzima jedan argument koji predstavlja sortirani niz brojeva
		 * Pokusajte da rijesite zadatak koristeci jednu petlju
		 */
		
		/*
		 * 3. Niz poly cuva koeficijente polinoma P(x) = a_0 + a_1 * x + a_2 * x^2 + ... a_n * x ^ n
		 * Napisati metodu vrijednostPolinoma(float[] poly, float x), koja nalazi vrijenost polinoma P u tacki x.
		 * 1 + 2x + x^2 -> [1 2 1]
		 * vriejdnostPolinoma(poly, 5) = 1 + 10 + 25 = 36
		 * */
		
//		int n = input.nextInt();
//		float[] arr = new float[n + 1];
//		
//		for(int i=0; i<arr.length;i++)
//			arr[i] = input.nextFloat();
//		
//		float x = input.nextFloat();
//		
//		System.out.println("Vriejdnost polinoma je " + vrijednostPolinoma(arr, x));
		
//		int[] niz = Nizovi.ucitajNiz();
//		
//		Arrays.sort(niz);
//		//Nizovi.sort(niz);
//		
//		int najcesci = Nizovi.najcesciElementSortiran(niz);
//		System.out.println("Najcesci element je:" + najcesci);
		
		/* 4.
		 * Napisati metodu maxPodniz, koja nalazi maksimalan zbir uzastopnih elemenata niza 
		 * Primjer:
		 * 4 -5 2 3 7 -9 1 => 12
		 */
		
		int[] niz = Nizovi.ucitajNiz();
		System.out.println(Nizovi.maxPodniz(niz));

	}

}
