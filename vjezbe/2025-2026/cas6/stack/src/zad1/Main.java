package zad1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static Scanner in = new Scanner(System.in);
	
	/*
	 * 1. Napisati program koji provjerava da li je unijeti niz zagrada ispravan.
	 * Niz zagrada je ispravan ako se umetanjem broja 1 i operatora + na odgovaracjuce 
	 * pozicije dobija ispravan aritmeticki izraz
	 * Primjer:
	 * ((())+[]) => ispravan
	 * (())({}) => ispravan
	 * (()]     => nije ispravan
	 * [)(]
	 * ([)]
	 */
	
	public static boolean zagrade(String izraz) {
		Stack<Character>s = new Stack<>(); 
		
		for(int i=0;i<izraz.length();i++) {
			char c = izraz.charAt(i);
			
			if(c == '(' || c == '[' || c == '{') {
				s.push(c);
				continue;
			}
			
			if(s.empty())
				return false;
			
			if(c == ')' && s.peek() != '(') 
				return false;
			if(c == ']' && s.peek() != '[')
				return false;
			if(c == '}' && s.peek() != '{')
				return false;
			
			s.pop();			
		}
		
		return s.empty();
	}
	
	/*
	 * 2. Napisati program koji ucitava niz cijelih brojva duzine N.
	 * Za svaki element niza, stampati prvi veci element koji se nalazi
	 * posle njega u nizu. 
	 * Za elemente za koje ne postoji takav element stampati -1.
	 */
	
	public static int[] prviVeci(int[] arr) {
		Stack<Integer> s = new Stack<>();
		int[] ret = new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			while(!s.empty() && arr[s.peek()] < arr[i])
				ret[s.pop()] = arr[i];
			
			s.push(i);
		}
		
		while(!s.empty())
			ret[s.pop()] = -1;
		
		return ret;
	}
	
	/*
	 * zad3. Ka slijepom kolosijeku dolazi voz sa strane označene kao Put 1.
		Dozvoljeno je od voza otkačiti jedan ili više vagona (moguće i cio voz) 
		sa prednje strane voza i uvesti ih na slijepi kolosijek. Poslije toga je 
		moguće dio vagona sa slijepog kolosijeka izvesti na put 2.  
		Zatim dio preostalih vagona sa Puta 1 ponovo možemo uvesti na slijepi 
		kolosijek, pa dio vagona sa kolosijeka izvesti na Put 2, itd. 
		Nije dozvoljeno pomjerati vagone sa Puta 2 na slijepi kolosijek niti 
		izvoziti vagone sa kolosijeka na Put 1 (vidi strelice na slici). 
		Poznato je kojim redom dolaze vagoni. Potrebno je, pomoću opisanih operacija, 
		reorganizovati voz tako da vagoni idu u poretku 1,2,3.... 
		Redosljed se posmatra na Putu 2, od slijepog kolosijeka. 
	Ulaz: U prvom redu unosi se N – broj vagona u vozu (1≤N≤2000). 
	U drugom redu su dati vagoni koji dolaze po putu 1 ka slijepom kolosijeku. 
	Vagoni su neumerisni brojevima od 1 do N. 
	Izlaz: Štampati plan koji raspoređuje vagone u željeni raspored. 
	Dopuštene su dvije operacije:
    • 1 K – pomjeranje K vagona sa puta 1 na slijepi kolosijek, K1
    • 2 K – pomjeranje K vagona sa slijepog kolosijeka na put 2, K1

	Ako postoji više rješenja, štampati bilo koje od njih. 
	Ako ne postoji rješenje, štampati samo broj 0. 
	 */
	
	public static void vozovi(int[] arr) {
		Stack<Integer> s = new Stack<>(); //pomocni kolosjek
		int zeljeniVagon = 1;
		
		LinkedList<Integer> sol = new LinkedList<Integer>();
		
		for(int i=0;i<arr.length;i++) {
			s.push(arr[i]);
			sol.add(1);
			
			while(!s.empty() && s.peek() == zeljeniVagon) {
				sol.add(2);				
				s.pop();
				zeljeniVagon ++;
			}
		}
		
		if(!s.empty()) 
			System.out.println(0);
		else {
			int cnt = 0;
			int prev = 0;
			for(int el: sol) {
				if(prev == el) {
					cnt ++;
					continue;
				}
				
				if(cnt > 0) 
					System.out.println(prev + " " + cnt);
				
				prev = el;
				cnt = 1;
			}
			
			if(cnt > 0) 
				System.out.println(prev + " " + cnt);
		}
	}
	
	
	public static void main(String[] args) {
		
//		zad1
//		String izraz = in.next();
//		System.out.println(zagrade(izraz) ? "Ispravan" : "Nije ispravan");
		
//		zad2
//		int n = in.nextInt();
//		int[] arr = new int[n];
//		
//		for(int i=0;i<n;i++)
//			arr[i] = in.nextInt();
//		
//		System.out.println(Arrays.toString(prviVeci(arr)));
		
//		zad2
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		
		vozovi(arr);
	}
}
