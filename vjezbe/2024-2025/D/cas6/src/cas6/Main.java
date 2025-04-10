package cas6;
import java.util.Scanner;

public class Main {
	
	public static Scanner in = new Scanner(System.in);
	
	/*
	 * 1. Napisati program koji ucitava string.
	 * Za ucitani string potrebno je stampati broj samoglasnika
	 * u stringu.
	 */
	
	public static int samoglasnici(String s) {
		String s1 = "AEIOUaeiou";
		int br = 0;
		
		for(int i=0;i<s.length();i++)
			if(s1.indexOf(s.charAt(i)) != -1)
				br ++;
		
		return br;
	}
	
	/*
	 * 2. Napisai metodu anagrami, koja izima  dva stringa i
	 * provjerava da li se jedan string moze dobiti od drugog 
	 * premjestanjem karaktera
	 */
	
	public static boolean anagrami(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		char[] freq1 = new char[26];
		char[] freq2 = new char[26];
		
		for(int i=0;i<s1.length();i++) {
			freq1[s1.charAt(i) - 'a'] ++;
			freq2[s2.charAt(i) - 'a'] ++;
		}
		
		for(int i=0;i<26;i++)
			if(freq1[i] != freq2[i])
				return false;
		
		return true;
	}	
	
	public static String cezar(String s, int k) {
		String sifra = "";
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(Character.isLowerCase(c))
				c = (char)('a' + ((c - 'a') + k) % 26);
			else if(Character.isUpperCase(c))
				c = (char)('A'+ ((c - 'A') + k) % 26);
			
			sifra += c;
		}
		
		return sifra;
	}
	
	public static int excelKolona(String tekst) {
		int br = 0;
		
		for(int i=0;i<tekst.length();i++) {
			char c = tekst.charAt(i);
			int v = c - 'A' + 1;
			
			br = br * 26 + v;
		}
		
		return br - 1;
	}
	
	public static String exceclKolonaReverse(int broj) {
		String s = "";
		
		broj += 1;
		
		while(broj > 0) {
			char c = (char)('A' + (broj-1) % 26);
			s = c + s;
			broj = (broj - 1) / 26;
		}
			
		return s;
	}
	
	/*
	 * Napisati program koji provjerava da li je IP adresa pravilna.
	 * IP adresa je pravilna ako se sastoji od 4 cijela broja izmedju 0 i 255 (ukljuceno)
	 * Brojevi su odvojeni tackama. Ni jedan od brojeva nema vodecih nula.
	 */
	
	public static boolean cifre(String s) {
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(!Character.isDigit(c))
				return false;
		}
		
		return true;
	}
	
	public static boolean validanIP(String s) {
		//192.168.33.52
		String[] djelovi = s.split("\\.");
		if(djelovi.length != 4)
			return false;
		
		for(int i=0;i<4;i++) {
			if(djelovi[i].length() == 0)
				return false;
			
			if(!cifre(djelovi[i]))
				return false;
			
			if(djelovi[i].charAt(0) == '0' && djelovi[i].length() > 1)
				return false;
			
			int x = Integer.parseInt(djelovi[i]);
			if(x < 0 || x > 255)
				return false;
		}
		
		
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String poruka = in.next();
		String poruka1 = in.nextLine();
//		String poruka2 = in.next();
//		System.out.println(anagrami(poruka1, poruka2));
//		int br = in.nextInt();
		System.out.println(validanIP(poruka1));
		return;
		
		
//		String s1 = "programiranje";
//			
//		System.out.println("Duzina string s1: " + s1.length());
//		char c = 'a';
//		System.out.println(s1.charAt(3));
//		System.out.println(s1.charAt(3) == c);
//		System.out.println(s1.charAt(5) == 'a');
//		
//		String s2 = s1 + " PMF";
//		System.out.println(s2);
//		
////		String s3 = 'a' + 'b' + 'c' + 'd';
//		String s3 = "" + 'a' + 'b' + 'c';
//		System.out.println(s3);
//		
//		System.out.println(s1.indexOf('r'));
//		System.out.println(s1.indexOf('a'));
//		System.out.println(s1.lastIndexOf('a'));
//		System.out.println(s1.indexOf("gra"));
//		System.out.println(s1.indexOf("PMF"));
//		
//		String s4 = "programiranje";
//		
//		System.out.println(s1 == s4);
//		System.out.println(s1.compareTo("Aprogramiranje"));
//		
//		System.out.println(s1.substring(5));
//		System.out.println(s1.substring(5, 8));
//		
//		System.out.println(s1.toUpperCase());
//		
//		String datum = "15-03-2025";
//		String[] djelovi = datum.split("-");
//		for(int i=0;i<djelovi.length;i++)
//			System.out.println(djelovi[i]);
//		
//		String tekst = "Mmprmarkodsamko";
////		String[] djelovi_teksta = tekst.split("(ar)|k|g"); //String se prekida kad naidjemo na ar ili na k ili na g
////		for(int i=0;i<djelovi_teksta.length;i++)
////			System.out.println(djelovi_teksta[i]);
//		
//		String[] djelovi_teksta2 = tekst.split(".r");
//		for(int i=0;i<djelovi_teksta2.length;i++)
//			System.out.println(djelovi_teksta2[i]);
//		
//		String datum2 = "15/03-2024";
//		String[] djelovi2 = datum.split("\\.|\\-|\\/"); //ako naidjes na . ili na / ili na -
////		for(int i=0;i<djelovi2.length;i++)
////			System.out.println(djelovi2[i]);
//		
//		int dan = Integer.parseInt(djelovi2[0]);
//		int mjesec = Integer.parseInt(djelovi2[1]);
//		int godina = Integer.parseInt(djelovi2[2]);
//		
//		System.out.println("" + dan + "." + mjesec + "." + godina);
		
		
	}

}
