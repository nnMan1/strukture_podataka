package cas5D;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static Scanner in = new Scanner(System.in);
	
	public static void printSteps(Polje s) {
		if(s == null)
			return;
		
		printSteps(s.prethnodno);
		System.out.println(s.x + " " + s.y);
	}
	
	public static int skakac(int x1, int y1, int x2, int y2) {
		Queue<Polje> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[9][9];
		
		q.add(new Polje(x1, y1, 0, null)); //do polja x1, y1 stizemo za 0 koraka
		visited[x1][y1] = true;
		
		int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
		
		while(!q.isEmpty()) {
			Polje p = q.element();
			q.remove();
			
			if(p.x == x2 && p.y == y2) {
				printSteps(p);
				return p.br_koraka;
			}
			
			for(int i=0;i<8;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nt = p.br_koraka + 1;
				
				if(nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
					visited[nx][ny] = true;
					q.add(new Polje(nx, ny, nt, p));
				}
			}
		}
		return -1;
	}
	
	public static int[][] poplava(char[][] mapa, char c) {
		Queue<Polje> q = new LinkedList<>();
		
		int[][] vrijeme = new int[mapa.length][mapa[0].length];
		for(int i=0;i<vrijeme.length;i++)
			for(int j=0;j<vrijeme[0].length;j++)
				vrijeme[i][j] = Integer.MAX_VALUE;
		
		for(int i=0;i<mapa.length;i++)
			for(int j=0;j<mapa[0].length;j++) {
				if(mapa[i][j] == c) {
					vrijeme[i][j] = 0;
					q.add(new Polje(i, j, 0, null));
				}
			}
			
		while(!q.isEmpty()) {
			Polje p = q.element();
			q.remove();
			
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, -1, 0, 1};
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nt = p.br_koraka + 1;
				
				if(nx >= 0 && nx < vrijeme.length &&
				   ny >= 0 && ny < vrijeme[0].length &&
				   vrijeme[nx][ny] > nt && 
				   (mapa[nx][ny] == '.' || mapa[nx][ny] == 'S')) {
					vrijeme[nx][ny] = nt;
					q.add(new Polje(nx, ny, nt, p));
				}
			}
		}
		
		return vrijeme;
	}
	
	public static int slikar(char[][] mapa, int[][] vrijeme_poplave) {
		Queue<Polje> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[mapa.length][mapa[0].length];
				
		for(int i=0;i<mapa.length;i++)
			for(int j=0;j<mapa[0].length;j++) {
				if(mapa[i][j] == 'S') {
					q.add(new Polje(i, j, 0, null));
				}
			}
		
		while(!q.isEmpty()) {
			Polje p = q.element();
			q.remove();
			visited[p.x][p.y] = true;
			
			if(mapa[p.x][p.y] == 'D') {
				return p.br_koraka;
			}
			
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, -1, 0, 1};
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nt = p.br_koraka + 1;
				
				if(nx >= 0 && nx < vrijeme_poplave.length &&
				   ny >= 0 && ny < vrijeme_poplave[0].length &&
				   vrijeme_poplave[nx][ny] > nt && mapa[nx][ny] != 'X'&&
				   !visited[nx][ny]) {
					q.add(new Polje(nx, ny, nt, p));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
//		int x1=in.nextInt();
//		int y1 = in.nextInt();
//		
//		int x2 = in.nextInt();
//		int y2 = in.nextInt();
//		
//		System.out.println(skakac(x1, y1, x2, y2));
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		char[][] mapa = new char[n][m];
		for(int i=0;i<n;i++) {
			String s = in.next();
			for(int j=0;j<m;j++)
				mapa[i][j] = s.charAt(j);
		}
		
		int[][] vrijeme_poplave = poplava(mapa, '*');
						
		System.out.println(slikar(mapa, vrijeme_poplave));
	}
}	
