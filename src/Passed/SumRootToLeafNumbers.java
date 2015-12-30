package Passed;

import util.TreeNode;

public class SumRootToLeafNumbers {
	   public int sumNumbers(TreeNode root) {
	        return helper(root, 0);
	    }
	    
	    
	    public int helper(TreeNode root, int base) {
	        if (root == null) return 0;
	        
	        if (root.left == null && root.right == null) {
	            return base + root.val;
	        }
	        
	        int nextBase = (base + root.val) * 10;
	        int leftSum = helper(root.left, nextBase);
	        int rightSum = helper(root.right, nextBase);
	        
	        return leftSum + rightSum;
	    }
}
