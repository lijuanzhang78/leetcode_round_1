package Passed;

import util.TreeNode;

public class LargestBSTSubtree {
	 public int largestBSTSubtree(TreeNode root) {
	        int[] res = recursive(root);
	        return res[2];
	    }
	    
	    private int[] recursive(TreeNode root) {
	        int[] res = new int[5];
	        res[0] = 1;
	        res[3] = Integer.MAX_VALUE;
	        res[4] = Integer.MIN_VALUE;
	        
	        if(root == null) return res;
	        int[] resL = recursive(root.left);
	        int[] resR = recursive(root.right);
	        
	        // 0 - whether is BST, 1 - no. of nodes, 2 - max BST subtree, 3 - min value, 4 - max value
	        if (resL[0] == 0 || resR[0] == 0 || resL[4] > root.val || resR[3] < root.val ) {
	            res[0] = 0;
	        }
	        
	        res[1] = resL[1] + resR[1] + 1;
	        res[2] = res[0] > 0? res[1] : Math.max(resL[2], resR[2]);
	        
	        if (res[0] > 0) {
//	            res[3] = resL[3];
//	            res[4] = resR[4];
	            res[3] = Math.min(root.val, resL[3]);
	            res[4] = Math.max(root.val, resR[4]);

	        }
	        
	        return res;
	    }

}
