package Passed;

public class RangeAddition {
	 public int[] getModifiedArray(int length, int[][] updates) {
	        int[] res = new int[length];
	        
	        for(int[] update : updates) {
	            int start = update[0];
	            int end = update[1];
	            int val = update[2];
	            
	            res[start] += val;
	            if (end < length - 1) res[end + 1] -= val;
	        }
	        
	        for (int i = 1; i < length; i++) {
	            res[i] += res[i-1];
	        }
	        
	        return res;
	    }
}
