package liste;

public class Lista {
	Cvor glavaListe = null;
	
	void dodajNaPocetak(int vrijednsot) {
		this.glavaListe = new Cvor(vrijednsot, this.glavaListe);
	}
	
	void stampajListu() {
		Cvor it = glavaListe;
		
		while(it != null) {
			System.out.print(it.getVrijednost());
			if(it.getSljedeci() != null)
				System.out.print("->");
			
			it = it.getSljedeci();
		}
	}
	
}
