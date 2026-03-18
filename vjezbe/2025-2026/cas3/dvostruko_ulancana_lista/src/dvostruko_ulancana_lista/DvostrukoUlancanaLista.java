package dvostruko_ulancana_lista;

public class DvostrukoUlancanaLista {
	Cvor glava;
	Cvor rep;
	
	public DvostrukoUlancanaLista() {
		this.glava = null;
		this.rep = null;
	}

	public void dodajNaPocetak(int vrijednost) {
		Cvor novi = new Cvor(vrijednost, glava);
		glava = novi;
		
		if(novi.sljedeci != null)
			novi.sljedeci.prethodni = novi;
		
		if(rep == null) //prazna_lista
			rep = novi;
	}
	
	public void dodajNaKraj(int vrijednost) {
		Cvor novi = new Cvor(vrijednost, null, rep);
		rep = novi;
		
		if(novi.prethodni != null)
			novi.prethodni.sljedeci = novi;
		
		if(glava == null)
			glava = novi;	
	}
	
	public void obrisiVrijednost(int vrijednost) {
		/*
		 * Brise prvo pojavljivanje vrijenosti iz liste;
		 */
		Cvor it = glava;
		
		while(it != null && it.vrijednost != vrijednost) 
			it = it.sljedeci;
		
		if(it == null)
			return;
		
		if(it.prethodni != null) 
			it.prethodni.sljedeci = it.sljedeci;
		else
			glava = it.sljedeci; //brisemo glavu liste
		
		if(it.sljedeci != null)
			it.sljedeci.prethodni = it.prethodni;
		else
			rep  = it.prethodni;
	}
	
	public void okreni() {
		Cvor it = glava;
		
		while(it != null) {
			Cvor sljedeci = it.sljedeci;
			
			it.sljedeci = it.prethodni;
			it.prethodni = sljedeci;
			
			it = sljedeci;
		}
		
		Cvor temp = glava;
		glava = rep;
		rep = temp;
	}
	
	public void dodajPosle(Cvor cv, int vrijednsot) {
		Cvor novi = new Cvor(vrijednsot, cv.sljedeci, cv);
		
		if(novi.sljedeci != null) 
			novi.sljedeci.prethodni = novi;
		else
			rep = novi;
		
		cv.sljedeci = novi;
	}
	
	public void dodajPrije(Cvor cv, int vrijensot) {
		if(cv == glava) 
			dodajNaPocetak(vrijensot);
		else {
			dodajPosle(cv.prethodni, vrijensot);
		}
	}
	
	public void dodajSortirano(int vrijenost) {
		/*
		 * Dodaje vrijenost prije prvog cvora koji je veci od vrijenosti koju dodajemo
		 * ili na kraj liste ako takav cvor ne postoji
		 */
		
		Cvor it = glava;
		
		while(it != null && it.vrijednost < vrijenost)
			it = it.sljedeci;
		
		if(it == null)
			dodajNaKraj(vrijenost);
		else 
			dodajPrije(it, vrijenost);
	}
	
	
	public void stampajListu() {
		Cvor it = glava;
		
		while(it != null) {
			System.out.print(it.vrijednost);
			
			if(it.sljedeci != null)
				System.out.print("->");
			
			it = it.sljedeci;
		}
	}
	
	public void stampajListuObrnuto() {
		Cvor it = rep;
		
		while(it != null) {
			System.out.print(it.vrijednost);
			
			if(it.prethodni != null)
				System.out.print("->");
			
			it = it.prethodni;
		}
	}
}
