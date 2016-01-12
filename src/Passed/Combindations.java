package Passed;

import java.util.ArrayList;
import java.util.List;

public class Combindations {
	 public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(n <= 0 || n < k) {
	            return res;
	        }
	        
	        List<Integer> list = new ArrayList<Integer>();
	        
	        helper(n,k,1,list,res);
	        
	        return res;
	    }
	    
	    void helper(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
	        if(list.size() == k) {
	            res.add(new ArrayList<Integer> (list));
	            return;
	        }
	        
	        for(int i = start; i <= n; i++) {
	            list.add(i);
	            helper(n,k,i+1,list,res);
	            list.remove(list.size() - 1);
	        }
	    }
}
