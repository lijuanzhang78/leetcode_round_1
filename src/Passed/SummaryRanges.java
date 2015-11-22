package Passed;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	 public List<String> summaryRanges(int[] nums) {
	        List<String> res = new ArrayList<String> ();
	        int i = 0;
	        while (i < nums.length) {
	            int start = i;
	            while(i+1 < nums.length && nums[i+1] == nums[i] + 1) {
	                i++;
	            }
	            StringBuilder str = new StringBuilder();
	            str.append(nums[start]);
	            if(i > start) {
	                str.append("->");
	                str.append(nums[i]);
	            }
	            res.add(str.toString());
	            
	            i++;
	            
	        }
	        
	        return res;
	    }
}
