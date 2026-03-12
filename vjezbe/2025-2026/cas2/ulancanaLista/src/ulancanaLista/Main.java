package ulancanaLista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UlancanaLista l1 = new UlancanaLista();
		
		l1.dodajPocetak(5);
		l1.dodajPocetak(7);
		l1.dodajPocetak(3);
		l1.dodajPocetak(7);
		l1.dodajPocetak(1);
		
		System.out.println("Sadrzi 2 " + (l1.sadrzi(2) ? "DA" : "NE"));
		System.out.println("Sadrzi 3 " + (l1.sadrzi(3) ? "DA" : "NE"));
		
		l1.stampajListu();
		System.out.println();
		
		l1.okreniListu();
		l1.stampajListu();
		System.out.println();
		
		l1.dodajPosle(7, 7);
		l1.stampajListu();
		System.out.println();
		
		l1.obrisi(3);
		l1.stampajListu();
		System.out.println();
		
		l1.obrisi(5);
		l1.stampajListu();
		System.out.println();
		
		l1.obrisi(1);
		l1.stampajListu();
		System.out.println();
		
		l1.dodajNaKraj(9);
		l1.stampajListu();
		System.out.println();
		
		UlancanaLista l2 = new UlancanaLista();
		l2.dodajNaKraj(5);
		l2.dodajNaKraj(13);
		l2.dodajPocetak(4);
		
		l1.nadovezi(l2);
		l1.stampajListu();
		System.out.println();
		
	}

}
