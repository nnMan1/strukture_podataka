package matrice_i_nizovi;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
/*	
 *	  1. Napisati funckiju najcesciElemenetSortiran, koja uzima
 *    niz cijelih brojeva i vraca vrijednost elementa koji se javalja
 *    najveci broj puta.
 *   
 *     2. Napisati program koji provjerava da li je data 
 *     matrica cijelih brojeva Toplicova. Matrica se smatra Toplicovom ukoliko 
 *     za svaku dijagonalu paralelnu glavnoj dijagonali 
 *     (uključujući i samu glavnu dijagonalu) važi da su svi elementi na 
 *     dijagonali jednaki. Ukoliko je matrica Toplicova odštampati riječ “DA”. 
 *     U suprotnom odštampati riječ “NE”.
 */
	


	public static void main(String[] args) {
		/* zad1
		int[] arr = Nizovi.ucitajNiz();
//		uvecajElementeNiza(arr);
		System.out.println();
		
		System.out.println("Najcesci element sort arr:" + Nizovi.najcesciElement(arr));
		Nizovi.stampajNiz(arr);
		 */
		
		int[][] matr = Matrice.ucitajMatricu();
		Matrice.stampajMatricu(matr);
		System.out.println(Matrice.toplicova(matr) ? "DA" : "NE");


	}

}
