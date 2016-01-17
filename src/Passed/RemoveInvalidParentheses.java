package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null) {
            return res;
        }
        
        Queue<String> queue = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        queue.add(s);
        map.put(s,1);
        boolean found = false;
        while(queue.size() > 0) {
            String str = queue.poll();
            if(isValid(str)) {
                res.add(str);
                found = true;
            } else {
                if(found) continue;
                for(int i=0; i<str.length(); i++) {
                    if(str.charAt(i) != '(' && str.charAt(i) != ')') {
                        continue;
                    }
                    String next = str.substring(0,i) + str.substring(i+1);
                    if(!map.containsKey(next)) {
                        queue.add(next);
                        map.put(next,1);
                    }
                }
            }
        }
        return res;
    }
    
public boolean isValid(String str) {
    Stack<Character> stack = new Stack<Character>();
    
    for(int i = 0; i < str.length(); i++) {
        if(str.charAt(i) == '(') {
            stack.push(str.charAt(i));
        } else if (str.charAt(i) == ')') {
            if(!stack.empty()) {
                stack.pop();
            } else {
                return false;
            }
        }
    }
    return stack.empty();
}    
}
