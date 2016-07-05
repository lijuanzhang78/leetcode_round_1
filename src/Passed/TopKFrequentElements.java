package Passed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	 Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
	        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
	            return o2.getValue() - o1.getValue();
	        }
	    };
	    
	    public List<Integer> topKFrequent(int[] nums, int k) {
	        List<Integer> res = new ArrayList<Integer>();
	        if (nums == null || nums.length == 0) return null;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int num : nums) {
	            if (map.containsKey(num)) {
	                map.put(num, map.get(num) + 1);
	            } else {
	                map.put(num, 1);
	            }
	        }
	        
	        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comp);
	        pq.addAll(map.entrySet());
	        
	        for(int i = 0; i < k; i++) {
	            res.add(pq.poll().getKey());
	        }
	        
	        return res;
	    }
}
