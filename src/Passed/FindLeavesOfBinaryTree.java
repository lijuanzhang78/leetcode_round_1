package Passed;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class FindLeavesOfBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, res);
        return res;
    }
    
    private int helper(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        
        int level = Math.max(helper(node.left, res), helper(node.right, res)) + 1;
        if (res.size() < level + 1) res.add(new ArrayList<Integer>());
        res.get(level).add(node.val);
        return level;
    }
}
