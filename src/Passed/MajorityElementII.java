package Passed;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	 public List<Integer> majorityElement(int[] nums) {
	        List<Integer> result = new ArrayList<Integer>();
	        if(nums == null || nums.length == 0) return result;
	        if(nums.length == 1) {
	            result.add(nums[0]);
	            return result;
	        }
	        
	        int m1 = nums[0];
	        int m2 = 0;
	        
	        int c1 = 1;
	        int c2 = 0;
	        
	        for(int i=1; i<nums.length; i++) {
	            int x = nums[i];
	            if(x == m1) ++c1;
	            else if(x == m2) ++c2;
	            else if(c1 == 0) {
	                m1 = x;
	                ++c1;
	            }
	            else if(c2 == 0) {
	                m2= x;
	                ++c2;
	            } else {
	                --c1;
	                --c2;
	            }
	        }
	        
	        c1 = 0; c2 = 0;
	        for(int i = 0; i < nums.length; i++) {
	            if(m1 == nums[i]) ++c1;
	            if(m2 == nums[i]) ++c2;
	        }
	        
	        if (c1 > nums.length/3) result.add(m1);
	        if (c2 > nums.length/3 && m1 != m2) result.add(m2);
	        
	        return result;
	    }
}
