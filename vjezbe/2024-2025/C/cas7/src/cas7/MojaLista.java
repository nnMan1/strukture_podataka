package cas7;

public class MojaLista {
	Cvor glava;
	private int br_elem;
	
	MojaLista() {
		this.glava = null;
		this.br_elem = 0;
	}
	
	public void dodajNaPocektak(int v) {
		Cvor novi = new Cvor(v, this.glava);
		this.glava = novi;
		br_elem ++;
	}
	
	public void stampajListu() {
		Cvor temp = this.glava;
		
		while(temp != null) {
			System.out.print(temp.vrijednost + " ");
			temp = temp.sljedeci;
		}
		
		System.out.println();
	}
	
	public int brojCvorova() {
		return br_elem;
//		int brojac = 0;
//		Cvor temp = this.glava;
//		
//		while(temp != null) {
//			brojac ++;
//			temp = temp.sljedeci;
//		}
//		
//		return brojac;
	}
	
	public void dodajNaKraj(int v) {
		Cvor novi = new Cvor(v, null);
		this.br_elem++;
		
		if(glava == null) {
			this.glava = novi;
			return;
		}
		
		Cvor tmp = glava;
		while(tmp.sljedeci != null) {
			tmp = tmp.sljedeci;
		}
		
		tmp.sljedeci = novi;
	}
	
	public void obrisiGlavu() {
		if(this.glava != null) {
			this.glava = glava.sljedeci;
			this.br_elem --;
		}
	}
	
	public void obrisiElement(int v) {
		//uklanja samo prvo pojavljivanje elementa v u listi
		Cvor temp = glava;
		Cvor prev = null;
		
		while(temp != null && temp.vrijednost != v) {
			prev = temp;
			temp = temp.sljedeci;
		}
		
		if(temp == null)
			return;
		
		if(temp != glava) 
			prev.sljedeci = temp.sljedeci;
		else 
			glava = temp.sljedeci;
		
		this.br_elem --;
	}
	
	public void obrisiSve(int v) {
		Cvor temp = glava;
		Cvor prev = null;
	
		while(temp != null) {
			if(temp.vrijednost == v) {
				if(temp != glava) 
					prev.sljedeci = temp.sljedeci;
				else 
					glava = temp.sljedeci;
				
				this.br_elem --;
			} else {
				prev = temp;
			}
			
			temp = temp.sljedeci;
		}
	}
		
}
