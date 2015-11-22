package Passed;

public class SearchInRotatedSortedArray {
	 public int search(int[] nums, int target) {
	        int pivot = 0;
	        for(int i = 1; i < nums.length; i++) {
	            if (nums[i] < nums[i-1]) {
	                pivot = i;
	                break;
	            }
	        }
	        
	        if(pivot == 0) return binarySearch(0, nums.length - 1, target, nums);
	        if(target > nums[0]) {
	            return binarySearch (0, pivot - 1, target, nums);
	        } else if (target < nums[0]) {
	            return binarySearch (pivot, nums.length - 1, target, nums);
	        } else {
	            return 0;
	        }
	    }
	    
	    
	    public int binarySearch(int start, int end, int target, int[] nums) {
	        
	        while (start <= end) {
	            int mid = start + (end - start) / 2;
	            if(nums[mid] == target) {
	                return mid;
	            } else if (nums[mid] < target) {
	                start = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }
	        
	        return -1;
	    }

}
