package Passed;

import java.util.Stack;

public class VerifyPreorderSerilizationOfBinaryTree {
	 public boolean isValidSerialization(String preorder) {
	        if (preorder == null || preorder.length() == 0) return false;
	        
	        Stack<String> stack = new Stack<String>();
	        String[] str = preorder.split(",");
	        
	        for(int pos = 0; pos < str.length; pos++) {
	            String curr = str[pos];
	            
	            while(curr.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
	                stack.pop();
	                if (stack.isEmpty()) return false;
	                stack.pop();
	            }
	            
	            stack.push(curr);
	        }
	        
	        if(stack.size() == 1 && stack.peek().equals("#")) return true;
	        return false;
	    }
}
