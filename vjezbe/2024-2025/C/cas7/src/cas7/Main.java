package cas7;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		MojaLista lista = new MojaLista();
		
		lista.dodajNaPocektak(5);
		lista.dodajNaPocektak(4);
		lista.dodajNaPocektak(9);
		lista.dodajNaPocektak(3);
			
		lista.stampajListu();
		
		lista.dodajNaKraj(-2);
		lista.dodajNaKraj(9);
		lista.dodajNaKraj(5);
		
		lista.stampajListu();
		
		lista.obrisiGlavu();
		lista.stampajListu();
		
		lista.obrisiElement(5);
		lista.stampajListu();
		
		lista.obrisiSve(9);
		lista.stampajListu();
		
		System.out.println("Lista ima " + lista.brojCvorova() + " elemenata");
	}
}
