package cas9;

public class BST {
	Cvor glava;
	
	public BST() {
		this.glava = null;
	}
	
	public void dodaj(int vrijednost) {
		glava = dodaj(glava, vrijednost);
	}
	private Cvor dodaj(Cvor cvor, int vrijednost) {
		
		if(cvor == null)
			return new Cvor(vrijednost);
		
		if(cvor.vrijednost > vrijednost) 
			cvor.lijevi = dodaj(cvor.lijevi, vrijednost);
		else if(cvor.vrijednost < vrijednost)
			cvor.desni = dodaj(cvor.desni, vrijednost);
		
		return cvor;		
	}
	
	public void preorder() {
		preorder(glava);
		System.out.println();
	}
	private void preorder(Cvor cvor) {
		if(cvor == null) return;
		
		System.out.print(cvor.vrijednost + " ");
		preorder(cvor.lijevi);
		preorder(cvor.desni);
	}
	
	public void inorder() {
		inorder(glava);
		System.out.println();
	}
	private void inorder(Cvor cvor) {
		if(cvor == null) return;
		
		inorder(cvor.lijevi);
		System.out.print(cvor.vrijednost + " ");
		inorder(cvor.desni);
	}
	
	public void postorder() {
		postorder(glava);
		System.out.println();
	}
	private void postorder(Cvor cvor) {
		if(cvor == null) return;
		
		postorder(cvor.lijevi);
		postorder(cvor.desni);
		System.out.print(cvor.vrijednost + " ");

	}
	
	public boolean sadrzi(int vrijednost) {
		return sadrzi(glava, vrijednost);
	}
	private boolean sadrzi(Cvor cvor, int vrijendost) {
		if(cvor == null) return false;
		
		if(cvor.vrijednost == vrijendost)
			return true;
		
		if(vrijendost < cvor.vrijednost)
			return sadrzi(cvor.lijevi, vrijendost);
		else
			return sadrzi(cvor.desni, vrijendost);
	}
	
	public Integer minimum() {
		return minimum(glava);
	}
	private Integer minimum(Cvor cvor) {
		if(cvor == null)
			return null;
		if(cvor.lijevi != null)
			return minimum(cvor.lijevi);
		
		return cvor.vrijednost;
	}
	
	public void ukloni(int vrijednost) {
		glava=ukloni(glava, vrijednost);
	}
	private Cvor ukloni(Cvor cvor, int vrijednost) {
		if(cvor == null) 
			return null;
		
		if(vrijednost < cvor.vrijednost)
			cvor.lijevi = ukloni(cvor.lijevi, vrijednost);
		else if(cvor.vrijednost < vrijednost) 
			cvor.desni = ukloni(cvor.desni, vrijednost);
		else {
			if(cvor.lijevi == null) 
				return cvor.desni;
			if(cvor.desni == null)
				return cvor.lijevi;
			
			int min = minimum(cvor.desni);
			cvor.vrijednost = min;
			cvor.desni = ukloni(cvor.desni, min);
		}
		
		return cvor;
	}
	
}
