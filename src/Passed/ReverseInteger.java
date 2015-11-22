package Passed;

public class ReverseInteger {
	public int reverse(int x) {
        boolean isNeg = x > 0? false:true;
        if(isNeg) x = 0 - x;
        
        long result = 0;
        while (x > 0) {
            int lastDigit = x%10;
            result = result*10 + lastDigit;
            x /= 10;
        }
        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return isNeg? (int)(0-result):(int)result;
    }

}
