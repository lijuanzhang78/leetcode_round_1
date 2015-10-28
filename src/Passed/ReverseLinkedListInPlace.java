package Passed;

import util.ListNode;

public class ReverseLinkedListInPlace {
	  public ListNode reverseList(ListNode head) {
	        
	        ListNode pre = head;
	        if(head == null) return null;
	        ListNode curr = pre.next;
	        
	        while(curr != null) {
	            ListNode theNext = curr.next;
	            pre.next = theNext;
	            curr.next = head;
	            head = curr;
	            
	            curr = theNext;
	        }    
	            
	        return head;    
	    }
}
