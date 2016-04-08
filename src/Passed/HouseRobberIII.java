package Passed;

import util.TreeNode;

public class HouseRobberIII {
	 public int rob(TreeNode root) {
	        int[] res = robsub(root);
	        return Math.max(res[0], res[1]);
	    }
	    
	    private int[] robsub(TreeNode root) {
	        if (root == null) return new int[2];
	        
	        int[] left = robsub(root.left);
	        int[] right = robsub(root.right);
	        
	        int[] res = new int[2];
	        
//	      res[0] not include root, res[1] include root
	        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	        res[1] = root.val + left[0] + right[0];
	        
	        return res;
	    }
}
