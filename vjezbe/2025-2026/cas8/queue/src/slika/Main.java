package slika;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
public static Scanner scanner = new Scanner(System.in);
	
	public static String[] ucitajMatricu() {
		int r = scanner.nextInt(), s = scanner.nextInt();
		
		String[] data = new String[r];
		
		for(int i=0;i<r;i++)
			data[i] = scanner.next();
		
		return data;
	}
	
	public static void stampajMatricu(char[][] matr) {
		for(int i=0;i<matr.length;i++) {
			for(int j=0;j<matr[0].length;j++)
				System.out.print(matr[i][j] + " ");
			
			System.out.println();
		}
	}
	
	public static Polje pronadji(String[] matr, char c) {
		for(int i=0;i<matr.length;i++) {
			if(matr[i].indexOf(c) != -1)
				return new Polje(i, matr[i].indexOf(c));
		}
		
		return null;
	}
	
	public static int slikar(String[] matr) {
		Polje s = pronadji(matr, 'S');
		Polje p = pronadji(matr, '*');
		Polje d = pronadji(matr, 'D');
		
		char[][] visited = new char[matr.length][matr[0].length()];
		for(int i=0;i<visited.length;i++)
			for(int j=0;j<visited[0].length;j++)
				visited[i][j] = ' ';
		
		visited[s.x][s.y] = 'S';
		visited[p.x][p.y] = '*';
		
		Queue<Polje> p_queue = new LinkedList<>();
		Queue<Polje> s_queue = new LinkedList<>();
		
		s.t = 0;
		p.t = 0;
		p_queue.add(p);
		s_queue.add(s);
		
		int t = 0;
		while(true) {
			while(!p_queue.isEmpty() && p_queue.peek().t == t) {
				p = p_queue.poll();
				int[] dx = {-1, 0, 1, 0};
				int[] dy = {0, -1, 0, 1};
				for(int i=0;i<4;i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if(nx >= 0 && ny >= 0 && nx < visited.length && ny < visited[0].length && matr[nx].charAt(ny) != 'X' && matr[nx].charAt(ny) != 'D' && visited[nx][ny] != '*') {
						visited[nx][ny] = '*';
						p_queue.add(new Polje(nx, ny, t + 1));
					}
				}
			}
			
			while(!s_queue.isEmpty() && s_queue.peek().t == t) {
				s = s_queue.poll();
				int[] dx = {-1, 0, 1, 0};
				int[] dy = {0, -1, 0, 1};
				for(int i=0;i<4;i++) {
					int nx = s.x + dx[i];
					int ny = s.y + dy[i];
					
					if(nx == d.x && ny == d.y) 
						return t + 1;
					
					
					if(nx >= 0 && ny >= 0 && nx < visited.length && ny < visited[0].length && matr[nx].charAt(ny) != 'X' && visited[nx][ny] == ' ') {
						visited[nx][ny] = 'S';
						s_queue.add(new Polje(nx, ny, t + 1));
					}
				}
			}
			
			t++;
			stampajMatricu(visited);
			System.out.println();
			System.out.println();
			
			if(p_queue.isEmpty() && s_queue.isEmpty())
				break;
		}
		
				
		
		return -1;		
	}

	public static void main(String[] args) {
		
		String[] matr = ucitajMatricu(); 
		System.out.println(slikar(matr));
	}
}
