package Passed;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
	 public List<List<Integer>> getFactors(int n) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(n<=1) {
	            return res;
	        }
	        
	        List<Integer> fac = new ArrayList<Integer>();
	        List<Integer> list = new ArrayList<Integer>();
	        
	        for(int i = 2; i <= n/2; i++) {
	            if(n % i == 0) {
	                fac.add(i);
	            }
	        }
	        
	        helper(fac,list,0,res,n);
	        return res;
	    }
	    
	    
	    
	    private void helper(List<Integer> fac, List<Integer> list, int start, List<List<Integer>> res, int target) {
	        if(target == 1) {
	            res.add(new ArrayList<Integer> (list));
	            return;
	        }
	        
	        for(int i=start; i<fac.size(); i++) {
	            if(target % fac.get(i) == 0) {
	                list.add(fac.get(i));
	                int newTarget = target/fac.get(i);
	                helper(fac,list,i,res,newTarget);
	                list.remove(list.size()-1);
	            } else {
	                continue;
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	    	List<List<Integer>> res = new ArrayList<List<Integer>>();
	    	res = new FactorCombinations().getFactors(6);	    	
	    }    
}
