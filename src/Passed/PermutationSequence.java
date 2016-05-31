package Passed;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	 public static int count = 0;
	    public String getPermutation(int n, int k) {
	        String res = "";
	        List<Integer> list = new ArrayList<Integer>();
	        helper(n, k, list);
	        for(Integer i : list) {
	            res += i;
	        }
	        return res;
	    }
	    
	    void helper(int n, int k, List<Integer> list) {
	        if (list.size() == n) {
	            if (count < k) count++;
	            return;
	        }
	        
	        for(int i = 1; i <= n; i++) {
	            if (!list.contains(i)) {
	                list.add(i);
	                helper(n,k,list);
	                if (count == k) break;
	                list.remove(list.size() - 1);
	            }
	        }
	        
	        return;
	    }
	    
	    public static void main(String[] args) {
	    	String res = new PermutationSequence().getPermutation(3, 4);
	    	System.out.println(res);
	    }
}
