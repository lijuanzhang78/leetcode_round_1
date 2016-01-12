package Passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	 public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(nums == null || nums.length == 0) return res;
	        
	        List<Integer> list = new ArrayList<Integer>();
	        Arrays.sort(nums);
	        
	        boolean[] visited = new boolean[nums.length];
	        for(int i=0; i<visited.length; i++) {
	            visited[i] = false;
	        }
	        
	        helper(nums,visited,list,res);
	        return res;
	    }
	    
	    public void helper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
	        if(list.size() == nums.length) {
	            res.add(new ArrayList<Integer>(list));
	        }
	        
	        for(int i=0; i<nums.length; i++) {
	            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) {
	                continue;
	            }
	            if(!visited[i]) {
	                list.add(nums[i]);
	                visited[i] = true;
	                helper(nums, visited, list, res);
	                list.remove(list.size() - 1);
	                visited[i] = false;
	            }
	        }
	    }

}
