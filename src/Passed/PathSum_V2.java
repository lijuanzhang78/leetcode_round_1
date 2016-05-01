package Passed;

import util.TreeNode;

public class PathSum_V2 {
	 public boolean hasPathSum(TreeNode root, int sum) {
	        
//	      Empty node
	        if (root == null) return false;
	        
//	      Reach leaf node
	        if (root.left == null && root.right == null) return sum == root.val;
	        
	        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	    
	    }
}
