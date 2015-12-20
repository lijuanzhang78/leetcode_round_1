package Passed;

import util.TreeNode;

public class PathSum {
	 public boolean hasPathSum(TreeNode root, int sum) {
	        return hasPathSum(root, 0, sum);
	    }
	    
	    boolean hasPathSum(TreeNode root, int sum, int target) {
	        if (root != null) {
	            sum += root.val;
	        } else {
	            return false;
	        }
	        
	        if(root.left == null && root.right == null) {
	            if (target == sum) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	        
	        return hasPathSum(root.left, sum, target) || hasPathSum(root.right,sum,target);
	    }

}
