package Passed;

import java.util.Iterator;
import java.util.Stack;

public class FlattenNextedListIterator {
	public class NestedIterator implements Iterator<Integer> {
	    Stack<Iterator<NestedInteger>> stack = new Stack<>();
	    Integer current = null;
	    
	    public NestedIterator(List<NestedInteger> nestedList) {
	        if (nestedList != null) {
	            stack.push(nestedList.iterator());
	        }
	    }

	    @Override
	    public Integer next() {
	        return current;
	    }

	    @Override
	    public boolean hasNext() {
	        while (!Stack.isEmpty()) {
	            Iterator<NestedInteger> iter = stack.peek();
	            
	            if (!iter.hasNext()) {
	                stack.pop();
	                continue;
	            } 
	            
	            NestedInteger next = iter.next();
	            if (next.isInteger()) {
	                current = next.getInteger();
	                return true;
	            } else {
	                stack.push(next.getList().iterator());
	            }
	        }
	        return false;
	    }
	}

}
