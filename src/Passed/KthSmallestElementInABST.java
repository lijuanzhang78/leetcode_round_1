package Passed;

import util.TreeNode;

public class KthSmallestElementInABST {
	   int count = 0;
	    int result = 0;
	    public int kthSmallest(TreeNode root, int k) {
	        if (root.left != null) {
	            kthSmallest(root.left, k);
	        }
	        
	        count += 1;
	        if (count == k) {
	            result = root.val;
	        }
	        
	        if (root.right != null) {
	            kthSmallest(root.right, k);
	        }
	        
	        return result;
	    }

}
