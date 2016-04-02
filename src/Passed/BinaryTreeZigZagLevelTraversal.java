package Passed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class BinaryTreeZigZagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int zig = 1;
        
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(zig % 2 == 0) {
                    temp.add(0,curr.val);
                } else {
                    temp.add(curr.val);
                }
                
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            
            res.add(temp);
            zig++;
        }
        
        return res;
    }
}
