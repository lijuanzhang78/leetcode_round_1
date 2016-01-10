package Passed;

import util.ListNode;
import util.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	 private static ListNode h;
	    
	    public TreeNode sortedListToBST(int start, int end) {
	        if(start > end) return null;
	        
	        int mid = start + (end - start)/2;
	        
	        TreeNode left = sortedListToBST(start, mid - 1);
	        TreeNode root = new TreeNode(h.val);
	        root.left = left;
	        h = h.next;
	        
	        TreeNode right = sortedListToBST(mid + 1, end);
	        root.right = right;
	        
	        return root;
	    }
	    
	    public TreeNode sortedListToBST(ListNode head) {
	        if (head == null) return null;
	        
	        h = head;
	        
	        ListNode temp = head;
	        int len = 0;
	        while(temp != null) {
	            len++;
	            temp = temp.next;
	        }
	        
	        return sortedListToBST(0, len - 1);
	    }

}
