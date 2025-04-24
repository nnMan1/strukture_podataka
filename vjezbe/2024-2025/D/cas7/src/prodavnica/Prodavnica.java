package prodavnica;

import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.Comparator;

public class Prodavnica {

	/*
	 * Napisati program za rad sa katalogom neke prodavnice
	 * 
	 * Prdavnica prodaje Artikle. 
	 * Za svaki artikal zna se njegov naziv, kategorija i cijena
	 * 
	 * Potrebno je omoguciti dodavanje artikla u katalog
	 * Prikaz kataloga
	 * Uklanjanje artikla iz kataloga 
	 * Uklanjanje svih artikala cija je cijena veca od nekog praga
	 * Sortiranje kataloga po cijeni
	 * Nalazenje kategorije koja sadrzi najveci broj artikala
	 * 
	 * Korisiti Ulancanu listu iz paketa java.util
	 */
	
	LinkedList<Artikal> katalog;
	
	public Prodavnica() {
		this.katalog = new LinkedList<Artikal>();
	}
	
	public void dodajArtikal(String naziv, String kategorija, double cijena) {
		katalog.add(new Artikal(naziv, kategorija, cijena));
	}
	
	public void prikaziKatalog() {
		for(Artikal u: katalog) {
			System.out.println(u);
		}
		System.out.println();
	}
	
	public void ukloniArtikal(String naziv) {
		
		for(Artikal a: katalog)
			if(a.naziv.equals(naziv)) {
				katalog.remove(a);
				return;
			}				
		
//		katalog.removeIf(new Predicate<Artikal>() {
//			@Override
//			public boolean test(Artikal t) {
//				return t.naziv.equals(naziv);
//			}
//		});
	}
	
	public void ukloniSve(double prag) {
		katalog.removeIf(new Predicate<Artikal>() {
			@Override
			public boolean test(Artikal t) {
				return t.cijena > prag;
			}
		});
	}
	
	public void urediKatalogRastuce() {
		Collections.sort(katalog);
	}
	
	public void urediKatalogOpadajuce() {
		Collections.sort(katalog, new Comparator<Artikal>() {
			@Override
			public int compare(Artikal o1, Artikal o2) {
				return -o1.compareTo(o2);
			}
		});
	}
	
	public String najvecaKategorija() {
		String najveca = "";
		int maxBroj = 0;
		
		for(Artikal a: katalog) {
			int br = 0;
			for(Artikal b: katalog) {
				if(a.kategorija.equals(b.kategorija))
					br++;
			}
			
			if(br > maxBroj) {
				najveca = a.kategorija;
				maxBroj = br;
			}
		}
		
		return najveca;
	}
	
}
