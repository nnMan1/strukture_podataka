package ulancanaLista;

public class CiklicnaLista {
	CvorListe poslednji;
	
	public CiklicnaLista() {
		poslednji = null;
	}
	
	public void dodajNaKraj(int x) {
		if(poslednji == null) {
			poslednji = new CvorListe(x, null);
			poslednji.setSljedeci(poslednji);
			return;
		}
		
		CvorListe novi = new CvorListe(x, poslednji.getSljedeci());
		poslednji.setSljedeci(novi); 
		poslednji = novi;
	}

	public void stampajListu() {
		if(poslednji == null)
			return;
		
		CvorListe it = poslednji.getSljedeci(); //pocetak liste
		
		while(true) {
			System.out.print(it.getVrijednost());
			if(it != poslednji)
				System.out.print("->");
			else
				break;
			it = it.getSljedeci();
		}
	}
}
