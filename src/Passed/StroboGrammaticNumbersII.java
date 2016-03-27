package Passed;

import java.util.ArrayList;
import java.util.List;

public class StroboGrammaticNumbersII {
	  List<String> res = new ArrayList<String>();
	    
	    public List<String> findStrobogrammatic(int n) {
	        char[] a = new char[n]; 
	        helper(a, 0, n-1);
	        
	        return res;
	    }
	    
	    public void helper(char[] a, int l, int r) {
	        if (l > r) {
	            res.add(new String(a));
	            return;
	        }
	        
	        if (l == r) {
	            a[l] = '0'; res.add(new String(a));
	            a[l] = '1'; res.add(new String(a));
	            a[l] = '8'; res.add(new String(a));
	            return; 
	        }
	        
	        if (l != 0) {
	            a[l] = '0'; a[r] = '0'; helper(a, l+1, r-1);
	        }
	        
	        a[l] = '1'; a[r] = '1'; helper(a, l+1, r-1);
	        a[l] = '8'; a[r] = '8'; helper(a, l+1, r-1);
	        a[l] = '6'; a[r] = '9'; helper(a, l+1, r-1);
	        a[l] = '9'; a[r] = '6'; helper(a, l+1, r-1);
	    }
}
