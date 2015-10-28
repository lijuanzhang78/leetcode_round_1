package Passed;

public class RotateArray {
	  public void rotate(int[] nums, int k) {
	        k = k % nums.length;
	        reverse(nums, 0, nums.length - 1);
	        reverse(nums, 0, k - 1);
	        reverse(nums, k, nums.length - 1);
	    }
	    
	    public void reverse (int[] nums, int begin, int end) {
	        int len = end - begin + 1;
	        int steps = len / 2;
	        int temp = 0;
	        for (int i = 0; i < steps; i++) {
	            temp = nums[begin + i];
	            nums[begin + i] = nums[end - i];
	            nums[end - i]  = temp;
	        }
	    }
}
