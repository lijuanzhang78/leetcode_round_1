package Passed;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> theHashTable = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (theHashTable.containsKey(nums[i])) {
                Integer val = theHashTable.get(nums[i]);
                if (i - val <= k) {
                    return true;
                }
            }
            theHashTable.put(nums[i],i);
        }
        
    return false;
        
    }
}
