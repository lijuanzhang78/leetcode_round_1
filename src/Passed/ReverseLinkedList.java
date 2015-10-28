package Passed;

import util.ListNode;

public class ReverseLinkedList {
	   public ListNode reverseList(ListNode head) {
	        ListNode fakeNode = new ListNode(0);
	        fakeNode.next = head;
	        ListNode curr = fakeNode;
	        ListNode preNode = null;
	        ListNode newHead = null;

	        while(curr.next != null) {
	            ListNode newNode = new ListNode(curr.next.val);
	            newNode.next = preNode;
	            newHead = newNode;
	            preNode = newNode;
	            curr = curr.next;
	            
	        }
	        
	        return newHead;        
	    }
}
