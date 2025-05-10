package cas9;

public class Cvor {
	int vrijednost;
	Cvor lijevi;
	Cvor desni;
	
	public Cvor(int vrijednost) {
		this.vrijednost = vrijednost;
		this.lijevi = null;
		this.desni = null;
	}
}
