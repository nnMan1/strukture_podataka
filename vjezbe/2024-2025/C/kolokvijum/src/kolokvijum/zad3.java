package kolokvijum;

import java.util.Scanner;

public class zad3 {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		
		double[][] matr = new double[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				matr[i][j] = in.nextDouble();
		
		int m = in.nextInt();
		
		int cnt1 = 0, cnt2 = 0, cnt3 = 0;
		double sum1 = 0, sum2 = 0, sum3 = 0;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(Math.abs(i - j) <= m) {
					sum1 += matr[i][j];
					cnt1 ++;
				} else if(i < j) {
					sum2 += matr[i][j];
					cnt2 ++;
				} else {
					sum3 += matr[i][j];
					cnt3 ++;
				}
		
		double avg1 = sum1 / cnt1;
		double avg2 = sum2 / cnt2;
		double avg3 = sum3 / cnt3;
		
		System.out.printf("%.2f\n", avg1);
		System.out.printf("%.2f\n", avg2);
		System.out.printf("%.2f\n", avg3);
	}

}
