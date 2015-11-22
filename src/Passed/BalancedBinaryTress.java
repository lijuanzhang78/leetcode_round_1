package Passed;

import util.TreeNode;

public class BalancedBinaryTress {
	  public boolean isBalanced(TreeNode root) {
	        if (root == null) return true;
	        int leftDepth = getDepth(root.left);
	        int rightDepth = getDepth(root.right);
	        if(Math.abs(leftDepth - rightDepth) > 1) return false;
	        
	        return isBalanced(root.left) && isBalanced(root.right);
	    }
	    
	    public int getDepth(TreeNode node) {
	        if (node == null) return 0;
	        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
	    }
}
