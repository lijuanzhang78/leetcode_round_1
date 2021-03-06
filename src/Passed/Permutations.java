package Passed;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	 public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if (nums == null || nums.length == 0) return result;
	        
	        List<Integer> list = new ArrayList<Integer>();
	        helper(result, list, nums);
	        return result;
	    }
	    
	    public void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
	        if(list.size() == nums.length) {
	            result.add(new ArrayList<Integer>(list));
	            return;
	        }
	        
	        for (int i = 0; i < nums.length; i++) {
	            if (list.contains(nums[i])) {
	                continue;
	            }
	            list.add(nums[i]);
	            helper(result,list,nums);
	            list.remove(list.remove(list.size()-1));
	        }
	    }
	    
	    public static void main(String[] args) {
	    	int[] nums = {1,2,3};
	    	List<List<Integer>> res = new Permutations().permute(nums);	    	
	    }
}
