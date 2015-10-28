package Passed;

public class LongestCommonPrefix {
	 public String longestCommonPrefix(String[] strs) {
	        if(strs == null || strs.length == 0) {
	            return "";
	        }
	        
	        int minLen = Integer.MAX_VALUE;
	        for(String str: strs) {
	            if(str.length() < minLen) {
	                minLen = str.length();
	            }
	        }
	        
	        if(minLen == 0) return "";
	        for(int j = 0; j < minLen; j++) {
	            char temp = '0';
	            for(int i = 0; i < strs.length; i++) {
	                if (i == 0) {
	                    temp = strs[0].charAt(j);
	                    continue;
	                }
	                if(strs[i].charAt(j) != temp) {
	                    return strs[i].substring(0,j);
	                }
	            }
	        }
	        return strs[0].substring(0, minLen);
	    }
}
