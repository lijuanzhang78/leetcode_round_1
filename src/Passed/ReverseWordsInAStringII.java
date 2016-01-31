package Passed;

public class ReverseWordsInAStringII {
	 public void reverseWords(char[] s) {
	        if (s == null || s.length == 0) {
	            return;
	        }
	        
	        reverse(s, 0, s.length-1);
	        
	        int lastend = 0;
	        for(int i=0; i<s.length; i++) {
	            if(s[i] == ' ') {
	                reverse(s, lastend, i-1);
	                lastend = i+1;
	            }
	            
	            if(i == s.length - 1) {
	                reverse(s,lastend,i);
	            }
	        }
	    }
	    
	    void reverse(char[] s, int start, int end) {
	        while(start < end) {
	            char temp = s[start];
	            s[start] = s[end];
	            s[end] = temp;
	            start++;
	            end--;
	        }
	    }
}
