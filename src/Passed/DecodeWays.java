package Passed;

public class DecodeWays {
	  public int numDecodings(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        
	        int n = s.length();
	        int[] dp = new int[n];
	        
	        String first = s.substring(0,1);
	        if(isValid(first)) dp[0] = 1;
	        
	        if(s.length() >= 2) {
	            String first2 = s.substring(0,2);
	            String second = s.substring(1,2);
	            if(isValid(second)) {
	                dp[1] = dp[0];
	            }
	            if(isValid(first2)) {
	                dp[1] += 1;
	            }
	            
	        }
	        
	        for(int i = 2; i < n; i++) {
	            String curr = s.substring(i,i+1);
	            if(isValid(curr)) {
	                dp[i] = dp[i-1];
	                
	            }
	            
	            String curr2 = s.substring(i-1, i+1);
	            if(isValid(curr2)) {
	                dp[i] += dp[i-2];
	            }
	        }
	        
	        return dp[n-1];

	    }
	    
	    public boolean isValid(String s) {
	        if (s.charAt(0) == '0') {
	            return false;
	        }
	        int num = Integer.parseInt(s);
	        return num>=1 && num <= 26;
	    }

}
