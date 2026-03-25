package zad2;

import java.lang.reflect.Array;
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
		String s = "Marko Markovic";
		System.out.println(s);
		System.out.println(s.charAt(1)); //karakter na index 1
		System.out.println(s.indexOf('k')); //index prvog poj. kar 'k'
		System.out.println(s.lastIndexOf('k')); //index poslj. pojalj
		System.out.println(s.indexOf("rko"));
		System.out.println(s.lastIndexOf("rko"));
		
		System.out.println(s.substring(4));
		System.out.println(s.substring(4, 10));
		
		String[] rijeci = s.split(" ");
		System.out.println(Arrays.toString(rijeci));
		
		rijeci = s.split("k|a|p");
		rijeci = s.split("[kap]"); //slova k,a i p predstavljaju kraj rijeci
		rijeci = s.split("[^kap]"); //svi karakteri osim k, a ili p predstavljaju kraj rijeci
		System.out.println(Arrays.toString(rijeci));
		
		String datum = "12-2-2026";
		String[] djelovi = datum.split("-");
		int dan = Integer.parseInt(djelovi[0]);
		int mjesec = Integer.parseInt(djelovi[1]);
		int godina = Integer.parseInt(djelovi[2]);
		System.out.println(dan+ " " + mjesec + " " + godina);
		
		s = "test256afsd";
//		rijeci = s.split("[012345678]");
		rijeci = s.split("[0-9]");
		System.out.println(Arrays.toString(rijeci));
		
		s = "14.02.26.";
		rijeci = s.split("[.]");
		System.out.println(Arrays.toString(rijeci));

//		System.out.println(s.matches("[0-9]+[.][0-9]+[.][0-9]+[.]"));
		System.out.println(s.matches("[0-9]{1,2}[.][0-9]+[.][0-9]{4}[.]"));
//		String[] imena = {"marko", "janko", "Patar"};
		
	}

}
