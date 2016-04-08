package Passed;

import util.TreeNode;

public class CountUniValeSubtrees {
	 private int count = 0;
	    public int countUnivalSubtrees(TreeNode root) {
	        unival(root);
	        return count;
	    }
	    
	    private boolean unival(TreeNode root) {
	        if (root == null) return true;
	        
	        if(root.left == null && root.right == null) {
	            count++;
	            return true;
	        }
	        
	        boolean left = unival(root.left);
	        boolean right = unival(root.right);
	        
	        if (left && right && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
	            count++;
	            return true;
	        }
	        
	        return false;
	    }
}
