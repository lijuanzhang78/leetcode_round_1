package Passed;

import java.util.LinkedList;

public class ImplementStacksUsingQueues {
	 
    LinkedList<Integer> q1 = new LinkedList<Integer>();
    LinkedList<Integer> q2 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(q1.isEmpty()) return;
        while (q1.size() > 1) {
            q2.add(q1.pop());
        } 
        if(q1.size() == 1) {
            q1.pop();
            LinkedList<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
    }

    // Get the top element.
    public int top() {
        int temp = 0;
        if(q1.isEmpty()) return 0;
        while (q1.size() > 1) {
            q2.add(q1.pop());
        } 
        if (q1.size() == 1) {
            temp = q1.peek();
            q2.add(q1.pop());
            LinkedList<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }
        
        return temp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(q1 == null || q1.isEmpty()) return true;
        return false;
        
    }

}
