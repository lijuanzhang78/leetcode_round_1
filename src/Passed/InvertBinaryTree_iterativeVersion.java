package Passed;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class InvertBinaryTree_iterativeVersion {
	  public TreeNode invertTree(TreeNode root) {
	        if (root == null)  return root;
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        
	        while(!queue.isEmpty()) {
	            TreeNode node = queue.poll();
	            
	            TreeNode temp = node.left;
	            node.left = node.right;
	            node.right = temp;
	            
	            if (node.left != null) queue.add(node.left);
	            if (node.right != null) queue.add(node.right);
	        }
	        
	        return root;
	    }
}
