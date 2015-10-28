package Passed;
import util.ListNode;

public class RemoveDuplicatesfromSortedListII {
	  public ListNode deleteDuplicates(ListNode head) {
	        ListNode fakeNode = new ListNode(-1);
	        fakeNode.next = head;
	        ListNode curr = fakeNode;
	        ListNode pre = fakeNode;
	        
	        while(curr.next != null) {
	            pre = curr;
	            ListNode ptr = curr.next;
	            int val = curr.next.val;
	            int k = 0;
	            
	            while (ptr != null && ptr.val == val) {
	                ptr = ptr.next;
	                ++k;
	            }
	            
	            if (k >= 2)  {
	                curr.next = ptr;    
	            }
	            else {
	                curr = curr.next;
	            }
	        }
	        return fakeNode.next;	            
	    }
}
