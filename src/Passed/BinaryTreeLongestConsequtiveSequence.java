package Passed;

import util.TreeNode;

public class BinaryTreeLongestConsequtiveSequence {
	private int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1, root.val + 1);
        
        return maxLen;
    }
    
    private void dfs(TreeNode root, int len, int target) {
        if (root == null) return;
        
        if (root.val == target) {
            len++;
        } else {
            len = 1;
        }
        
        maxLen = Math.max(maxLen, len);
        
        dfs(root.left, len, root.val + 1);
        dfs(root.right, len, root.val + 1);
    }
}
