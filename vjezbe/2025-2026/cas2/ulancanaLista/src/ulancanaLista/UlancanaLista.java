package ulancanaLista;

public class UlancanaLista {
	CvorListe glava; 
	
	public UlancanaLista() {
		this.glava = null;
	}
	
	public void dodajPocetak(int vrijednost) {
		this.glava = new CvorListe(vrijednost, glava);
	}
	
	private void dodajPosle(CvorListe cv, int vrijednost) {
		CvorListe pomocni = new CvorListe(vrijednost, cv.getSljedeci());
		cv.setSljedeci(pomocni);
	}
	
	private void dodajPrije(CvorListe cv, int vrijednost) {
		dodajPosle(cv, vrijednost);
		cv.getSljedeci().setVrijednost(cv.getVrijednost());
		cv.setVrijednost(vrijednost);		
	}
	
	public void dodajPosle(int x, int vrijednost) {
		//posle svakog cvora koji sadrzi vriednost x dodaje novi cvor sa vrijednoscu y

		CvorListe it = glava;
		while(it != null) {
			if(it.getVrijednost() == x) {
				dodajPosle(it, vrijednost);
				it = it.getSljedeci();
			}
			it = it.getSljedeci();
		}
	}
	
	//dodajPoslePrvog(int x int vrijednost)
	//dodajPrijePrvog(int x, int vrijednost)
	//dodajPrije(int x, int vrijednsot)
	//...
	
	private void obrisiPosle(CvorListe cv) {
		//brise cvor koji se javlja posle cvora cv
		CvorListe sljedeci = cv.getSljedeci();
		cv.setSljedeci(sljedeci.getSljedeci());		
	}
	
	public void obrisi(int x) {
		//uklanja prvo pojavljivanje cvora sa vrijednoscu x iz liste
			
		CvorListe prethodni = null;
		CvorListe it = glava;
		
		while(it != null && it.getVrijednost() != x) {
			prethodni = it;
			it = it.getSljedeci();
		}
		
		if(it == null)
			return; //se x ne nalazi u listi
		
		if(it == glava)	{
			glava = it.getSljedeci(); //x je prvi element
			return;
		}
		
		obrisiPosle(prethodni);
				
	}
	
	public boolean sadrzi(int vrijednost) {
		CvorListe it = glava;
		
		while(it != null && it.getVrijednost() != vrijednost)
			it = it.getSljedeci();
		
		return it != null;
	}
	
	public void dodajNaKraj(int vrijednost) {
		if(glava == null) {
			dodajPocetak(vrijednost);
			return;
		}
		CvorListe it = glava;
		
		while(it.getSljedeci() != null) 
			it = it.getSljedeci();
		
		it.setSljedeci(new CvorListe(vrijednost, null));			
	}
	
	public void okreniListu() {		
		CvorListe pret = null;
		CvorListe it = glava;
		
		while(it != null) {
			CvorListe sljed = it.getSljedeci();
			it.setSljedeci(pret); //preusmjerimo pokazivac da pokazuje na pret
			pret = it;
			it = sljed;
		}
		
		glava = pret;
	}
	
	public void nadovezi(UlancanaLista l2) {
		if(this.glava == null) {
			this.glava = l2.glava;
			return;
		}
		
		CvorListe it = glava;
		
		while(it.getSljedeci() != null) 
			it = it.getSljedeci();
		
		it.setSljedeci(l2.glava);
	}
	
	public void stampajListu() {
		CvorListe it = glava;
		while(it != null) {
			System.out.print(it.getVrijednost());
			
			if(it.getSljedeci() != null)
				System.out.print("->");	
			
			it = it.getSljedeci();
		}
	}
}
