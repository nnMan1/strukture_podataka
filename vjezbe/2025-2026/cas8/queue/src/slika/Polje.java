package slika;
import java.util.Scanner;

public class Polje {
	int x;
	int y;
	int t;
	
	public Polje(int x, int y) {
		this.x = x;
		this.y = y;
		t = -1;
	}
	
	public Polje(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return t != -1 ? "(" + x + ", " + y + ")" : "(" + x + ", " + y + ", " + t + ")"; 
	}
	
}
