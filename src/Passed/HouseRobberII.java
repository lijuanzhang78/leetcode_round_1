package Passed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HouseRobberII {
	 public int rob(int[] nums) {
	        
	        int n = nums.length;
	        int max = 0;
	        if(nums == null || nums.length == 0) return 0;
	        
	        List<Integer> dp = new ArrayList<Integer>();
	        List<Integer> dr = new ArrayList<Integer>();
	        
	        dp.add(nums[0]);
	        if (n >= 2) dp.add(1, Math.max(nums[0], nums[1]));
	        
	        for(int i = 2; i<n-1; i++) {
	            int dpMax = Math.max(dp.get(i-2) + nums[i], dp.get(i-1));
	            dp.add(i,dpMax);
	        }
	        
	        dr.add(0);
	        if(n >=2 ) dr.add(1, nums[1]);
	        
	        for(int i = 2; i<n; i++) {
	            int drMax = Math.max(dr.get(i-2) + nums[i], dr.get(i-1));
	            dr.add(i,drMax);
	        }
	        

	        return Math.max(Collections.max(dp), Collections.max(dr));
	    
	        
	    }

}
