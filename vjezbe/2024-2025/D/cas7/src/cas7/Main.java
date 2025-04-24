package cas7;

public class Main {
	public static void main(String[] args) {
		MojaLista lista = new MojaLista();
		lista.dodajNaPocetak(5);
		lista.dodajNaPocetak(6);
		lista.dodajNaPocetak(1);
		lista.dodajNaPocetak(3);
		lista.dodajNaPocetak(4);
		
		lista.stampajListu();
		System.out.println("Lista sadrzi " + lista.brojCvorova() + " cvorova");
	
		lista.dodajNaKraj(5);
		lista.dodajNaKraj(4);
		lista.stampajListu();
		System.out.println("Lista sadrzi " + lista.brojCvorova() + " cvorova");
	
		lista.obrisiGlavu();
		lista.stampajListu();
		System.out.println("Lista sadrzi " + lista.brojCvorova() + " cvorova");
	
		lista.obrisiElement(5);
		lista.stampajListu();
		System.out.println("Lista sadrzi " + lista.brojCvorova() + " cvorova");
	
		lista.dodajNaPocetak(4);
		lista.stampajListu();
		System.out.println("Lista sadrzi " + lista.brojCvorova() + " cvorova");
	
		lista.obrisiSve(4);
		lista.stampajListu();
		System.out.println("Lista sadrzi " + lista.brojCvorova() + " cvorova");
	
		
	}
}
