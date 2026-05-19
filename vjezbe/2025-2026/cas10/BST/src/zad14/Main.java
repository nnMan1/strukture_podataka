package zad14;

import bst.BST;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BST tree = new BST();
		String token;
		int K = 1;
		while(!(token = scanner.next()).equals("0")) {
			if(token.equals("Q")) {
				System.out.print(tree.getKth(tree.size() - K + 1) + " ");
			}else if(token.equals("K"))
				K = scanner.nextInt();
			else
				tree.add(Integer.parseInt(token));			
		}
			
		scanner.close();
	}

}
