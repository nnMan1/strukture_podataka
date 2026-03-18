package fajlovi;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fajlovi fajlovi = new Fajlovi();
		fajlovi.dodajFajl("a.txt", "sadrzaj 1");
		fajlovi.dodajFajl("studenti", "Marko, Ana, Petar");
		fajlovi.dodajFajl("c.txt", "sadrzaj 2");
		fajlovi.dodajFajl("d.txt", "sadrzaj 2");
		
//		fajlovi.stampajListu();
		
//		fajlovi.pronadjiFajlove(".txt").stampajListu();
		fajlovi.pronadjiDuplikate();
	}

}
