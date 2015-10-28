package Passed;

import util.ListNode;

public class ReverseLinkedListII {
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        ListNode fakeNode = new ListNode(0);
	        fakeNode.next = head;
	        ListNode preM = fakeNode;
	        ListNode pre = null, curr = null;
	        
	        for(int i = 1; i <= n; i++) {
	            if(i < m) {
	                preM = preM.next;
	            } else if (i == m) {
	                pre = preM.next;
	                curr = pre.next;
	            } else {
	                pre.next = curr.next;
	                curr.next = preM.next;
	                preM.next = curr;
	                curr = pre.next;
	            }
	        }
	        
	        return fakeNode.next;
	    }

}
