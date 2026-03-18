package fajlovi;

public class Cvor implements Comparable<Cvor> {
	String ime;
	String sadrzaj;
	
	Cvor sljedeci;
	
	public Cvor(String ime, String sadrzaj, Cvor sljedeci) {
		this.ime = ime;
		this.sadrzaj = sadrzaj;
		this.sljedeci = sljedeci;
	}

	@Override
	public int compareTo(Cvor o) {
		/*
		 * <0 => this < o
		 * = => this = o
		 * >0 => this > o
		 */
		return ime.compareTo(o.ime);
	}
	
	@Override
	public String toString() {
		return ime + " ( " + sadrzaj + ")";
	}
	
	
}
