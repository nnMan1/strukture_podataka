package cas4_red;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	/*
	 * 1. Napisati program koji stampa sve prirodne brojeve manje od n
	 * u binarnom zapisu
	 */
	
	public static void pretvoriUBinarni(int n) {
		if(n == 0)
			return;
		
		pretvoriUBinarni(n / 2);
		System.out.print(n % 2);
	}
	
	public static void binarniBrojevi(int n) {
		for(int i=1;i<=n;i++) {
			pretvoriUBinarni(i);
			System.out.println();
		}
	}
	
	public static void binarniBrojeviQueue(int n) {
		Queue<Integer> q = new LinkedList<>();
		//bolje bi bilo koristiti red stringova
		//veliki bojevi nece da stanu u tip Integer
		
		int br = 1;
		q.add(1);
		
		while(br <= n) {
			br++;
			int tmp = q.poll(); //uzmete element sa pocetka reda
								//i ukolonite ga iz reda
			System.out.println(tmp);
			
			q.add(tmp*10);
			q.add(tmp*10+1);
		}
	}	
	
	/*
	 * 2. Napisati program koji pomocu posuda zapremni n litara i m litara
	 * mjeri tacno k litara vode. Stampati najmanji broj koraka potreban da se 
	 * stigne do rjesenja
	 */
	
	public static void printSteps(Stanje s) {
		if(s == null)
			return;
		
		printSteps(s.parent);
		System.out.println(s.v1 + " " + s.v2);
	}
	
	public static int posudeSaVodom(int m, int n, int k) {
		Queue<Stanje> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[m+1][n+1];
		
		q.add(new Stanje(0, 0, 0, null));
		visited[0][0] = true;
		
		while(q.size() > 0) {
			Stanje tren = q.poll();
			if(tren.v1 == k || tren.v2 == k) {
				printSteps(tren);
				return tren.br_koraka;
			}
			
			if(!visited[m][tren.v2]) {
				q.add(new Stanje(m, tren.v2, tren.br_koraka+1, tren));
				visited[m][tren.v2] = true;
			}
			
			if(!visited[tren.v1][n]) {
				q.add(new Stanje(tren.v1, n, tren.br_koraka+1, tren));
				visited[tren.v1][n] = true;
			}
			
			if(!visited[0][tren.v2]) {
				q.add(new Stanje(0, tren.v2, tren.br_koraka+1, tren));
				visited[0][tren.v2] = true;
			}
			
			if(!visited[tren.v1][0]) {
				q.add(new Stanje(tren.v1, 0, tren.br_koraka+1, tren));
				visited[tren.v1][0] = true;
			}

			if(tren.v1 <= n-tren.v2) {
				if(!visited[0][tren.v1 + tren.v2]) {
					q.add(new Stanje(0, tren.v1 + tren.v2, tren.br_koraka+1, tren));
					visited[0][tren.v1 + tren.v2] = true;
				}
			} else 
				if(!visited[tren.v1 - (n-tren.v2)][n]) {
					q.add(new Stanje(tren.v1 - (n-tren.v2), n, tren.br_koraka + 1, tren));
					visited[tren.v1 - (n-tren.v2)][n] = true;
				}
			
			if(tren.v2 <= m-tren.v1) {
				if(!visited[tren.v1+tren.v2][0]) {
					q.add(new Stanje(tren.v1+tren.v2, 0, tren.br_koraka+1, tren));
					visited[tren.v1+tren.v2][0] = true;
				}
			} else
				if(!visited[m][tren.v2 - (m-tren.v1)]) {
					q.add(new Stanje(m, tren.v2 - (m-tren.v1), tren.br_koraka+1, tren));
					visited[m][tren.v2 - (m-tren.v1)] = true;
				}
			}
		
		return -1;
	}	
	
	public static void main(String[] args) {
		
		System.out.println(posudeSaVodom(2, 7, 1));
	}
}
