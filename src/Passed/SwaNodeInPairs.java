package Passed;
import util.ListNode;
public class SwaNodeInPairs {
	   public ListNode swapPairs(ListNode head) {
	        ListNode fakeNode = new ListNode(0);
	        fakeNode.next = head;
	        ListNode curr = fakeNode;
	        
	        while (curr.next != null && curr.next.next != null) {
	            ListNode temp = curr.next.next.next;
	            ListNode temp2 = curr.next.next;
	            curr.next.next.next = curr.next;
	            curr.next.next = temp;
	            curr.next = temp2;
	            
	            curr = curr.next.next;
	            
	        }
	     
	        return fakeNode.next;
	    }
}
