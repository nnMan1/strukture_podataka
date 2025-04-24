package cas7;

public class MojaLista {
	Cvor glava;
	
	public MojaLista() {
		glava = null;
	}
	
	public void dodajNaPocetak(int v) {
		Cvor novi = new Cvor(v, glava);
		glava = novi;
	}
	
	public void stampajListu() {
		Cvor temp = glava;
		
		while(temp != null)  {
			System.out.print(temp.vrijednost + " ");
			temp = temp.sljedeci;
		}
		
		System.out.println();
	}
	
	public int brojCvorova() {
		int br = 0;
		Cvor temp = glava;
		
		while(temp != null)  {
			br++;
			temp = temp.sljedeci;
		}
		
		return br;		
	}
	
	public void dodajNaKraj(int v) {
		if(glava == null) {
			glava = new Cvor(v, null);
			return;
		}
		
		Cvor temp = glava;
		while(temp.sljedeci != null) {
			temp = temp.sljedeci;
		}
		
		temp.sljedeci = new Cvor(v, null);
	}
	
	public void obrisiGlavu() {
		if(glava == null)
			return;
		glava = glava.sljedeci;
	}
	
	public void obrisiElement(int v) {
		//brise prvo pojavljivanje elementa v iz liste
		Cvor temp = glava;
		Cvor pret = null;
		
		while(temp != null && temp.vrijednost != v) {
			pret = temp;
			temp = temp.sljedeci;
		}
		
		if(temp == null)
			return;
		
		if(temp == glava) 
			glava = glava.sljedeci;
		else
			pret.sljedeci = temp.sljedeci;
	}
	
	public void obrisiSve(int v) {
		Cvor temp = glava;
		Cvor pret = null;
		
		while(temp != null) {
			if(temp.vrijednost == v) {
				if(temp == glava) 
					glava = glava.sljedeci;
				else
					pret.sljedeci = temp.sljedeci;
				
				temp = temp.sljedeci;
			} else {
				pret = temp;
				temp = temp.sljedeci;
			}
		}
	}	
}
