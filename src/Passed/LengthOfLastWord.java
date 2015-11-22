package Passed;

public class LengthOfLastWord {
	 public int lengthOfLastWord(String s) {
	        String[] a = s.split(" ");
	        
	        if(a == null || a.length == 0) {
	            return 0;
	        }
	        
	        return a[a.length - 1].length();	        
	    }
}
