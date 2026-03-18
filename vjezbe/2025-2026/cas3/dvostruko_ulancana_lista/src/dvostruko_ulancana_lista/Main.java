package dvostruko_ulancana_lista;

public class Main {

	public static void main(String[] args) {
		DvostrukoUlancanaLista lista = new DvostrukoUlancanaLista();
		
		lista.dodajNaKraj(3);
		lista.dodajNaPocetak(5);
		lista.dodajNaPocetak(7);
		lista.dodajNaPocetak(9);
		lista.dodajNaKraj(10);
		lista.dodajNaKraj(8);
		
		lista.stampajListu(); System.out.println();
		lista.stampajListuObrnuto(); System.out.println();
		
		lista.okreni();
		lista.stampajListu(); System.out.println();
		lista.stampajListuObrnuto(); System.out.println();
		
		lista.obrisiVrijednost(3);
		lista.stampajListu(); System.out.println();
		
		lista.obrisiVrijednost(8);
		lista.stampajListu(); System.out.println();
		
		lista.obrisiVrijednost(9);
		lista.stampajListu(); System.out.println();
		lista.stampajListuObrnuto(); System.out.println();
		
		lista.obrisiVrijednost(7);
		lista.obrisiVrijednost(5);
		lista.obrisiVrijednost(10);
		lista.stampajListu(); System.out.println();
		lista.stampajListuObrnuto(); System.out.println();
		
		lista.dodajNaKraj(13);
		lista.stampajListu(); System.out.println();
		
		DvostrukoUlancanaLista lista2 = new DvostrukoUlancanaLista();
		lista2.dodajSortirano(5);
		lista2.dodajSortirano(3);
		lista2.dodajSortirano(7);
		lista2.dodajSortirano(1);
		lista2.stampajListu(); System.out.println();

	}

}
