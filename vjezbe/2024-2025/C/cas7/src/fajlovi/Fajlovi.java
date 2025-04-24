package fajlovi;

public class Fajlovi {
	/*
	 * Napisati program za rad sa fajlovima
	 * Potrebno je omoguciti dodavanje fajla u sistem. 
	 * Dva fajla ne mogu imati isto ime. 
	 * Ako dodajemo sadrzaj sa istim imenom zaurirati vec dodati fajl
	 * Pretragu svih fajlova koji u svom imemu sadrze neki tekst
	 * Nalazenje duplikata po sadrzaju
	 * 
	 * Skup fajlova je predstavljen u listi
	 */
	Cvor glava;
	
	public void dodajFajl(String ime_fajla, String sadrzaj) {
		Cvor temp = glava;
		
		while(temp != null && temp.ime_fajla.compareTo(ime_fajla) != 0) {
			temp = temp.sljedeci;
		}
		
		if(temp != null) {
			temp.sadrzaj = sadrzaj;
		} else 
			glava = new Cvor(ime_fajla, sadrzaj, glava);
	}
	
	public void stampajFajlove() {
		for(Cvor it = glava; it != null ; it = it.sljedeci) {
			System.out.println(it);
		}
		
		System.out.println();
	}
	
	public void pronadjiFajlove(String tekst) {
		for(Cvor it = glava; it != null ; it = it.sljedeci) {
			if(it.ime_fajla.indexOf(tekst) != -1)
				System.out.println(it);
		}
		
		System.out.println();
	}
	
	public void pronadjiDuplikate() {
		//stampamo imena fajlova koji su diplikati
		Cvor temp1 = glava;
		while(temp1 != null) {
			Cvor temp2 = glava;
			while(temp2 != temp1) {
				if(temp1.sadrzaj.compareTo(temp2.sadrzaj) == 0) {
					System.out.println(temp1);
					break;
				}
				temp2 = temp2.sljedeci;
			}
			temp1 = temp1.sljedeci;
		}
	}
}
