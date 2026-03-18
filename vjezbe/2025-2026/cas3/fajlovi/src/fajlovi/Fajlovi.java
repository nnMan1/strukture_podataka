package fajlovi;

public class Fajlovi {
	Cvor glava = null;
	
	private void dodajNaPocetak(String ime_fajla, String sadrzaj) {
		glava = new Cvor(ime_fajla, sadrzaj, glava);
	}
	
	private void dodajNaKraj(String ime_fajla, String sadrzaj) {
		if(glava == null) {
			dodajNaPocetak(ime_fajla, sadrzaj);
			return;
		}
		
		Cvor it = glava;
		
		while(it.sljedeci != null) 
			it = it.sljedeci;
		
		it.sljedeci = new Cvor(ime_fajla, sadrzaj, null);		
	}
	
	private void dodajPosle(Cvor cv, String ime_fajla, String sadrzaj) {
		cv.sljedeci = new Cvor(ime_fajla, sadrzaj, cv.sljedeci);
	}
	
	private void dodajPrije(Cvor cv, String ime_fajla, String sadrzaj) {
		dodajPosle(cv, ime_fajla, sadrzaj);
		String temp = cv.ime;
		cv.ime = cv.sljedeci.ime;
		cv.sljedeci.ime = temp;
		
		temp = cv.sadrzaj;
		cv.sadrzaj = cv.sljedeci.sadrzaj;
		cv.sljedeci.sadrzaj = temp;
	}
	
	public void	dodajFajl(String ime_fajla, String sadrzaj) {
		Cvor it = glava;
		
		while(it != null && it.ime.compareTo(ime_fajla) < 0) 
			it = it.sljedeci;
		
		if(it == null) 
			dodajNaKraj(ime_fajla, sadrzaj);
		else 
			dodajPrije(it, ime_fajla, sadrzaj);		
	}
	
	public Fajlovi pronadjiFajlove(String tekst) {
		Fajlovi ret = new Fajlovi();
		
		Cvor it = glava;
		
		while(it != null) {
			if(it.ime.contains(tekst))
				ret.dodajFajl(it.ime, it.sadrzaj);
			
			it = it.sljedeci;
		}
		
		return ret;
	}
	
	public void pronadjiDuplikate() {
		Cvor it = glava;
		
		while(it != null) {
			Cvor jt = glava;
			
			while(jt != null) {
				if(it != jt && it.sadrzaj.compareTo(jt.sadrzaj) == 0) {
					System.out.println(it);
					break;
				}
				jt = jt.sljedeci;
			}
			
			it = it.sljedeci;
		}
	}
	
	public void stampajListu() {
		Cvor it = glava;
		
		while(it != null) {
			System.out.println(it);
						
			it = it.sljedeci;
		}
	}
}
