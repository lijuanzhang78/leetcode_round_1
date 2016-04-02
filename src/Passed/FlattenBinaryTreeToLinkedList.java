package Passed;

import util.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	 public void flatten(TreeNode root) {
	       if(root == null) return;
	       
	       TreeNode left = root.left;
	       TreeNode right = root.right;
	       
	       root.left = null;
	       flatten(left);
	       flatten(right);
	       
	       root.right = left;
	       TreeNode cur = root;

//	      to get the tail of the left sub tree and attach the right sub tree to the tail of left sub tree        
	       while(cur.right != null) cur = cur.right;
	       cur.right = right;
	    }

}
