package cas2_matrice;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static Scanner in;
	
	/*
	 * 1. napisati metodu void stampajMatricu(int[][] matr) koja stampa matricu
	 */
	public static void stampajMatricu(int[][] matr) {
		for(int i=0;i<matr.length;i++) {
			for(int j=0;j<matr[0].length;j++)
				System.out.print(matr[i][j] + " ");
			System.out.println();
		}

		System.out.println();
	}
	
	/*
	 * 2. napisati metodu void ucitajMatricu(int[][] matr) 
	 * koja popunjava matricu brojevima sa standardnog ulaza
	 */
	public static void ucitajMatricu(int[][] matr) {
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<matr[0].length;j++)
				matr[i][j] = in.nextInt();
	}
	
	/*
	 * 3. napisati metodu void popuniMatricu(int[][] matr) 
	 * koja popunjava matricu slucajnim brojevima
	 */
	public static void popuniMatricu(int[][] matr) {
		Random rand = new Random();
		
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<matr[0].length;j++)
				matr[i][j] = rand.nextInt(100); //slucajan cio broj izmedju 0 i 100
	}
	
	/*
	 * 4. Napisati funkciju int sumaMatrice(int mat[][]) koja izračunava 
	 * zbir elemenata matrice sa parnim indeksom reda i neparnim indeksom kolone.
	 */
	
	public static int sumaMatrice(int[][] matr) {
		int s = 0;
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<matr[0].length;j++)
				if(i % 2 == 0 && j % 2 == 1)
					s += matr[i][j];
		
		return s;
	}
	
	/*
	 * 5. Napisati funkciju void lokalni_maksimumi(int mat[][]) koja 
	 * određuje i štampa pozicije (indekse) svih "lokalnih maksimuma" u matrici. 
	 * Element mat[i][j] matrice mat je "lokalni maksimum" ako je veći ili jednak 
	 * od svih njemu susjednih elemenata.
	 */
	
	public static void lokalni_maksimum(int matr[][]) {
		for(int i=0;i<matr.length;i++) {
			for(int j=0;j<matr[0].length;j++) {
				boolean maksimum = true;
				
//				if(matr[i][j] < matr[i-1][j] && i > 0)
				if(i > 0 && matr[i][j] < matr[i-1][j])
					maksimum = false;				
				if(i < matr.length-1 && matr[i][j] < matr[i+1][j])
					maksimum = false;			
				if(j > 0 && matr[i][j] < matr[i][j-1])
					maksimum = false;				
				if(j < matr[0].length - 1 && matr[i][j] < matr[i][j+1])
					maksimum = false;
				
				if(maksimum) 
					System.out.println("("+i+","+j+")");
			}
		}
	}

	/*
	 *     5. Napisati program koji provjerava da li je data 
	 *     matrica cijelih brojeva Toplicova. Matrica se smatra Toplicovom ukoliko 
	 *     za svaku dijagonalu paralelnu glavnoj dijagonali 
	 *     (uključujući i samu glavnu dijagonalu) važi da su svi elementi na 
	 *     dijagonali jednaki. Ukoliko je matrica Toplicova odštampati riječ “DA”. 
	 *     U suprotnom odštampati riječ “NE”.
	 */
	
	public static boolean toplicova(int[][] matr) {
		//provjeravamo dijagonale koje nisu ispod glavne
		for(int j=0;j<matr[0].length;j++) {
			int i=0, k=j;
			while(i < matr.length && k<matr[0].length) {
				if(matr[0][j] != matr[i][k])
					return false;
				
				i++;
				k++;
			}
		}
		
		for(int i=1;i<matr.length;i++) {
			int j=0, k=i;
			while(k < matr.length && j<matr[0].length) {
				if(matr[i][0] != matr[k][j])
					return false;
				
				j++;
				k++;
			}
		}
		
		return true;
	}
	
	public static boolean toplicova2(int[][] matr) {
		for(int i=1;i<matr.length;i++)
			for(int j=1;j<matr[0].length;j++)
				if(matr[i][j] != matr[i-1][j-1])
					return false;
		
		return true;
	}
	
	public static void popuniMatricu2(int[][] matr) {
		int br = 0;
		
		for(int j=0;j<matr[0].length + matr.length - 1;j++) {
			int i = 0;
			int k = j;
			
			while(i < matr.length && k >= 0) {
				if(k < matr[0].length)
					matr[i][k] = br++;
				i++;
				k--;
			}
		}
	}
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		// TODO Auto-generated method stub
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matr = new int[n][m];
		
		popuniMatricu2(matr);
//		ucitajMatricu(matr);
		stampajMatricu(matr);
//		System.out.println(toplicova2(matr) ? "DA" : "NE");
		
//		lokalni_maksimum(matr);
//		System.out.println("Suma matrice je: " + sumaMatrice(matr));
		
	}

}
