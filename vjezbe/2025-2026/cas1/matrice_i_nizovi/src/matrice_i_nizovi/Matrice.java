package matrice_i_nizovi;

import java.util.Scanner;

public class Matrice {
	
	public static int[][] ucitajMatricu() {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matr = new int[n][m];
		
		for(int i=0;i<n;i++) 
			for(int j=0;j<m;j++)
				matr[i][j] = in.nextInt();
		
		in.close();

		return matr;
	}
	
	public static void stampajMatricu(int[][] matr) {
		int n = matr.length;
		int m = matr[0].length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				System.out.print(matr[i][j] + " ");
			System.out.println();
		}
	}
	
	public static boolean toplicova(int[][] matr) {
		
		int n = matr.length;
		int m = matr[0].length;
		
		for(int s=0;s<m;s++) {
			int i = 0;
			int j = s;
			while(i < n - 1 && j < m - 1) {
				if(matr[i][j] != matr[i+1][j+1])
					return false;
				i++;
				j++;
			}
		}
		
		for(int s=1;s<n;s++) {
			int i = s;
			int j = 0;
			while(i < n - 1 && j < m - 1) {
				if(matr[i][j] != matr[i+1][j+1])
					return false;
				i++;
				j++;
			}
		}
		
		return true;
	}
	
	public static boolean toplicova2(int[][] matr) {
		int n = matr.length;
		int m = matr[0].length;
		
		for(int i=0;i<n-1;i++)
			for(int j=0;j<m-1;j++)
				if(matr[i][j] != matr[i+1][j+1])
					return false;
		
		return true;
	}
}
