package cas9;

public class Main {

	public static void main(String[] args) {
		BST stablo = new BST();
				
		stablo.dodaj(8);
		stablo.dodaj(11);
		stablo.dodaj(5);
		stablo.dodaj(6);
		stablo.dodaj(14);
		stablo.dodaj(10);
		stablo.dodaj(9);
		stablo.dodaj(12);
		stablo.dodaj(13);
		stablo.dodaj(15);
		
		stablo.preorder();
		stablo.inorder();
		stablo.postorder();
		
		System.out.println("stablo.sadrzi(3) = " + stablo.sadrzi(3));
		System.out.println("stablo.sadrzi(4) = " + stablo.sadrzi(4));
		System.out.println("stablo.minimum() = " + stablo.minimum());
		
		stablo.ukloni(11);
		stablo.preorder();
		stablo.inorder();
		stablo.postorder();
		
	}
}
