package cas3_stack_queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void ucitajNiz(int[] arr) {
		for(int i=0;i<arr.length;i++)
			arr[i] = in.nextInt();
	}
	
	public static void stampajNiz(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	
	/*
	 * 1. Napisati program koji provjerava da li je unijeti niz zagrada ispravan
	 * Niz zagrada je pravilan ako se umetanjem broja 1 i operatora + na odgovarajuce 
	 * pozicije dobija ispravan aritmeticki izraz
	 * Primjer:
	 * ((())[]) => ispravan
	 * (())({}) => ispravan
	 * (()] => nije ispravan
	 */
	
	public static boolean zagrade(String izraz) {
		Stack<Character> s = new Stack<>();
		
		for(int i=0;i<izraz.length();i++) {
			char c = izraz.charAt(i); //uzima i-ti karakter iz stringa
			
			if(c == '{' || c == '(' || c == '[')
				s.push(c);
			else {
				if(s.empty()) //pokusavamo da zatvnorimo zagradu a na steku nema otv zagrada
					return false;
				
				if(c == ')' && s.peek() != '(')
					return false;
				if(c == ']' && s.peek() != '[')
					return false;
				if(c == '}' && s.peek() != '{')
					return false;
				
				s.pop();
			}
		}
		
		return s.empty();
	}
	
	/*
	 * 2. Napisati program koji učitava niz cijelih brojeva A dužine N, 
	 * a zatim napisati funkciju koja za svaki element niza štampa prvi veći 
	 * element koji se nalazi poslije njega u nizu. 
	 * Za elemente za koje ne postoji takav element, štampati -1. 
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
	 * 3.     7. Ka slijepom kolosijeku dolazi voz sa strane označene kao Put 1.
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
		int zeljeni_vagon = 1;
		
		int[] oper = new int[2 * arr.length];
		int oper_cnt = 0;
				
		for(int i=0;i<arr.length;i++) {
			while(!s.empty() && s.peek() == zeljeni_vagon) {
				oper[oper_cnt++] = 2;
				s.pop();
				zeljeni_vagon++;
			}
			
			s.push(arr[i]);
			oper[oper_cnt++] = 1;
		}
		
		while(!s.empty() && s.peek() == zeljeni_vagon) {
			oper[oper_cnt++] = 2;
			s.pop();
			zeljeni_vagon++;
		}
		
		if(!s.empty()) {
			System.out.println(0);
			return;
		}
		
		for(int i=0;i<oper_cnt;i++)
			System.out.println(oper[i]+" 1");
	}
	
	/*
	 * 8. Napisati progam koji izraz zadat u infiksnoj notaciji
	 * pretvara u postfiksnu notaciju
	 */
	
	public static int priority(char c) {
		if(c == '*' || c == '/')
			return 2;
		if(c == '+' || c == '-')
			return 1;
		return 0;
	}
	
	public static void infixToPostfix(String expr) {
		Stack<Character> s = new Stack<>();
		
		for(int i=0;i<expr.length();i++) {
			char c = expr.charAt(i);
			
			if('0' <= c && c <= '9') {
				System.out.print(c);
				continue;
			}
			
			if(c == '(') {
				s.push(c);
				continue;
			}
			
			while(!s.empty() && priority(s.peek()) >= priority(c))
				if(s.peek() == '(') {
					s.pop();
					break;
				}
				else
					System.out.print(" "+s.pop());
			
			if(c != ')') {
				s.push(c);
				System.out.print(" ");
			}
		}
		
		while(!s.empty())
			System.out.print(s.pop());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = in.next();
		infixToPostfix(s);
		
//		MyStack s1 = new MyStack();
//		
//		s1.push(5);
//		s1.push(7);
//		s1.push(9);
//		s1.push(3);
				
//		Stack<Integer> s = new Stack<>();
//		
//		s.push(5);
//		s.push(7);
//		s.push(9);
//		s.push(3);
//		
//		System.out.println(s.());
//		System.out.println(s.pop());
//		System.out.println(s.peek());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
		
//		String s1 = in.next();
//		System.out.println(zagrade(s1));
		
//		int[] arr = new int[in.nextInt()];
//		ucitajNiz(arr);
//		int[] veci = prviVeci(arr);
//		stampajNiz(veci);
		
//		vozovi(arr);
		
		

		
	}

}
