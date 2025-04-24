package prodavnica;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Prodavnica {
	/*
	 * Prodavnica sadrzi spisak artikala.
	 * Za svaki artikal se zna njegov (String)naziv, (String)kategorija i (double)cijena
	 * 
	 * Imprlementirati katalog prodavnice kao ulancanu listu
	 * Svaki cvor liste cuva po jedan artikal.
	 * Omoguciti dodavanje novog artikla u prodavnicu
	 * Omoguciti prikaz sadrzaja prodavnice
	 * Omoguciti brisanje artikla iz prodavnice
	 * Omoguciti sortiranje sadrzaja prodavnice po cijeni
	 * Omoguciti uzimanje kategorije koja sadrzi najvise proizvoda
	 * 
	 * Korisiti listu implementiranu u paketu java.util.
	 */
	LinkedList<Artikal> katalog;
	
	public Prodavnica() {
		this.katalog = new LinkedList<Artikal>();
	}
	
	public void dodajArtikal(String naziv, String kategorija, double cijena) {
		this.katalog.add(new Artikal(naziv, kategorija, cijena));
	}
	
	public void prikaziPonudu() {
		for(Artikal a: katalog) {
			System.out.println(a);
		}
		System.out.println();
	}
	
	public void ukloniArtikal(String naziv) {
		katalog.removeIf(new Predicate<Artikal>() {
			@Override
			public boolean test(Artikal t) {
				// TODO Auto-generated method stub
				return t.naziv.equals(naziv);
			}
		});
	}
	
	public void sortirajPoCijeniRastuce() {
		Collections.sort(katalog);
	}
	
	public void sortirajPoCijeniOpadajuce() {
		Collections.sort(katalog, new Comparator<Artikal>() {
			@Override
			public int compare(Artikal o1, Artikal o2) {
				return -o1.compareTo(o2);
			}
		});
	}
	
	public String najvecaKategorija() {
		String najveca = "";
		int maxBrojac = 0;
		
		for(Artikal a: katalog) {
			int brojac = 0;
			for(Artikal b: katalog) {
				if(a.kategorija.equals(b.kategorija)) 
					brojac++;
			}
			
			if(brojac > maxBrojac) {
				maxBrojac = brojac;
				najveca = a.kategorija;
			}
		}
		return najveca;
	}
	
	
}
