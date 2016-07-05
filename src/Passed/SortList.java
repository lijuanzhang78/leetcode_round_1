package Passed;

import util.ListNode;

public class SortList {
	 public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) return head;
	        
	        ListNode mid = findMid(head);
	        ListNode right = sortList(mid.next);
	        mid.next = null;
	        ListNode left = sortList(head);
	        return merge(left, right);
	    }
	    
	    ListNode merge(ListNode head1, ListNode head2) {
	        ListNode dummy = new ListNode(0);
	        ListNode cur = dummy;
	        while(head1 != null && head2 != null) {
	            if (head1.val > head2.val) {
	                cur.next = head2;
	                head2 = head2.next;
	            } else {
	                cur.next = head1;
	                head1 = head1.next;
	            }
	            cur = cur.next;
	        }
	        
	        if (head1 != null) cur.next = head1;
	        if (head2 != null) cur.next = head2;
	        
	        return dummy.next;
	    }
	    
	    ListNode findMid(ListNode head) {
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        while(fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        return slow;
	    }
}
