package cas5D;

public class Polje {
	int x;
	int y;
	int br_koraka;
	Polje prethnodno;
	
	public Polje(int x, int y, int br_koraka, Polje prethodno) {
		this.x = x;
		this.y = y;
		this.br_koraka = br_koraka;
		this.prethnodno = prethodno;
	}
}
