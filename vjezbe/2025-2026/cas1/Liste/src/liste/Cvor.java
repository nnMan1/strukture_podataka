package liste;

public class Cvor {
	int vrijednost;
	Cvor sljedeci;
	
	public Cvor(int vrijednost, Cvor sljedeci) {
		this.vrijednost = vrijednost;
		this.sljedeci = sljedeci;
	}
	
	public int getVrijednost() {
		return this.vrijednost;
	}
	
	public Cvor getSljedeci() {
		return this.sljedeci;
	}
	
	public void setVrijednost(int vrijednost) {
		this.vrijednost = vrijednost;
	}
	
	public void setSeljdeci(Cvor sljedeci) {
		this.sljedeci = sljedeci;
	}
}
