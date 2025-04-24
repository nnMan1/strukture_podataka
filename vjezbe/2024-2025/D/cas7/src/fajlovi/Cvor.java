package fajlovi;

public class Cvor {
	String ime_fajla;
	String sadrzaj;
	Cvor sljedeci;
	
	public Cvor(String ime_fajla, String sadrzaj, Cvor sljedeci) {
		this.ime_fajla = ime_fajla;
		this.sadrzaj = sadrzaj;
		this.sljedeci = sljedeci;
	}
	
	@Override
	public String toString() {
		return ime_fajla + ":\n" + sadrzaj;
	}
}
