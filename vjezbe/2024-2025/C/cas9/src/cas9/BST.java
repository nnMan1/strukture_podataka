package cas9;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	Cvor glava;
	
	public BST() {
		glava = null;
	}
	
	public void dodaj(int vrijednost) {
		glava = dodajPom(glava, vrijednost);
	}
	
	private Cvor dodajPom(Cvor glava, int vrijednost) {
		
		if(glava == null) {
			//ako je stablo prazno, napravi jedan cvor i vrati ga da bude korijen stabla
			return new Cvor(vrijednost);
		}
		
		if(glava.vrijednost > vrijednost) 
			glava.lijevi = dodajPom(glava.lijevi, vrijednost);
	
		if(glava.vrijednost < vrijednost) 
			glava.desni = dodajPom(glava.desni, vrijednost);
	
		return glava; 
	}
	
	public void preorder() {
		preorderPom(glava);
	}
	
	private void preorderPom(Cvor glava) {
		if(glava == null)
				return;
		
		System.out.print(glava.vrijednost + " ");
		preorderPom(glava.lijevi);
		preorderPom(glava.desni);
	}
	
	public void inorder() {
		inorderPom(glava);
	}
	
	private void inorderPom(Cvor glava) {
		//stampa se prvo lijevo podstablo, pa glava pa desno podstablo
		if(glava == null)
				return;
		
		inorderPom(glava.lijevi);
		System.out.print(glava.vrijednost + " ");
		inorderPom(glava.desni);
	}
	
	public void postorder() {
		postorderPom(glava);
	}
	
	private void postorderPom(Cvor glava) {
		if(glava == null)
				return;

		postorderPom(glava.lijevi);
		postorderPom(glava.desni);
		System.out.print(glava.vrijednost + " ");
	}
	
	public boolean sadrzi(int vrijednost) {
		Cvor temp = glava;
		
		while(temp != null) {
			if(temp.vrijednost == vrijednost)
				return true;
			
			if(temp.vrijednost > vrijednost)
				temp =  temp.lijevi;
			else
				temp = temp.desni;
		}
		
		return false;
		//napisati rekurzivnu funkciju boolean sadrziPom(Cvor glava, vrijednost) 
		//koja provjeravada li se vrijednost nalazi u stablu
	}
		
	public Integer minimum() {
		Cvor temp = glava;
		
		if(temp == null)
			return null;
		
		while(temp.lijevi != null)
			temp = temp.lijevi;
		
		return temp.vrijednost; 
	}
	
	public Integer minimum(Cvor glava) {
		if(glava == null)
			return null;
		
		if(glava.lijevi == null)
			return glava.vrijednost;
		
		return minimum(glava.lijevi);		
	}
	
	public void obrisi(int vrijednost) {
		obrisi(glava, vrijednost);
	}
	
	public Cvor obrisi(Cvor glava, int vrijednost) {
		if(glava == null) return null;
		
		if(glava.vrijednost > vrijednost) {
			glava.lijevi = obrisi(glava.lijevi, vrijednost);
			return glava;
		}
		
		if(glava.vrijednost < vrijednost) {
			glava.desni = obrisi(glava.desni, vrijednost);
			return glava;
		}
		
		//cvor je tacno jednak onome sto zelimo da obrisemo
		if(glava.lijevi == null) return glava.desni;
		if(glava.desni == null) return glava.lijevi;
		
		int min = minimum(glava.desni);
		glava.vrijednost = min;
		glava.desni = obrisi(glava.desni, min);
		
		return glava;
	}
	
	public void stampajStablo() {
		Queue<Cvor> q = new LinkedList<>();
		glava.dubina = 1;
		q.add(glava);
		int dubina = 1;
		
		while(!q.isEmpty()) {
			Cvor temp = q.poll();
			
			if(temp == null) {
				System.out.print("  ");
				continue;
			}
			
			if(temp.dubina > dubina) {
				System.out.println();
				dubina ++;
			}
			
			System.out.print(temp.vrijednost + " ");
			if(temp.desni != null)
			temp.desni.dubina = dubina + 1;
			if(temp.lijevi != null)
			temp.lijevi.dubina = dubina + 1;
			q.add(temp.lijevi);
			q.add(temp.desni);
		}
	}
}
