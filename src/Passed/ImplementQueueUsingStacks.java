package Passed;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	 Stack<Integer> stack1 = new Stack<Integer> ();
	    Stack<Integer> stack2 = new Stack<Integer> ();
	        
	    // Push element x to the back of queue.
	    public void push(int x) {
	        stack1.push(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if(this.empty()) return;
	        if (stack2.empty()) {
	            while(!stack1.empty()) {
	                stack2.push(stack1.pop());
	            }
	            stack2.pop();
	        } else {
	            stack2.pop();
	        }
	    }

	    // Get the front element.
	    public int peek() {
	        if(this.empty()) return 0;
	        if (stack2.empty()) {
	            while(!stack1.empty()) {
	                stack2.push(stack1.pop());
	            }
	            return stack2.peek();
	        } else {
	            return stack2.peek();
	        }
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        if(stack1.empty() && stack2.empty()) return true;
	        return false;
	    }

}
