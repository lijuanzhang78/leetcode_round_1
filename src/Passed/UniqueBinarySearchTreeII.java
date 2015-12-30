package Passed;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class UniqueBinarySearchTreeII {
	  public List<TreeNode> generateTrees(int n) {
	        List<TreeNode> result = generate(1,n);
	        if (result.get(0) == null) {
	            result.remove(0);
	        }
	        return result;
	    }
	    
	    private List<TreeNode> generate (int start, int end) {
	        List<TreeNode> result = new ArrayList<TreeNode>();
	        
	        if(start > end) {
	            result.add(null);
	            return result;
	        }
	        
	        for(int i = start; i <= end; ++i) {
	            List<TreeNode> left = generate(start, i-1);
	            List<TreeNode> right = generate(i+1, end);
	            
	            for(TreeNode l : left) {
	                for(TreeNode r : right) {
	                    TreeNode root = new TreeNode(i);
	                    root.left = l;
	                    root.right = r;
	                    result.add(root);
	                }
	            }
	        }
	        
	        return result;
	    }

}
