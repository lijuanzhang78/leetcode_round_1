package Passed;

public class OneEditDistance {
	  public boolean isOneEditDistance(String s, String t) {
	        int m = s.length(), n = t.length();
	        if(m == n) return isOneModified(s,t);
	        if(m - n == 1) return isOneDeleted(s,t);
	        if(n - m == 1) return isOneDeleted(t,s);
	        
	        return false;
	    }
	    
	    public boolean isOneModified(String s, String t) {
	        boolean res = true;
	        for(int i=0; i<s.length(); i++) {
	            if(s.charAt(i) != t.charAt(i)) {
	                if(res) {
	                    res = false;
	                } else {
	                    return false;
	                } 
	            }
	        }
	        return !res;
	    }
	    
	    public boolean isOneDeleted(String s, String t) {
	        for(int i = 0; i<t.length(); i++) {
	            if(s.charAt(i) != t.charAt(i)) {
	                return s.substring(i+1).equals(t.substring(i));
	            }
	        }
	        return true;
	    }
}
