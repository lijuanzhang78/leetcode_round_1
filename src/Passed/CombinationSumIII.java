package Passed;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	 public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(k > 9) {
	            return res;
	        }
	        List<Integer> list = new ArrayList<Integer>();
	        helper(n, k, 1, list, res);
	        
	        return res;
	    }
	    
	    void helper(int target, int k, int start, List<Integer> list, List<List<Integer>> res) {
	        if(target < 0 || list.size() > k) {
	            return;
	        }
	        
	        if(target == 0 && list.size() == k) {
	            if (!res.contains(list)) res.add(new ArrayList<Integer>(list));
	            return;
	        }
	        
	        for(int i = start; i <= 9; i++) {
	            list.add(i);
	            int newtarget = target - i;
	            helper(newtarget, k, i+1, list, res);
	            list.remove(list.size()-1);
	        }
	    }

}
