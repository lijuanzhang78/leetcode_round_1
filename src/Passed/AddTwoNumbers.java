package Passed;
import util.ListNode;
public class AddTwoNumbers {
	  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int fac = 0, val1, val2, sum;
	        
	        ListNode fakeNode1 = new ListNode(-1);
	        fakeNode1.next = l1;
	        ListNode curr1 = fakeNode1;
	        
	        ListNode fakeNode2 = new ListNode(-1);
	        fakeNode2.next = l2;
	        ListNode curr2 = fakeNode2;
	        
	        ListNode fakeNode3 = new ListNode(-1);
	        ListNode curr3 = fakeNode3;
	        
	        while (curr1.next != null || curr2.next != null || fac > 0) {
	            if(curr1.next != null) {
	                val1 = curr1.next.val;
	            }
	            else {
	                val1 = 0;
	            }
	            
	            if(curr2.next != null) {
	                val2 = curr2.next.val;
	            }
	            else {
	                val2 = 0;
	            } 
	            
	            sum = val1 + val2 + fac;
	            fac = 0;
	            if(sum >= 10) {
	                sum %= 10;
	                fac = 1;
	            }
	            
	            ListNode node = new ListNode (sum);
	            curr3.next = node;
	            curr3 = node;
	            
	            if(curr1.next != null) curr1 = curr1.next;
	            if(curr2.next != null) curr2 = curr2.next;
	        }
	        
	        return fakeNode3.next;
	    }

}
