package Passed;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {
	 Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	    // Add the number to an internal data structure.
		public void add(int number) {
		    if (map.containsKey(number)) {
		        map.put(number, map.get(number) + 1);
		    } else {
		        map.put(number,1);
		    }
		}

	    // Find if there exists any pair of numbers which sum is equal to the value.
		public boolean find(int value) {
		    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
		        int i = entry.getKey();
		        int j = value - i;
		        if (j == i && map.get(i) > 1 || j != i && map.containsKey(j)) {
		            return true;
		        }
		    }
		    return false;
		}
}
