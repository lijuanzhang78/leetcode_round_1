package Passed;

public class sqrtX {
	 public int mySqrt(int x) {
	        long start = 0;
	        long end = x/2 + 1; 
	        
	        while (start <= end) {
	            long mid = (start+end)/2;
	            long temp = mid*mid;
	            
	            if(temp > x) {   
	                end = mid - 1;
	            } else if(temp < x) {
	                start = mid + 1;
	            } else {
	                return (int)mid;
	            }
	        }
	        if(start*start > x) return (int)start - 1;
	        return (int)start;
	    
	    }
}
