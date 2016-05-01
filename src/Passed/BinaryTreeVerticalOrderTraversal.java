package Passed;

public class BinaryTreeVerticalOrderTraversal {
	 List<List<Integer>> res = new ArrayList<List<Integer>>();
     if (root == null) return res;
     
     Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
     Queue<TreeNode> queue = new LinkedList<>();
     Map<TreeNode, Integer> cols = new HashMap<TreeNode, Integer>();
     int min = 0;
     
     queue.add(root);
     cols.put(root, 0);
     
     while(!queue.isEmpty()) {
         TreeNode curr = queue.poll();
         int col = cols.get(curr);
         if (!map.containsKey(col)) {
             map.put(col, new ArrayList<Integer>());
         }
         map.get(col).add(curr.val);
         
         if (root.left != null) {
             cols.put(root.left, col - 1);
             queue.add(root.left);
         }
         if (root.right != null) {
             cols.put(root.right, col + 1);
             queue.add(root.right);
         }
         min = Math.min(min, col);
     }
     
     while(map.containsKey(min)) {
         res.add(map.get(min++));
     }
     
     return res;

}
