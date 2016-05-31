package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	 public int[] intersect(int[] nums1, int[] nums2) {
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        List<Integer> result = new ArrayList<Integer>();
	        
	        for(int i = 0; i < nums1.length; i++) {
	            if(map.containsKey(nums1[i])) {
	                map.put(nums1[i], map.get(nums1[i]) + 1);
	            } else {
	                map.put(nums1[i], 1);
	            }
	        }
	        
	        for(int i = 0; i < nums2.length; i++) {
	            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
	                map.put(nums2[i], map.get(nums2[i]) - 1);
	                result.add(nums2[i]);
	            }
	        }
	        
	        int[] res = new int[result.size()];
	        int i = 0;
	        for(int num : result) {
	            res[i] = num;
	            i++;
	        }
	        return res;
	    }
}
