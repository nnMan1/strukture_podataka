package prodavnica;

public class Artikal implements Comparable {
	String naziv;
	String kategorija;
	double cijena; 
	
	public Artikal(String naziv, String kategrija, double cijena) {
		this.naziv = naziv;
		this.kategorija = kategrija;
		this.cijena = cijena;
	}
	
	@Override
	public String toString() {
		return naziv + " - " + kategorija + " - " + cijena;
	}

	@Override
	public int compareTo(Object o) {
		Artikal a = (Artikal)o;
		if(cijena < a.cijena) return -1;
		if(cijena == a.cijena) return 0;
		return 1;
	}
}
