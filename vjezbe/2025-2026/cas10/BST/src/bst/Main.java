package bst;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree = new BST();
		tree.add(5);
		tree.add(9);
		tree.add(10);
		tree.add(3);
		tree.add(3);
		
		System.out.println("tree.contains(3) = " + tree.contains(3));
		System.out.println("tree.contains(4) = " + tree.contains(4));
		System.out.println("tree.contains(10) = " + tree.contains(10));
		System.out.println("tree.contains(5) = " + tree.contains(5));
		
		System.out.println("tree.preorder() = " + tree.preorder());
		System.out.println("tree.inorder() = " + tree.inorder());
		System.out.println("tree.postorder() = " + tree.postorder());
		tree.print();



		tree.remove(10);
		System.out.println("tree.contains(10) = " + tree.contains(10));
		tree.remove(5);
		System.out.println("tree.contains(5) = " + tree.contains(5));


		
	}

}
