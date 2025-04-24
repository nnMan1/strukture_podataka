package fajlovi;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fajlovi fajlovi = new Fajlovi();
		
		fajlovi.dodajFajl("a.tt", "Marko Markovic 2/24 \nJanko Jankovic 3/24");
		fajlovi.dodajFajl("a.txt", "Marko Markovic 2/24 \nJanko Jankovic 3/24");
		fajlovi.dodajFajl("c1.txt", "Ana Markovic 2/24 \nSanja Jankovic 3/24");
		fajlovi.dodajFajl("c2.txt", "Hana Markovic 2/24 \nMaja Jankovic 3/24");
		fajlovi.dodajFajl("c3.txt", "Hana Markovic 2/24 \nMaja Jankovic 3/24");

		fajlovi.pronadjiDuplikate();
	
	}

}
