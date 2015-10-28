package Passed;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	 public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer> ();
	        int[] indices = new int[2];
	        for(int i = 0; i < nums.length; i++) {
	            hashmap.put(nums[i], i);
	        }
	        
	        for(int i = 0; i < nums.length; i++) {
	            int other = target - nums[i];
	            if (hashmap.containsKey(other)) {
	                if(hashmap.get(other) != i) {
	                    indices[1] = hashmap.get(other) + 1;
	                    indices[0] = i + 1;
	                    return indices;
	                }
	            }
	        }
	        return indices;
	    }

}
