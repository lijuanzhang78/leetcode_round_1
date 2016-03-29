package Passed;

import util.TreeNode;

public class ClosestBinarySearchTreeValue {
	 public int closestValue(TreeNode root, double target) {
	        int closest = root.val;
	        
	        while(root != null) { 
	        
	            if(Math.abs(target - root.val) < Math.abs(target - closest)) {
	                closest = root.val;
	             }
	            
	            if(target == closest) return closest;
	            
	            root = (root.val < target)? root.right : root.left;
	        }
	        
	        return closest;
	    }
}
