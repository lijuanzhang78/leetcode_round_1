package Passed;

import util.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
	        int instart = 0;
	        int inend = inorder.length - 1;
	        int poststart = 0;
	        int postend = postorder.length - 1;
	        
	        return helper(inorder, instart, inend, postorder, poststart, postend);
	    }
	    
	    public TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
	        if(instart > inend || poststart > postend) {
	            return null;
	        }
	        
	        int val = postorder[postend];
	        TreeNode p = new TreeNode(val);
	        int k = 0;
	        for(int i=0; i < inorder.length; i++) {
	            if(val == inorder[i]) {
	                k = i;
	                break;
	            }
	        }
	        
	        p.left = helper(inorder, instart, k-1, postorder, poststart, poststart+k-instart-1);
	        p.right =helper(inorder, k+1, inend, postorder, poststart+k-instart, postend-1);
	        
	        return p;
	    }

}
