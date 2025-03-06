package cas2;
import java.util.Scanner;
import java.util.Random;

public class Main {
	
	/*
	 * 1. Napisati metodu void stampajMatricu(int[][] matr) 
	 */
	public static void stampajMatricu(int[][] matr) {
		for(int i=0;i<matr.length;i++) {
			for(int j=0;j<matr[0].length;j++)
//				System.out.print(matr[i][j]+" ");
				System.out.printf("%4d", matr[i][j]);
			System.out.println();
		}
	}
	
	/*
	 * 2. Napisati metodu void ucitajMatricu(int[][] matr) 
	 */
	public static void ucitajMatricu(int[][] matr) {
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<matr[0].length;j++)
				matr[i][j] = in.nextInt();
	}

	
	/*
	 * 3. Napisati metodu void popuniMatricu(int[][] matr), 
	 * koja popunjava matricu slucajnim brojevima izmedju 1 i 100
	 */
	public static void popuniMatricu(int[][] matr) {
		Random rand = new Random();
		
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<matr[0].length;j++)
				matr[i][j] = rand.nextInt(10);
	}
	
	/*
	 * 4. Napisati metodu int zbirElemenata(int[][] matr)
	 * koja vraca zbir elemenata matrice matr
	 */
	
	public static int zbirElemenata(int[][] matr) {
		int zbir = 0;
		
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<matr[0].length;j++)
				zbir += matr[i][j];
		
		return zbir;
	}
	
	/*
	 * 5. Napisati metodu int zbirGlavneDijag(int[][] matr) 
	 * koja vraca zbir elemenata sa glavne dijagonale
	 */
	public static int zbirGlvneDijagonale(int[][] matr) {
		int zbir = 0;
		for(int i=0;i<Math.min(matr.length, matr[0].length);i++)
			zbir += matr[i][i];
		
		return zbir;
	}
	
	/*
	 * 6. Napisati metodu int[] zbirPoKolonama(int[][] matr), koja 
	 * vraca zbir elemenata matrice po kolonama
	 */
	
	public static int[] zbirPoKolonama(int[][] matr) {
		int[] ret = new int[matr[0].length];
		
		for(int j=0;j<matr[0].length;j++)
			for(int i=0;i<matr.length;i++)
				ret[j] += matr[i][j];
		
		return ret;
	}
	
	/*
	 * 7. Napisati metodu int zbirIznadGlavneDijag(int[][] matr), koja
	 * vraca zbir elemenata koji se nalaze iznad glavne dijagonale kvadratne
	 * matrice matr.
	 */
	public static int zbirIznadGlavneDiag(int[][] matr) {
		int zbir = 0;
		
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<matr[0].length;j++)
				if(i < j)
					zbir += matr[i][j];
		
		return zbir; 
	}
	
	/*
	 * 7. Napisati metodu int zbirIznadSporedneDijag(int[][] matr), koja
	 * vraca zbir elemenata koji se nalaze iznad sporedne dijagonale kvadratne
	 * matrice matr.
	 */
	public static int zbirIznadSporedneDiag(int[][] matr) {
		int zbir = 0;
		
		for(int i=0;i<matr.length;i++) 
			for(int j=0;j<matr[0].length-1-i;j++)
				zbir += matr[i][j];
		
		return zbir;
	}
	
	/*
	 * 8. Napisati metodu int odbranaKraljevstva(int[][] matr, koja vraca
	 * broj vojnika na granici kvadratnog kraljevstva
	 */
	public static int odbranaKraljevstva(int[][] matr) {
		int zbir = 0;
		
		if(matr.length == 1)
			return matr[0][0];
		
		for(int j=0;j<matr[0].length;j++) {
			zbir += matr[0][j];
			zbir += matr[matr.length - 1][j];
		}
		
		for(int i=1;i<matr.length-1;i++) {
			zbir += matr[i][0];
			zbir += matr[i][matr[0].length - 1];
		}
		
		return zbir;
	}
	
	/*
	 * 9. Napisati metodu void lokalniMaksimumi(int[][] matr), koja nalazi
	 * i stampa koordinate svih lokalnih maksimuma matrice matr. Element na 
	 * poziciji i, j je lokalni maksimum ako je veci ili jednak od svih
	 * njemu susjednijh elemenata. Dva elementa su susjedna ako dijele
	 * zajednicku ivicu.
	 */
	
	public static void lokalniMaksimumi(int[][] matr) {
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<matr[0].length;j++) {
				boolean maks = true;
				
				if(i > 0 && matr[i][j] < matr[i-1][j])
					maks = false;
				
				if(i < matr.length - 1 && matr[i][j] < matr[i+1][j])
					maks = false;
				
				if(j > 0 && matr[i][j] < matr[i][j-1])
					maks = false;
				
				if(j < matr[0].length - 1 && matr[i][j] < matr[i][j+1])
					maks = false;
				
				if(maks) 
					System.out.println("("+i+","+j+")");
			}
	}
	
	/*
	 * 10. Napisati metodu boolean simetricna koja provjerava 
	 * da li je data kvadratna matrica simetricna u odnosu na glavnu dijagonalu. 
	 */
	public static boolean simetricna(int[][] matr) {
		
		for(int i=0;i<matr.length;i++)
			for(int j=0;j<i;j++) 
				if(matr[i][j] != matr[j][i])
					return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matr = new int[n][m];
		
//		ucitajMatricu(matr);
//		System.out.println("Broj vojnika na granici je: "+odbranaKraljevstva(matr));
		
//		int[][] matr2= new int[5][];
//		for(int i=0;i<5;i++)
//			matr2[i] = new int[i+1];
		
		popuniMatricu(matr);
		stampajMatricu(matr);
		System.out.println();
//						
//		System.out.println("Zbir elemenata matrice je: "+zbirElemenata(matr));
//		System.out.println("Zbir elemenata glavne dij je: "+zbirGlvneDijagonale(matr));
//
//		int[] zbir_kolona = zbirPoKolonama(matr);
//		
//		System.out.println("Zbir po kolonama je: ");
//		
//		for(int i = 0;i<zbir_kolona.length;i++)
//			System.out.print(zbir_kolona[i]+" ");
//		System.out.println();
//		
//		System.out.println("Zbir elemenata iznad glavne dijagonele je: " + 
//		zbirIznadGlavneDiag(matr));
//		
//		System.out.println("Zbir elemenata iznad sporedne dijagonele je: " + 
//				zbirIznadSporedneDiag(matr));
		 
//		matr[0][2] = 5;
//		matr[1][3] = 4;
//		matr[-7][3] = 9;
		
		System.out.println("Lokalni maksimumi su: ");
		lokalniMaksimumi(matr);
		
		
	}

}
