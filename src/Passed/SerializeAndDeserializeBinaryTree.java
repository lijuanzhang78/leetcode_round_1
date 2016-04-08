package Passed;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	 public String serialize(TreeNode root) {
	        if (root == null) return "";
	        StringBuilder sb = new StringBuilder();
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        
	        while(!queue.isEmpty()) {
	            TreeNode curr = queue.poll();
	            if (curr == null) {
	                sb.append("# ");
	                continue;
	            } else {
	                sb.append(curr.val + " ");
	            }
	            
	            queue.add(curr.left);
	            queue.add(curr.right);
	        }
	        
	        return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        if (data == "") return null;
	        Queue<TreeNode> queue = new LinkedList<>();
	        String[] str = data.split(" ");
	        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
	        queue.add(root);
	        
	        for(int i = 1; i < str.length; i++) {
	            TreeNode parent = queue.poll();
	            
	            if(!str[i].equals("#")) {
	                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
	                parent.left = left;
	                queue.add(left);
	            } 
	            if(!str[++i].equals("#")) {
	                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
	                parent.right = right;
	                queue.add(right);
	            }
	        }
	        
	        return root;
	    }
	    
	    
// second solution	    
	    public String serialize(TreeNode root) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        serializeHelper(root,result);
	        return result.toString();
	    }

	    private void serializeHelper(TreeNode root, ArrayList<Integer> result){
	        if (root == null) {
	            result.add(null);
	            return;
	        }
	        result.add(root.val);
	        serializeHelper(root.left,result);
	        serializeHelper(root.right,result);
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] strArray = data.substring(1,data.length()-1).split(", ");
	        Deque<String> strList = new LinkedList<String>(Arrays.asList(strArray)); 
	        return deserializeHelper(strList);
	    }

	    private TreeNode deserializeHelper(Deque<String> strList){
	        if (strList.size() == 0) return null;
	        String str = strList.pop();
	        if (str.equals("null")) return null;
	        TreeNode currentRoot = new TreeNode(Integer.parseInt(str));
	        currentRoot.left = deserializeHelper(strList);
	        currentRoot.right = deserializeHelper(strList);
	        return currentRoot;
	    }

}
