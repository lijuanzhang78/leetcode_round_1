package Passed;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	 public List<String> generatePossibleNextMoves(String s) {
	        List<String> res = new ArrayList<String>();
	        if(s == null || s.length() <= 1) {
	            return res;
	        }
	        
	        for(int i=0; i < s.length()-1; i++) {
	            if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
	                String str = "";
	                if(i-1>=0) str = s.substring(0,i);
	                str += "--";
	                if(i+2 < s.length()) str += s.substring(i+2);
	                res.add(str);
	            }
	        }
	        
	        return res;
	    }
}
