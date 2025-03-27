package cas4_read;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static Scanner in = new Scanner(System.in);
	
	/*
	 * 1. Napisati program koji stampa binarnu reprezentaciju
	 * svih prirodnih brojeva manjih od n
	 */
	
	public static void printBinary(int n) {
		if(n == 0)
			return;
		
		printBinary(n / 2);
		System.out.print(n % 2);
	}
	
	public static void binaryNumbers(int n) {
		for(int i=1;i<=n;i++) {
			printBinary(i);
			System.out.println();
		}
	}
	
	public static void binaryNumbersQueue(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		int br = 0;
		q.add(1);
		
		while(br < n) {
			int tmp = q.poll(); //uklanja elm sa pocetka reda
								//i vraca vrijednost
			
			System.out.println(tmp);
			br++;
			
			q.add(tmp*10);
			q.add(tmp*10 + 1);
		}
	}
	
	/*
	 * Napisati program koji za date posude kapaciteta m i n litara,
	 * stampa operacije presipanja vode koje treba izvrsiti da bi se 
	 * imjerilo tacno k litara. Potrebno je stampati 
	 * najkraci moguci niz operacija koje nas dovode do rjesenja
	 */
	
	public static void stampajKorake(Stanje s) {
		if(s == null)
			return;
		
		stampajKorake(s.prethodno);
		System.out.println(s.prva + " " + s.druga);
	}
	
	public static int posude(int n, int m, int k) {
		Queue<Stanje> q = new LinkedList<>();
		q.add(new Stanje(0, 0, 0, null));
		
		boolean[][] posjecen = new boolean[n+1][m+1];
		posjecen[0][0] = true;
		
		while(true) {
			if(q.isEmpty())
				return -1;
			
			Stanje s = q.element();
			q.remove();
			
			if(s.prva == k || s.druga == k) {
				stampajKorake(s);
				return s.br_koraka;
			}
			
			if(!posjecen[n][s.druga]) {
				q.add(new Stanje(n, s.druga, s.br_koraka + 1, s));
				posjecen[n][s.druga] = true;
			}
			if(!posjecen[s.prva][m]) {
				q.add(new Stanje(s.prva, m, s.br_koraka + 1, s));
				posjecen[s.prva][m] = true;
			}
			if(!posjecen[0][s.druga]) {
				q.add(new Stanje(0, s.druga, s.br_koraka + 1, s));
				posjecen[0][s.druga] = true;
			}
			if(!posjecen[s.prva][0]) {
				q.add(new Stanje(s.prva, 0, s.br_koraka + 1, s));
				posjecen[s.prva][0] = true;
			}
			
			if(s.prva + s.druga <= m) {
				if(!posjecen[0][s.prva+s.druga]) {
					q.add(new Stanje(0, s.prva + s.druga, s.br_koraka + 1, s));
					posjecen[0][s.prva+s.druga] = true;
				}
			} else {
				if(!posjecen[s.prva-(m-s.druga)][m]) {
					q.add(new Stanje(s.prva - (m - s.druga), m, s.br_koraka + 1, s));
					posjecen[s.prva-(m-s.druga)][m] = true;
				}
			}
				
			if(s.prva + s.druga <= n) {
				if(!posjecen[s.prva + s.druga][0]) {
					q.add(new Stanje(s.prva + s.druga, 0, s.br_koraka + 1, s));
					posjecen[s.prva + s.druga][0] = true;
				}
			} else {
				if(!posjecen[n][s.druga-(n-s.prva)]) {
					q.add(new Stanje(n , s.druga - (n - s.prva), s.br_koraka + 1, s));
					posjecen[n][s.druga -(n-s.prva)] = true;
				}
			}
		}
	}

	
	/*
	 * Slikar paleta
	 */
	public static void stampaj(char[][] mapa) {
		for(int i=0;i<mapa.length;i++) {
			for(int j=0;j<mapa[0].length;j++) 
				System.out.print(mapa[i][j]);
			
			System.out.println();
		}
	}
	
	public static void slikar(char[][] mapa) {
		
		Queue<Polje> poplava = new LinkedList<Polje>();
		Queue<Polje> slikar = new LinkedList<Polje>();
		
		for(int i=0;i<mapa.length;i++)
			for(int j=0;j<mapa[0].length;j++) {
				if(mapa[i][j] == 'S')
					slikar.add(new Polje(i, j, 0));
				
				if(mapa[i][j] == '*')
					poplava.add(new Polje(i, j, 0));
			}
		
		for(int koraci=0;koraci < 3;koraci++) {
			while(!poplava.isEmpty() && poplava.element().dist == koraci) {
				Polje p = poplava.element();
				poplava.remove();
				
				if(p.x > 0 && (mapa[p.x-1][p.y] == '.' || mapa[p.x-1][p.y] == 'S') ) {
					mapa[p.x-1][p.y] = '*';
					poplava.add(new Polje(p.x-1, p.y, koraci+1));
				}
				
				if(p.y > 0 && (mapa[p.x][p.y-1] == '.' || mapa[p.x][p.y-1] == 'S' )) {
					mapa[p.x][p.y-1] = '*';
					poplava.add(new Polje(p.x, p.y-1, koraci+1));
				}
				
				if(p.x < mapa.length - 1 && (mapa[p.x+1][p.y] == '.' || mapa[p.x+1][p.y] == 'S' )) {
					mapa[p.x+1][p.y] = '*';
					poplava.add(new Polje(p.x+1, p.y, koraci+1));
				}
				
				if(p.y < mapa[0].length-1 && (mapa[p.x][p.y+1] == '.' || mapa[p.x][p.y+1] == 'S' )) {
					mapa[p.x][p.y+1] = '*';
					poplava.add(new Polje(p.x, p.y+1, koraci+1));
				}
			}
			
			stampaj(mapa);
		}
				
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = in.nextInt();
		int m = in.nextInt();
		
		char[][] mapa = new char[n][m];
	
		for(int i=0;i<n;i++) {
			String s = in.next();
			for(int j=0;j<m;j++)
				mapa[i][j] = s.charAt(j);
		}
		
		slikar(mapa);
		
		
	}

}
