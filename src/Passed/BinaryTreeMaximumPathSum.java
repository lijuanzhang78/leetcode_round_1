package Passed;

import util.TreeNode;

public class BinaryTreeMaximumPathSum {
	   public int maxPathSum(TreeNode root) {
	        int[] max = new int[1];
	        max[0] = Integer.MIN_VALUE;
	        localSum(root, max);
	        return max[0];
	    }
	    
	    private int localSum(TreeNode root, int[] max) {
	        if (root == null) return 0;
	        int lsum = localSum(root.left, max);
	        int rsum = localSum(root.right, max);
	        
	        int pathWithRootSum = Math.max(root.val, Math.max(root.val + lsum, root.val + rsum));
	        
	        max[0] = Math.max(max[0], Math.max(pathWithRootSum, root.val + lsum + rsum));
	        
	        return pathWithRootSum;
	    }

}
