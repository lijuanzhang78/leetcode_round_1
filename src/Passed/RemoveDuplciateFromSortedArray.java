package Passed;

public class RemoveDuplciateFromSortedArray {
	 public int removeDuplicates(int[] nums) {
	        int i = 1;
	        int end = 0;
	        
	        if(nums.length == 1) return 1;
	        
	        while (i < nums.length) {
	            if(nums[i] == nums[end]) {
	                i++;
	            }
	            else {
	               end++;
	               nums[end] = nums[i];
	               i++;
	            }
	        }        
	        return end+1;        
	    }
}
