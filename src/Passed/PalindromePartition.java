package Passed;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	  public List<List<String>> partition(String s) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        if(s == null || s.length() == 0) {
	            return res;
	        }
	        
	        List<String> list = new ArrayList<String>();
	        dfs(s,0,list,res);
	        return res;
	    }
	    
	    public void dfs(String s, int start, List<String> list, List<List<String>> res) {
	        if(start == s.length()) {
	            res.add(new ArrayList<String>(list));
	        }
	        
	        for(int i=start; i<s.length(); i++) {
	            String str = s.substring(start,i+1);
	            if(isValidPalindrome(str)) {
	                list.add(str);
	                dfs(s,i+1,list,res);
	                list.remove(list.size()-1);
	            }
	        }
	    } 
	    
	    public boolean isValidPalindrome(String s) {
	        int low = 0;
	        int high = s.length() - 1;
	        
	        while(low < high) {
	            if(s.charAt(low) == s.charAt(high)) {
	                low++;
	                high--;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }

}
