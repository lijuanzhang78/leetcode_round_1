package Passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(candidates == null || candidates.length == 0) {
	            return res;
	        }
	        List<Integer> list = new ArrayList<Integer>();
	        Arrays.sort(candidates);
	        helper(candidates, target, 0, list, res);
	        
	        return res;
	    }
	    
	    void helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res) {
	        if(target < 0) {
	            return;
	        }
	        if(target == 0) {
	            if (!res.contains(list)) res.add(new ArrayList<Integer>(list));
	            return;
	        }
	        
	        for(int i = start; i < candidates.length; i++) {
	            list.add(candidates[i]);
	            int newtarget = target - candidates[i];
	            helper(candidates, newtarget, i+1, list, res);
	            list.remove(list.size()-1);
	        }
	    }

}
