package Passed;

import java.util.Stack;

public class ValidParentheses {
	 public boolean isValid(String s) {
	        if(s == null || s.length() == 0 || s.length() == 1) {
	            return false;
	        }
	        
	        Stack<Character> stack = new Stack<Character>();
	        for (int i = 0; i < s.length(); i++) {
	            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
	                stack.push(s.charAt(i));
	            } else {
	                if(stack.size() == 0 ) {
	                    return false;
	                } else {
	                    char top = stack.peek();
	                    if (s.charAt(i) == ')') {
	                        if(top != '(') return false;
	                    }
	                    if(s.charAt(i) == '}') {
	                        if(top != '{') return false;
	                    }
	                    if(s.charAt(i) == '[') {
	                        if(top != '[') return false;
	                    }
	                    stack.pop();
	                     
	                }
	            }
	        }
	    
	    if(stack.size() == 0) {
	        return true;
	    } else {
	        return false;
	    }
	    }
}
