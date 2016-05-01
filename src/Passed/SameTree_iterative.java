package Passed;

import java.util.Stack;

import util.TreeNode;

public class SameTree_iterative {
	 public boolean isSameTree(TreeNode p, TreeNode q) {
	       Stack<TreeNode[]> stack = new Stack<>();
	       
	       stack.push(new TreeNode[] {p,q});
	       
	       while(!stack.isEmpty()) {
	           TreeNode[] pair = stack.pop();
	           if (pair[0] == null && pair[1] == null) continue;
	           if (pair[0] == null || pair[1] == null) return false;
	           
	        
	           if (pair[0].val == pair[1].val) {
	               stack.push(new TreeNode[] {pair[0].left, pair[1].left});
	               stack.push(new TreeNode[] {pair[0].right, pair[1].right});
	           } else {
	               return false;
	           }
	       }
	       
	       return true;
	    }
}
