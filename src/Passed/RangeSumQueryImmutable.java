package Passed;

public class RangeSumQueryImmutable {
	public class NumArray {
	    
	    private int[] sums;
	    
	    public NumArray(int[] nums) {
	        int len = nums.length;
	        sums = new int[len];
	        if(nums==null || nums.length == 0) {
	            return;
	        }
	        sums[0] = nums[0];
	        
	        for(int i = 1; i < len; i++) {
	            sums[i] = nums[i] + sums[i-1];
	        }
	    }

	    public int sumRange(int i, int j) {
	        return i==0? sums[j]:sums[j]-sums[i-1];
	    }
	}
}
