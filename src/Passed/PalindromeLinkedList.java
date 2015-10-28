package Passed;
import util.ListNode;

public class PalindromeLinkedList {
	 public boolean isPalindrome(ListNode head) {
	        ListNode fakeNode = new ListNode(-1);
	        fakeNode.next = head;
	        ListNode curr = fakeNode;
	        ListNode top = new ListNode(-1);
	        
	        while(curr.next != null) {
	            ListNode stackNode = new ListNode(curr.next.val);
	            stackNode.next = top;
	            top = stackNode;
	            curr = curr.next;
	        }
	        
	        curr = fakeNode;
	        while(curr.next != null) {
	            if(curr.next.val != top.val) {
	                return false;
	            }
	            curr = curr.next;
	            top = top.next;
	        }
	        
	        return true;
	    }

}
