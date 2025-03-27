package cas4_read;

public class Stanje {
	int prva;
	int druga;
	int br_koraka;
	Stanje prethodno;
	
	public Stanje(int prva, int druga, int br_koraka, Stanje prethodno) {
		this.prva = prva;
		this.druga = druga;
		this.br_koraka = br_koraka;
		this.prethodno = prethodno;
	}
}
