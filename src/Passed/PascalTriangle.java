package Passed;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	 public List<List<Integer>> generate(int numRows) {
	        int temp = 0;
	        
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> firstList = new ArrayList<Integer>();
	        
	        if(numRows >= 1) {
	          firstList.add(1);
	          res.add(firstList);
	        }
	        
	        for (int i = 1; i < numRows; i++) {
	            List<Integer> pre = res.get(i - 1);
	            List<Integer> curr = new ArrayList<Integer>();
	            for(int j = 0; j < pre.size() + 1; j++) {
	                if(j == 0) {
	                    temp = pre.get(j);
	                } else {
	                    if(j == pre.size()) {
	                        temp = pre.get(j-1);
	                    } else {
	                        temp = pre.get(j) + pre.get(j-1);
	                    }
	                } 
	                curr.add(temp);
	            }
	            res.add(curr);
	            pre = curr;
	        }
	        return res;
	    }
}
