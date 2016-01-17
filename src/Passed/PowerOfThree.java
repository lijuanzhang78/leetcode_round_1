package Passed;

public class PowerOfThree {
	  public boolean isPowerOfThree(int n) {
	        double x = Math.log10(n) / Math.log10(3);
	        if(x == (int)x) return true;
	        
	        return false;
	    }
}
