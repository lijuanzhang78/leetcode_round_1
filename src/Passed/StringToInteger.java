package Passed;

public class StringToInteger {
	  public int myAtoi(String str) {
	        if (str == null || str.length() == 0) {
	            return 0;
	        }
	        
	        int index = 0;
	        long num = 0;
	        int sign = 1;
	        
	        while(str.charAt(index) == ' ') {
	            index++;
	        }
	        
	        if(index == str.length()) {
	            return 0;
	        }
	        
	        if(str.charAt(index) == '+') {
	            index++;
	        } else if(str.charAt(index) == '-') {
	            sign = -1;
	            index++;
	        } else if(str.charAt(index) == '0') {
	            index++;
	        }

	        for(; index < str.length(); index++) {
	            if(str.charAt(index) < '0' || str.charAt(index) > '9') {
	                break;
	            }
	            num = num*10 + str.charAt(index) - '0';
	            if(num > Integer.MAX_VALUE) {
	                break;
	            }
	        }
	        
	        if (num * sign > Integer.MAX_VALUE) {
	            return Integer.MAX_VALUE;
	        }
	        if (num * sign < Integer.MIN_VALUE) {
	            return Integer.MIN_VALUE;
	        }
	        return (int)num*sign;	        
	    }
}
