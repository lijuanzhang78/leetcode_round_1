package Passed;

public class RemoveDuplicatesFromSortedArrayII {
	 public int removeDuplicates(int[] nums) {
	        int i = 1;
	        int end1 = 0;
	        int end2 = 0;
	        
	        if(nums.length == 1) return 1;
	        
	        while (i < nums.length) {
	            if(nums[i] == nums[end2]) {
	                if(end1 == end2) {
	                    end2++;
	                    nums[end2] = nums[i];
	                }
	                i++;
	            }
	            else {
	               end2++;
	               end1 = end2;
	               nums[end1] = nums[i];
	               i++;
	            }
	        }        
	        return end2+1;
	    }
}
