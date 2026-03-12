package ulancanaLista;

public class CvorListe {
	private int vrijednost;
	private CvorListe sljedeci;
	
	public CvorListe(int vrijednost, CvorListe sljedeci) {
		this.vrijednost = vrijednost;
		this.sljedeci = sljedeci;
	}
	
	public CvorListe getSljedeci() {
		return sljedeci;
	}
	public void setSljedeci(CvorListe sljedeci) {
		this.sljedeci = sljedeci;
	}
	public int getVrijednost() {
		return vrijednost;
	}
	public void setVrijednost(int vrijednost) {
		this.vrijednost = vrijednost;
	}
	
	
}
