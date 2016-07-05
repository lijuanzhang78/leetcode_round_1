package Passed;

import java.util.TreeSet;

public class ContainsDuplicatesIII {
	 public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	        TreeSet<Long> set = new TreeSet<>();
	        for (int i = 0; i < nums.length; i++) {
	            long n = (long)nums[i];
	            if (set.floor(n) != null && n - set.floor(n) <= t ||
	                set.ceiling(n) != null && set.ceiling(n) - n <= t) {
	                return true;
	            }
	            set.add(n);
	            if (i >= k) {
	                set.remove((long)nums[i - k]);
	            }
	        }
	        return false;
	    }
}
