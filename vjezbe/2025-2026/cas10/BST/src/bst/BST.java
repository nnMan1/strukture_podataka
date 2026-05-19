package bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	
	private static class Node {
		int value; 
		private Node left;
		private Node right;
		int level;
		private int size;
		
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
			this.size = 1;
		}
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.size = 1;
			setLeft(left);
			setRight(right);
		}
		
		private void updateSize() {
			size = 1;
			if(left != null)
				size += left.size;
			if(right != null)
				size += right.size;
		}
		
		public void setLeft(Node left) {			
			this.left = left;
			updateSize();
		}
		
		public void setRight(Node right) {
			this.right = right;
			updateSize();
		}
		
		public Node getLeft() {
			return this.left;
		}
		
		public Node getRight() {
			return this.right;
		}
		
		public int getSize() {
			return this.size;
		}
	}
	
	Node root = null; 
	
	private Node add(int value, Node root) {
		if(root == null) 
			return new Node(value);
		
		if(value < root.value)
			root.setLeft(add(value, root.left));
		if(value >= root.value)
			root.setRight(add(value, root.right));
		
		return root;
	}
	
	public void add(int value) {
		root = add(value, root);
	}
	
	private Node find(int value, Node root) {
		if(root == null)
			return null;
		
		if(value == root.value)
			return root;
		
		if(value < root.value)
			return find(value, root.getLeft());
		else
			return find(value, root.getRight());
	}
	
	public boolean contains(int value) {
		return find(value, root) != null;
	}
	
	private Integer minimum(Node root) {
		if(root == null)
			return null;
		
		if(root.getLeft() == null)
			return root.value;
		
		return minimum(root.getLeft());
	}
	
	public Node remove(int value, Node root) {
		if(root == null)
			return null;
		
		if(value < root.value) 
			root.setLeft(remove(value, root.left));
		
		if(value > root.value)
			root.setRight(remove(value, root.right));
		
		if(value == root.value) {
			if(root.getLeft() == null && root.getLeft() == null)
				return null;
			
			if(root.right != null) {
				int tmp = minimum(root.getLeft());
				root.value = tmp;
				root.setRight(remove(tmp, root.right));
			} else {
				return root.getLeft();
			}
		}
		
		return root;
		
	}
	
	public void remove(int value) {
		root = remove(value, root);
	}
	
	private String preorder(Node root) {
		if(root == null)
			return "";
		
		return root.value + " " + preorder(root.left) + preorder(root.right);
	}
	
	public String preorder() {
		return preorder(root);
	}
	
	private String inorder(Node root) {
		if(root == null)
			return "";
		
		return inorder(root.left) + root.value + " " +  inorder(root.right);
	}
	
	public String inorder() {
		return inorder(root);
	}
	
	private String postorder(Node root) {
		if(root == null)
			return "";
		
		return postorder(root.left) + postorder(root.right) + root.value + " ";
	}
	
	public String postorder() {
		return postorder(root);
	}
	
	public void print() {
		if(root == null)
			return;
		
		root.level = 1;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int prevLevel = 1;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();

			if(current.level != prevLevel)
				System.out.println();			
			prevLevel = current.level;
			
			System.out.print(current.value + " ");
			
			if(current.left != null) {
				current.left.level = current.level + 1;
				queue.add(current.left);
			}
			
			if(current.right != null) {
				current.right.level = current.level + 1;
				queue.add(current.right);
			}
		}
		
		System.out.println();
		
	}
	
	public Integer getKth(int k, Node root) {
		if(root.getSize() < k)
			return null;
		
		if(root.left != null) {
			if(root.left.size >= k)
				return getKth(k, root.left);
			if(root.left.size + 1 == k)
				return root.value;
			return getKth(k-root.left.size-1, root.right);			
		} else {
			if(k == 1)
				return root.value;
			return getKth(k-1, root.right);
		}		
	}
	
	public Integer getKth(int k) {
		return getKth(k, root);
	}
	
	public int size() {
		if(root == null)
			return 0;
		
		return root.size;
	}

}
