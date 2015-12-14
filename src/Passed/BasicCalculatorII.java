package Passed;

public class BasicCalculatorII {
	 public int calculate(String s) {
	        if (s == null || s.length() == 0) return 0;
	        
	        int sign = 1;
	        int mulDiv = -1;
	        int res = 0;
	        int preV = 1;
	        
	        for(int i=0; i<s.length(); i++) {
	            if (Character.isDigit(s.charAt(i))) {
	                int num = s.charAt(i) - '0';
	                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
	                    num = num*10 + s.charAt(++i) - '0';
	                }
	                if(mulDiv == 0) {
	                    preV *= num;
	                    mulDiv = -1;
	                } else if(mulDiv == 1) {
	                    preV /= num;
	                    mulDiv = -1;
	                } else {
	                    preV = num;
	                }
	            } else if(s.charAt(i) == '+') {
	                res += sign*preV;
	                sign = 1;
	            } else if(s.charAt(i) == '-') {
	                res += sign*preV;
	                sign = -1;
	            } else if(s.charAt(i) == '*') {
	                mulDiv = 0;
	            } else if(s.charAt(i) == '/') {
	                mulDiv = 1;
	            }
	        }
	        
	        res += sign*preV;
	        return res;
	        
	    }

}
