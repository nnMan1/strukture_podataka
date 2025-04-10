package cas6;

import java.util.Arrays;

public class Main {

	/*
	 * 1. Napisati funkciju String cezar(string s, int k) 
	 * koja šifrira Cezarovom šifrom string s.Cezarovo šifriranje
	 *  se vrši tako što se svako slovo ciklično pomjeri za k 
	 *  mjesta udesno po abecedi. Na primjer za k=2 ’a’ 
	 *  se šifrira kao ’c’, ’b’ kao ’d’ itd.
	 */
	
	public static String cezarovoSifriranje(String poruka, int kljuc) {
		String sifrirana = "";
		
		for(int i=0;i<poruka.length();i++) {
			char c = poruka.charAt(i);
			
			if(Character.isLowerCase(c)) {
				sifrirana += (char)((c - 'a' + kljuc) % 26 + 'a');
			} else if(Character.isUpperCase(c)){
				sifrirana += (char)((c - 'A' + kljuc) % 26 + 'A');
			} else {
				sifrirana += c;
			}
		}
		
		return sifrirana;
	}
	
	/*
	 * Napisati program koji filtrira sve stringove koji pocinju sa dva mala slova ili sa dvije cifre
	 */
	
	public static String[] filter(String[] s) {
		String ret = "";
		
		for(int i=0;i<s.length;i++) {
//			if(s[i].matches("[a-z]{2}.+") ||
//			   s[i].matches("[0-9]{2}.+")) {
//				ret += "$" + s[i];
//			}				
		}
		
		return ret.split("\\$");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Marko Markovic.";
		System.out.println(cezarovoSifriranje(s, 3));
		System.out.println(s.indexOf('o')); //Indeks prvog pojavljivanja karaktera 'o' u stringu s
		System.out.println(s.indexOf("ko")); //Indeks prvog pojavljicanja stringa "ko" u stringu s
		System.out.println(s.lastIndexOf('o')); //Indeks posljednjeg pojavljivanja karaktera o u Stringu s
		System.out.println(s.lastIndexOf("ko")); //Indeks posljednjeg pojavljivanja stringa "ko" u Stringu s
		
		System.out.println(s.substring(4)); //String koji se sastoji od karaktera nakon pozicije indkesa 4 (ukljucujuci 4)
		System.out.println(s.substring(4,  9)); //Strink koji se sastoji od karaktera izmedju pozicije [4, 9)
		
		String[] rijeci = s.split(" ");
		System.out.println(Arrays.toString(rijeci));
		
		String datum = "14-2-2024";
		String[] djelovi = datum.split("-");
		int dan = Integer.parseInt(djelovi[0]);
		int mjesec = Integer.parseInt(djelovi[1]);
		int godina = Integer.parseInt(djelovi[2]);
		System.out.println(dan + " " + mjesec + " " + godina);
		
		String datum1 = "14.2-2024";
		String[] djelovi1 = datum1.split("[.]");
		System.out.println(Arrays.toString(djelovi1));
		
		datum = "15-2-2024";
//		System.out.println(datum.matches("[0123456789]+-[0123456789]+-[0123456789]+"));
//		System.out.println(datum.matches("[0-9]+-[0-9]+-[0-9]+"));
//		System.out.println(datum.matches("[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}"));
		
		String[] rijeci1 = {"marko", "janko", "Petar", "22.3.2025", "a1c"};
		System.out.println(Arrays.toString(filter(rijeci1)));
	}

}
