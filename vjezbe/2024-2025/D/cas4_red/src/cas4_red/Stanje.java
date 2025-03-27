package cas4_red;

public class Stanje {
	int v1;
	int v2;
	int br_koraka;
	Stanje parent;
	
	public Stanje(int v1, int v2, int br_koraka, Stanje parent) {
		this.v1 = v1;
		this.v2 = v2;
		this.br_koraka = br_koraka;
		this.parent = parent;
	}
}
