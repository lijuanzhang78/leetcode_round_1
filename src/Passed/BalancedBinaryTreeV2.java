package Passed;

import util.TreeNode;

public class BalancedBinaryTreeV2 {
//  to avoid recursion in recursion
    public boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }
    
    int maxDepth(TreeNode root) {
        if (root == null || isBalanced == false) 
            return 0;
        else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            
            if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;
            return leftHeight > rightHeight? (leftHeight+1) : (rightHeight+1);
        }
    }
	
}
