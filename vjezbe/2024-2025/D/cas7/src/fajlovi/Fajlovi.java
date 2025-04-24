package fajlovi;

public class Fajlovi {
	/*
	 * Napisati program za rad sa fajlovima. 
	 * Fajl je predstavljen nazivom, sadrzajem
	 * Dva fajla ne mogu imati isto ime
	 * 
	 * Omoguciti dodavanje fajla u sistem
	 * Ako se fajl sa istim imenom vec nalazi u sistemu 
	 * potrebno mu je samo azurirati sadrzaj.
	 * 
	 * Omoguciti pretragu fajlova po nazivu. Portebno je 
	 * stampati sve fajlove koji sadrze neki tekst u svom 
	 * nazivu
	 * 
	 * Omoguciti nalazenje duplikata u spisku fajlova
	 * Fajl je duplitat ako postoji fajl sa istim sadrzajem.
	 */
	
	Cvor glava;
	
	public void Fajlovi() {
		this.glava = null;
	}
	
	public void dodajFajl(String ime_fajla, String sadrzaj) {
		Cvor temp = glava;
		
		while(temp != null && temp.ime_fajla.compareTo(ime_fajla) != 0) {
			temp = temp.sljedeci;
		}
		
		if(temp == null) {
			glava = new Cvor(ime_fajla, sadrzaj, glava);
		} else {
			temp.sadrzaj = sadrzaj;
		}
	}
	
	public void stampajFajlove() {
		Cvor temp = glava;
		
		while(temp != null) {
			System.out.println(temp.ime_fajla + ":\n" + temp.sadrzaj);
			temp = temp.sljedeci;
		}
		
		System.out.println();
	}
	
	public void pronadjiFajlove(String tekst) {
		Cvor temp = glava;
		
		while(temp != null) {
			if(temp.ime_fajla.indexOf(tekst) != -1) 
				System.out.println(temp);
			
			temp = temp.sljedeci;
		}
		
		System.out.println();
	}
	
	public void pronadjiDuplikate() {
		for(Cvor it=glava; it != null ;it = it.sljedeci) {
			for(Cvor jt=glava; jt != null ;jt = jt.sljedeci) {
				if(it == jt)
					continue;
				
				if(it.sadrzaj.compareTo(jt.sadrzaj) == 0) {
					System.out.println(it);
				}
			}
		}
	}
}
