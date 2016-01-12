package Passed;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	 public List<String> restoreIpAddresses(String s) {
	        List<String> res = new ArrayList<String>();
	        if(s == null || s.length() == 0) {
	            return res;
	        }
	        List<String> list = new ArrayList<String>();
	        helper(s,0,list,res);
	        
	        return res;
	    }
	    
	    public void helper(String s, int start, List<String> list, List<String> res) {
	        if(list.size() == 4) {
	            if(start != s.length()) return;
	            
	            StringBuilder sb = new StringBuilder();
	            for(String str : list) {
	                sb.append(str);
	                sb.append('.');
	            }
	            
	            sb.deleteCharAt(sb.length() - 1);
	            res.add(sb.toString());
	            return;
	        }
	        
	        for(int i=start; i<s.length() && i<start+3; i++) {
	            String str = s.substring(start, i+1);
	            if(isValid(str)) {
	                list.add(str);
	                helper(s,i+1,list,res);
	                list.remove(list.size()-1);
	            }
	        }
	    }
	    
	    public boolean isValid(String s) {
	        if(s.charAt(0) == '0') {
	            return s.equals("0");
	        }
	        Integer val = Integer.valueOf(s);
	        return val>=0 && val <=255;
	    }
}
