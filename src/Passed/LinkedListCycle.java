package Passed;

import util.ListNode;

public class LinkedListCycle {
	 public boolean hasCycle(ListNode head) {
	        ListNode fakeNode = new ListNode(0);
	        fakeNode.next = head;
	        ListNode ptr = fakeNode;
	        ListNode ptr2 = fakeNode.next;
	        
	        while(ptr != null && ptr2 != null) {
	            if(ptr == ptr2) return true;
	            
	            ptr = ptr.next;
	            if (ptr2.next != null) { 
	                ptr2 = ptr2.next.next;
	            } else {
	                ptr2 = null;
	            }
	        }
	        
	        return false;
	    }
}
