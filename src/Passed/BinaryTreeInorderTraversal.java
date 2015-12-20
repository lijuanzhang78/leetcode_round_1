package Passed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        
        while(node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            
            if(stack.size() > 0) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }       
        return list;
    }
}
