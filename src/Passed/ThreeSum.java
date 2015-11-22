package Passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>> ();
	        if(nums.length < 3) return res;
	        
	        Arrays.sort(nums);
	        
	        for(int i = 0; i < nums.length - 2; i++) {
	            if(i == 0 || nums[i] > nums[i-1]) {
	                int target = -nums[i];
	                int start = i + 1;
	                int end = nums.length - 1;
	                
	                while (start < end) {
	                    if(nums[start] + nums[end] == target) {
	                        ArrayList<Integer> temp = new ArrayList<Integer> ();
	                        temp.add(nums[i]);
	                        temp.add(nums[start]);
	                        temp.add(nums[end]);
	                        res.add(temp);
	                        start++;
	                        end--;
	                        
	                        while(start < end && nums[end] == nums[end+1]) {
	                            end--;
	                        }
	                        while(start < end && nums[start] == nums[start-1]) {
	                            start++;
	                        }
	                    } else if(nums[start] + nums[end] < target) {
	                        start++;
	                    } else {
	                        end--;
	                    }
	                }
	            }
	        }
	        return res;
	    }

}
