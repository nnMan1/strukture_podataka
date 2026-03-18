package dvostruko_ulancana_lista;

public class Cvor {
	int vrijednost;
	Cvor sljedeci;
	Cvor prethodni;
	
	public Cvor(int vrijenost) {
		this.vrijednost = vrijednost;
		this.sljedeci = null;
		this.prethodni = null;
	}
	
	public Cvor(int vrijednost, Cvor sljedeci) {
		this.vrijednost = vrijednost;
		this.sljedeci = sljedeci;
		this.prethodni = null;
	}
		
	public Cvor(int vrijednost, Cvor sljedeci, Cvor prethodni) {
		this.vrijednost = vrijednost;
		this.sljedeci = sljedeci;
		this.prethodni = prethodni;
	}
	
	
}
