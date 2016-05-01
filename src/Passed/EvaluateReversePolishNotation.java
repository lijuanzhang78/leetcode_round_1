package Passed;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	  public int evalRPN(String[] tokens) {
	        if (tokens == null || tokens.length == 0) return 0;
	        int a, b;
	        Stack<Integer> s = new Stack<>();
	        for (String str : tokens) {
	            if (str.equals("+")) {
	                s.push(s.pop() + s.pop());
	            } 
	            else if (str.equals("-")) {
	                b = s.pop();
	                a = s.pop();
	                s.push(a-b);
	            } 
	            else if (str.equals("*")) {
	                s.push(s.pop() * s.pop());
	            }
	            else if (str.equals("/")) {
	                b = s.pop();
	                a = s.pop();
	                s.push(a/b);
	            }
	            else {
	                s.push(Integer.parseInt(str));
	            }
	        }	        
	        return s.pop();
	    }
}
