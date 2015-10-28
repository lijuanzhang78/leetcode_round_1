package Passed;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
	  public boolean isHappy(int n) {
	        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
	        while ( n != 1) {
	            n = getsum(n);
	            if(!hashmap.containsKey(n)) {
	                hashmap.put(n,0);
	            } else {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	    
	    public int getsum (int n) {
	        int sum = 0;
	        while (n != 0) {
	            sum += (n % 10) * (n % 10);
	            n /= 10;
	        }
	        return sum;
	    }
}
