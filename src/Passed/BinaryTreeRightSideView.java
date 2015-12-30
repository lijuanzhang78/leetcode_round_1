package Passed;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class BinaryTreeRightSideView {
	int maxDepth = 0;
    List<Integer> result = new ArrayList<Integer>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root != null) {
            helper(root, 1);
        }
        return result;
    }
    
    void helper(TreeNode root, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
            result.add(root.val);
        }
        
        if (root.right != null) {
            helper(root.right, depth + 1);
        } 
        if (root.left != null) {
            helper(root.left, depth + 1);
        }
    }
}
