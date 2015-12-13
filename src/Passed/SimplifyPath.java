package Passed;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";
        
        String[] tokens = path.split("/");
        Stack<String> stack1 = new Stack<String>();
        
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("..")) {
                if(stack1.size() > 0) {
                    stack1.pop();
                } else {
                    continue;
                }
            } else if (tokens[i].equals(".")|| tokens[i].equals("")) {
                continue;
            } else {
                stack1.push(tokens[i]);
            }
        }
        
        String res = "";
        if(stack1.size() == 0) {
            res += "/";
            return res;
        }
        
        Stack<String> stack2 = new Stack<String>();
        
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        
        while (stack2.size() > 0) {
            res += "/";
            res += stack2.pop();
        }
        
        return res;
    }

}
