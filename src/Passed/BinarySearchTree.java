package Passed;
// http://cslibrary.stanford.edu/110/BinaryTrees.html

public class BinarySearchTree {
	private Node root;
	
// Node definition (nested)	
	private static class Node {
		Node left;
		Node right;
		int data;
	
	
		Node(int newData) {
			left = null;
			right = null;
			data = newData;		
		} 
	}
	
	public void BinarySearchTree() {
		root = null;
	}
	
	public boolean lookup(int target) {
		return lookup(root, target);	
	}
	
	private boolean lookup(Node root, int target) {
		if (root == null) return false;
		
		if (root.data == target) return true;
		if (root.data < target) return lookup(root.right, target);
		if (root.data > target) return lookup(root.left, target);
	
	}
	
	public void insert(int target)  {
		root = insert(root, target);		
	}
	
	private Node insert(Node root, int target) {
		if (root == null) {
			root = new Node(target);
		}
		
		if (target <= root.data) {
			root.left = insert(root.left, target);
		} else {
			root.right = insert(root.right, target);
		}
		
		return root;		
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (size(root.left) + 1 + size(root.right));			
		}		
	}
	
	public int maxDepth() {
		return maxDepth(root);
	}
	
	private int maxDepth(Node root) {
		if (root == null) return 0;
		
		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);
		
		return Math.max(lDepth, rDepth) + 1;	
	}
	
	
	public int minValue() {
		return minValue(root);
	}
	
	private int minValue(Node root) {
		Node current = root;		
		while (current.left != null) {
			current = current.left;
		}		
		return current.data;	
	}
	
	public boolean hasPathSum(int sum) {
		return hasPathSum(root, sum);		
	}
	
	private boolean hasPathSum(Node root, int sum) {
		if (root == null) return sum == 0;
		
		int subSum = sum - root.data;
		return hasPathSum(root.left, subSum) || hasPathSum(root.right, subSum);	
	}
	
	public void mirror() {
		return mirror(root);
	}
	
	private void mirror(Node root) {
		if (root == null) return;
		
		mirror(root.left);
		mirror(root.right);
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;		
	}
	
	public boolean isSameTree(BinarySearchTree other) {
		return isSameTree(root, other.root);
	}
	
	private boolean isSameTree(Node a, Node b) {
		if (a == null && b == null) return true;
		else if (a != null && b != null) {
			return a.data == b.data && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
		}
		else {
			return false;
		}	
	}
	
	
	
	
	
	
	
	
}
	
	
	
			
	
