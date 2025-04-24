package prodavnica;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.function.Predicate;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Prodavnica p1 = new Prodavnica();
		p1.dodajArtikal("Plazma keks", "hrana", 1);
		p1.dodajArtikal("Iphone", "tehnika", 500);
		p1.dodajArtikal("Mlijeko", "hrana", 2);
		
		p1.prikaziPonudu();
		
//		p1.ukloniArtikal("Iphone");
		p1.sortirajPoCijeniRastuce();
		p1.prikaziPonudu();
		
		p1.sortirajPoCijeniOpadajuce();
		p1.prikaziPonudu();
		
		System.out.println(p1.najvecaKategorija());

		
//		int[] arr = {4, 5, 6 ,7, 8};
//		
//		for(int x: arr) {
//			System.out.println(x);
//		}
//		System.out.println();
		
//		LinkedList<Integer> list = new LinkedList<>();
//		
//		list.add(5);
//		list.add(4);
//		list.add(3);
//		list.addFirst(9);
//		list.add(1, 4); //O(n)
//				
//		for(int x: list) {
//			System.out.print(x + " ");
//		}
		
//		System.out.println();
//		list.remove(2); //O(n) //uklonio element koji je treci u listi od pocetka
//		for(int x: list) {
//			System.out.print(x + " ");
//		}
//		
//		System.out.println();
//
//		list.remove(new Integer(4)); //uklonio sam element sa vrijednoscu 4
//		for(int x: list) {
//			System.out.print(x + " ");
//		}
		
//		list.removeIf(new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer t) {
//				return t < 5;
//			}
//			
//		});
//		
//		for(int x: list) {
//			System.out.print(x + " ");
//		}
		
//		Collections.sort(list);
//		for(int x: list) {
//			System.out.print(x + " ");
//		}
		
//		Collections.sort(list, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if(o1 < o2) return 1;
//				if(o1 == o2) return 0;
//				return -1;
//			}
//		});
		
//		Collections.sort(list, new IntegerComparator());
//		
//		for(int x: list) {
//			System.out.print(x + " ");
//		}
		
	}

}
