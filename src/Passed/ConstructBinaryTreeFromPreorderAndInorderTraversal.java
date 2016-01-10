package Passed;

import util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        int prestart = 0;
	        int preend = preorder.length - 1;
	        int instart = 0;
	        int inend = inorder.length - 1;
	        
	        return helper(preorder, prestart, preend, inorder, instart, inend);    
	    }
	        
	    public TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
	        if (prestart > preend || instart > inend) {
	            return null;
	        }
	        
	        int val = preorder[prestart];
	        TreeNode p = new TreeNode(val);
	        int k = 0;
	        for(int i = 0; i < inorder.length; i++) {
	            if(val == inorder[i]) {
	                k = i;
	                break;
	            }
	        }
	        
	        p.left = helper(preorder, prestart+1, prestart+k-instart, inorder, instart, instart+k-1);
	        p.right = helper(preorder, prestart+k-instart+1, preend, inorder, k+1, inend);
	        
	        return p;
	    }

}
