package Passed;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            if (nums[start] == target) {
                return start; } 
            else if (nums[end] == target) {
                return end; }
            else {
                int mid = (start + end)/2;
                if(nums[mid] > target) {
                    end = mid - 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
     return nums[start] < target? start + 1 : start;  
        
    }

}
