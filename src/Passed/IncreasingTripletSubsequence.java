package Passed;

public class IncreasingTripletSubsequence {
	 public boolean increasingTriplet(int[] nums) {
	        int firstMin = Integer.MAX_VALUE;
	        int secondMin = Integer.MAX_VALUE;
	        
	        for(int i = 0; i < nums.length; i++) {
	            if (nums[i] <= firstMin) {
	                firstMin = nums[i];
	            } else if (nums[i] <= secondMin) {
	                secondMin = nums[i];
	            } else {
	                return true;
	            }
	        }
	        return false;
	    }
}
