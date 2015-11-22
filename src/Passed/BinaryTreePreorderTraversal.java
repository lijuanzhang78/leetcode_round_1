package Passed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        List<Integer> res = new ArrayList<Integer> ();
        
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }

}
