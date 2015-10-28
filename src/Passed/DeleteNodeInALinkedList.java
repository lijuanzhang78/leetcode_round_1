package Passed;

import util.ListNode;

public class DeleteNodeInALinkedList {
	 public void deleteNode(ListNode node) {
	        ListNode theNext = node.next;
	        node.val = theNext.val;
	        node.next = theNext.next;
	    }
}
