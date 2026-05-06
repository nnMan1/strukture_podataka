package queue;

public class Stanje {
	
	int prva; //kolicina tecnosti u prvoj posudi
	int druga; // kolicina tecnosti u drugoj posudi
	Stanje prethodno;
	
	public Stanje(int prva, int druga, Stanje prethodno) {
		this.prva = prva;
		this.druga = druga;
		this.prethodno = prethodno;
	}

}
