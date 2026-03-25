package formula1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pobjede1 = {1, 2, 3, 1, 4, 5, 8};
		int[] trening1 = {2, 4, 2 ,3, 1, 3, 7};
		Vozac v1 = new Vozac("Hamilton", pobjede1, trening1);
		
		int[] pobjede2 = {2, 1, 3, 1, 4, 5, 8};
		int[] trening2 = {1, 5, 2 ,3, 1, 3, 7};
		Vozac v2 = new Vozac("Vestapen", pobjede2, trening2);
		
		int[] pobjede3 = {3, 4, 3, 8, 4, 5, 8};
		int[] trening3 = {0, 1, 2 ,3, 1, 3, 7};
		Vozac v3 = new Vozac("Noris", pobjede3, trening3);
		
		ListaVozaca lista = new ListaVozaca();
		lista.dodaj(v1);
		lista.dodaj(v2);
		lista.dodaj(v3);
		
		lista.stampaj();
	}

}
