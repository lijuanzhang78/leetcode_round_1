package Passed;

public class SearchForARange {
	 public int[] searchRange(int[] nums, int target) {
	        int start = 0;
	        int end = nums.length - 1;
	        int[] res = new int[2];
	        
	        if(nums.length == 1) {
	            if(nums[0] == target) {
	                res[0] = 0;
	                res[1] = 0;
	            } else {
	                res[0] = -1;
	                res[1] = -1;
	            }
	            return res;
	        }

	        while (start < end - 1 ) {
	            int mid = start + (end - start) / 2;
	            if (nums[mid] < target) {
	                start = mid;
	            } else {
	                end = mid;
	            } 
	        }
	        
	        if (nums[start] == target) {
	            res[0] = start;
	        } else if (nums[end] == target) {
	            res[0] = end;
	        } else {
	            res[0] = res[1] = -1;
	            return res;
	        }
	        
	        end = nums.length - 1;
	        start = 0;
	        while (start < end - 1 ) {
	            int mid = start + (end - start) / 2;
	            if (nums[mid] > target) {
	                end = mid;
	            }
	            else {
	                start = mid;
	            }
	        }
	        
	        if(nums[end] == target) {
	            res[1] = end;
	        } else if(nums[start] == target) {
	            res[1] = start;
	        } 
	        
	        return res;
	    }

}
