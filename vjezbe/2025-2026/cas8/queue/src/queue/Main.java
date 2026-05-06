package queue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	/*
	 * 1. Napisati program koji stampa binarnu reprezentaciju
	 * svih prirodnih brojeva manjih od n	 * 
	 * */
	
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
		Queue<String> q = new LinkedList<String>();
		
		q.add("1");
		
		for(int i=1;i<=n;i++) {
			String s = q.poll();
			System.out.println(s);
			
			q.add(s + "0");
			q.add(s + "1");
		}
	}
	/*
	 * 2.
	 * Napisati program koji za date posude kapaciteta m i n litara,
	 * stampa operacije presipanja vode koje treba izvrsiti da bi se 
	 * imjerilo tacno k litara. Potrebno je stampati 
	 * najkraci moguci niz operacija koje nas dovode do rjesenja
	 * BFS-algoritam
	 * */
	
	public static int posude(int m, int n, int k) {
		Queue<Stanje> q = new LinkedList<Stanje>();
		q.add(new Stanje(0, 0, null));
				
		boolean[][] visited = new boolean[m+1][n+1];
		visited[0][0] = true;
		
		while(true) {
			
			if(q.isEmpty())
				break;
			
			Stanje s = q.remove();
			int x = s.prva, y = s.druga;
			
			if(s.prva == k || s.druga == k) { 
				System.out.println("Stigli smo do rjesenja");
				List<Stanje> put = new LinkedList<>();
				
				while(s != null) {
					put.add(s);
					s = s.prethodno;
				}
				
				put = put.reversed();
				
				for(Stanje i: put) {
					System.out.println(i.prva + " " + i.druga);
				}
				return 0;
			}
			
			if(!visited[m][y]) {
				q.add(new Stanje(m, y, s));
				visited[m][y] = true;
			}
			
			if(!visited[x][n]) {
				q.add(new Stanje(x, n, s));
				visited[x][n] = true;
			}
			
			if(x + y <= n) { 
				if(!visited[0][x+y]) {
					q.add(new Stanje(0, x + y, s));
					visited[0][x+y] = true;
				}
			} else
				if(!visited[x - (n - y)][n]) {
					q.add(new Stanje(x - (n - y), n, s));
					visited[x - (n - y)][n] = true;
				}
			
			if(x + y <= m) {
				if(!visited[x + y][0]) {
					q.add(new Stanje(x + y, 0, s));
					visited[x + y][0] = true;
				}
			} else
				if(!visited[m][y - (m - x)]) {
					q.add(new Stanje(m, y - (m - x), s));
					visited[m][y - (m - x)] = true;
				}
			
			if(!visited[0][y]) {
				q.add(new Stanje(0, y, s));
				visited[0][y] = true;
			}
			
			if(!visited[x][0]) {
				q.add(new Stanje(x, 0, s));
				visited[x][0] = true;
			}
		}
		
		System.out.println("ne pos rjesenje");
		return 0;
		
	}
	
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		binaryNumbers(23);
//		binaryNumbersQueue(23);
		posude(6, 2, 3);
		
//		ListQueue q = new ListQueue();
//		
//		q.add(3);
//		q.add(9);
//		q.add(5);
//		q.add(4);
//		
////		while(!q.isEmpty()) {
////			System.out.println(q.remove());
////		}
//		
//		Integer x;
//		while((x = q.pool()) != null) {
//		 	System.out.println(x);
//		}
		

//		Queue<Integer> q = new LinkedList<>();
//
//		q.add(3);
//		q.add(9);
//		q.add(5);
//		q.add(4);
//
//		while(!q.isEmpty()) {
//			System.out.println(q.remove());
//		}

		// ArrQueue q = new ArrQueue(5);
		
		// q.add(3);
		// q.add(9);
		// q.add(5);
		// q.add(4);
		
		// System.out.println(q);
		
		// Integer x;
		// while((x = q.pool()) != null) {
		// 	System.out.println(x);
		// }

	}

}
