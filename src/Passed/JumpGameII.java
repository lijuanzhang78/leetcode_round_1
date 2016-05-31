package Passed;

public class JumpGameII {
	 public int jump(int[] nums) {
	        if (nums.length == 1) return 0;
	        int count = 1;
	        int max = 0;
	        
	        int start = 0, end = nums[0];
	        while (end < nums.length - 1) {
	            count++;
	            
	            for(int i = start; i <= end; i++) {
	                max = Math.max(max, nums[i] + i);
	            }
	            start = end;
	            end = max;
	        }
	        return count;
	    }
}
