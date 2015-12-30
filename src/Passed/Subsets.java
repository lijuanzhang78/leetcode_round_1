package Passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	 public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> list = new ArrayList<Integer>();

	        if(nums == null || nums.length == 0) {
	            return result;
	        }
	        
	        Arrays.sort(nums);
	        helper(result,nums,list,0);
	        
	        return result;
	    }
	    
	    void helper(List<List<Integer>> result, int[] nums, List<Integer> list, int pos) {
	        result.add(new ArrayList<Integer>(list));
	        
	        for(int i = pos; i < nums.length; i++) {
	            list.add(nums[i]);
	            helper(result,nums,list,i+1);
	            list.remove(list.size()-1);
	        }
	    }
}
