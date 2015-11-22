package Passed;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>> ();
	        ArrayList<TreeNode> curr = new ArrayList<TreeNode> ();
	        ArrayList<TreeNode> next = new ArrayList<TreeNode> ();
	        
	        if(root != null) curr.add(root);
	        while(!curr.isEmpty()) {
	            ArrayList<Integer> nodeVal = new ArrayList<Integer>();
	            for (TreeNode inode : curr) {
	                if(inode.left != null) next.add(inode.left);
	                if(inode.right != null) next.add(inode.right);
	                nodeVal.add(inode.val);
	            }
	            
	            res.add(nodeVal);
	            curr.clear();
	            curr = next;
	            next = new ArrayList<TreeNode> ();
	        }
	        
	        return res;
	    }
}
