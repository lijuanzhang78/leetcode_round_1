package Passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Arrays.sort(nums);
        
        ArrayList<Integer> init = new ArrayList<>();
        init.add(nums[0]);
        map.put(0, new ArrayList<Integer>(init));
        
        
        for(int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            ArrayList<Integer> ilist = new ArrayList<Integer>();
            ilist.add(nums[i]);
            map.put(i, ilist);
            
            for(int j = 0; j < i; j++) {
                List<Integer> list = map.get(j);
                if (nums[i] % list.get(list.size() - 1) == 0) {
                    if (max < list.size() + 1) {
                        max = list.size() + 1;
                        ArrayList<Integer> temp = new ArrayList<Integer> (list);
                        temp.add(nums[i]);
                        map.put(i, temp);
                    }
                }
            }
        }
        
        int maxlen = Integer.MIN_VALUE; 
        int maxi = -1;
        for(int i = 0; i < nums.length; i++) {
            if (map.get(i).size() > maxlen) {
                maxlen = map.get(i).size();
                maxi = i;
            }
        }        
                
        return map.get(maxi);        
    }

}
