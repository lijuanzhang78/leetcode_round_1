package Passed;

public class CopyListWithRandomPointer {
	   public RandomListNode copyRandomList(RandomListNode head) {
	        if (head == null) return null;
	        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
	        
	        RandomListNode newhead = new RandomListNode(head.label);
	        map.put(head, newhead);
	        RandomListNode oldp = head.next;
	        RandomListNode newp = newhead;
	        
	        while(oldp != null) {
	            RandomListNode newnode = new RandomListNode(oldp.label);
	            map.put(oldp, newnode);
	            newp.next = newnode;
	            
	            newp = newp.next;
	            oldp = oldp.next;
	        }
	        
	        oldp = head;
	        newp = newhead;
	        
	        while(oldp != null) {
	            newp.random = map.get(oldp.random);
	            oldp = oldp.next;
	            newp = newp.next;
	        }
	        
	        return newhead;
	    }

}
