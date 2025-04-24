package RedSaPrioritetima;

import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	/*
	 * Napisati program koji ucitava raspored predavanja na fakultetu u jednom danu
	 * Raspored je dat u sljedecem obliku a b. A predstavlja pocetak casa u satima
	 * A b predstavlja kraj casa u satima. 
	 * Napisati program koji odredjuje koliko pauza imaju studenti. Moguce je da se neki casovi preklapaju
	 * Primjer:
	 * Ulaz:
	 * 9 11
	 * 10 12
	 * 13 14
	 * 14 15
	 * 16 17
	 * Izlaz:
	 * 2
	 */
	public static Scanner in = new Scanner(System.in);
	public static void spajanjeIntervala() {
		PriorityQueue<Interval> pq = new PriorityQueue<>();
	
		int n = in.nextInt();
		for(int i=0;i<n;i++) {
			Interval novi = new Interval(in.nextInt(), in.nextInt());
			pq.add(novi);
		}

		Interval trenutni = pq.poll(); 
		int br = 0;

		while(!pq.isEmpty()) {
			Interval temp = pq.poll();

			if(trenutni.r >= temp.l) 
				trenutni.r = Math.max(trenutni.r, temp.r);
			else {
				System.out.println(trenutni);
				trenutni = temp;
				br++;
			}
		}

		System.out.println(trenutni);
		System.out.println("Studenti imaju " + br + " pauza.");
	}

	/*
	 * U bioskopu se prikazije n filmova u jednom danu. Za svaki film je poznato vrijeme njegovog pocetka
	 * i trajanje u satima. Svaki film pocinje na cio sat, npr u 9:00 ili 10:00 ...
	 *  Napisati program koji odredjuje koliko se maksimalno filmova moze pogledati u tog dana danu.
	 * Ulaz:
	 * 9 2
	 * 10 3
	 * 13 1
	 * 14 3
	 * 16 1
	 * Izlaz:
	 * 3
	 */

	public static void filmovi() {
		PriorityQueue<Interval> pq = new PriorityQueue<>(new PoredjenjeFilmova());
		int n = in.nextInt();

		for(int i=0;i<n;i++) {
			int p = in.nextInt();
			int t = in.nextInt();
			pq.add(new Interval(p, p + t));
		}

		int br = 1;
		Interval trenutni = null;
		if(pq.size() > 0) {
			trenutni = pq.poll();
			System.out.println(trenutni);
		}

		while(pq.size() > 0) {
			Interval temp = pq.poll();

			if(trenutni.r <= temp.l) {
				trenutni = temp;
				br++;
				System.out.println(trenutni);
			}
		}

		System.out.println(br);
	}


	/*
	 * Napisati program koji u zadatom skupu rijeci stampa k rijeci sa 
	 * koje sadrze najveci broj velikih slova u sebi.
	 */

	 public static void stringovi() {
		int n = in.nextInt();
		int k = in.nextInt();
		PriorityQueue<Tekst> pq = new PriorityQueue<>();
		in.nextLine();

		for(int i=0;i<n;i++) {
			pq.add(new Tekst(in.nextLine()));
		}

		System.out.println();
		for(int i=0;i<k;i++) {
			System.out.println(pq.poll());
		}
	 }

	public static void main(String[] args) {
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new MojePoredjenje());
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if(o1 < o2) return 1;
//				if(o1 == o2) return 0;
//				return -1;
//			}
//		});		
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
//
//		pq.add(3);
//		pq.add(5);
//		pq.add(6);
//		pq.add(2);
//		pq.add(4);
//		
//		System.out.println(pq.peek());
//		System.out.println(pq.peek());
//		
//		System.out.println(pq.poll());
//		System.out.println(pq.peek());

		// PriorityQueue<Student> studenti = new PriorityQueue<>();
		// Student s1 = new Student("Marko", 5, 2024, 9.3);
		// Student s2 = new Student("Janko", 6, 2024, 9);

		// studenti.add(s1);
		// studenti.add(s2);

		// System.out.println(studenti.poll());
		// System.out.println(studenti.poll());
		stringovi();
	}

}
