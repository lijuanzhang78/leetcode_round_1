package Passed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HouseRobber {
	public int rob(int[] nums) {
        int n = nums.length;
        if(nums == null || nums.length == 0) return 0;
        
        List<Integer> dp = new ArrayList<Integer>();
        dp.add(nums[0]);
        if(n >= 2) dp.add(1, Math.max(nums[0], nums[1]));
        
        for(int i = 2; i<n; i++) {
            int dpMax = Math.max(dp.get(i-2) + nums[i], dp.get(i-1));
            dp.add(i,dpMax);
        }
        
        return Collections.max(dp);
    
    }

}
