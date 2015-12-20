package Passed;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class PathSumII {
	  public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> solution = new ArrayList<Integer>();
	        if (root == null) return result;
	        
	        helper (root, sum, solution, result);
	        return result;
	    }
	    
	    void helper(TreeNode root, int target, List<Integer> solution, List<List<Integer>> result) {
	        if (root == null) return;
	        
	        target -= root.val;
	        if (root.left == null && root.right == null && target == 0) {
	            solution.add(root.val);
	            result.add(new ArrayList<Integer>(solution));
	            solution.remove(solution.size() - 1);
	        }
	        
	        solution.add(root.val);
	        helper(root.left, target, solution, result);
	        helper(root.right, target, solution, result);
	        solution.remove(solution.size() - 1);
	    }
}
