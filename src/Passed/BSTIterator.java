package Passed;

import java.util.Stack;

import util.TreeNode;

public class BSTIterator {
	    Stack<TreeNode> stack;

	    public BSTIterator(TreeNode root) {
	        stack = new Stack<TreeNode> ();
	        while(root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	        
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode node = stack.pop();
	        int ret = node.val;
	        
	        if(node.right != null) {
	            node = node.right;
	            while(node != null) {
	                stack.push(node);
	                node = node.left;
	            }
	        }
	        return ret;
	    }
	}

