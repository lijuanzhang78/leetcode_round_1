package Passed;

public class PlusOne {
	  public int[] plusOne(int[] digits) {
	        Boolean is9 = true;
	        for(int i = 0; i < digits.length; i++) {
	            if (digits[i] != 9) {
	                is9 = false;
	            } 
	        }
	        if(is9) {
	            int[] res = new int[digits.length + 1];
	            for(int i = 0; i < digits.length + 1; i++) {
	                if(i == 0) {
	                    res[i] = 1;
	                } 
	                else {
	                    res[i] = 0;
	                }
	                return res;
	            }
	        }
	        
	        int fac = 1;
	        for (int i = digits.length - 1; i >= 0; i--) {
	            if(digits[i] + fac > 9) {
	                digits[i] = (digits[i] + fac) % 10;
	                fac = 1;
	            } 
	            else {
	                if (i == digits.length - 1) {
	                    digits[i] ++;
	                    fac = 0;
	                }
	                else {
	                    digits[i] += fac;
	                    fac = 0;
	                }
	            }
	        }
	        return digits;
	    }
}
