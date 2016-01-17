package Passed;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	 public List<String> generateParenthesis(int n) {
	        List<String> res = new ArrayList<String>();
	        if(n<=0) {
	            return res;
	        }
	        
	        helper(res, "", n, n);
	        return res;
	    }
	    
	    public void helper(List<String> res, String str, int left, int right) {
	        if(left == 0 && right == 0) {
	            res.add(new String(str));
	            return;
	        }
	        
	        if(left > 0) {
	            helper(res, str+"(", left-1, right);
	        }
	        
	        if(right > 0 && left < right) {
	            helper(res, str+")", left, right-1);
	        }
	    }	 
}
