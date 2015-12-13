package Passed;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack1 = new Stack<Integer> ();
    Stack<Integer> stack2 = new Stack<Integer> ();
    
    public void push(int x) {
        stack1.push(x);
        if(stack2.empty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }

    public void pop() {
        if (stack2.peek().equals(stack1.peek())) {
            stack2.pop();
        }
        
        stack1.pop();
    }

    public int top() {
        if (stack1.empty()) {
            return Integer.MIN_VALUE;
        } else {
            return stack1.peek();
        }
    }

    public int getMin() {
        if (stack2.empty()) {
            return Integer.MIN_VALUE;
        } else {
            return stack2.peek();
        }
    }
    
    public static void main(String args[]) {
    	MinStack ms = new MinStack();
    	ms.push(50);
    	ms.push(-100);
    	ms.push(-100);
    	ms.push(50);
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    }
}
