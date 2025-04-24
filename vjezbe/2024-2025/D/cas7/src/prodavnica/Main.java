package prodavnica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prodavnica p1 = new Prodavnica();
		
		p1.dodajArtikal("Plazma keks", "hrana", 1);
		p1.dodajArtikal("Iphone", "tehnika", 600);
		p1.dodajArtikal("Mlijeko", "hrana", 2);
		
		p1.prikaziKatalog();
		
//		p1.ukloniArtikal("Iphone");
//		p1.ukloniSve(100);
		p1.urediKatalogOpadajuce();
		p1.prikaziKatalog();
		
		System.out.println(p1.najvecaKategorija());
	}

}
