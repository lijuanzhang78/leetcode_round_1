package Passed;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	 public int lengthOfLongestSubstring(String s) {
	        int maxCount = 0;
	        for (int i = 0; i < s.length(); i++) {
	            Map<Character, Integer> map = new HashMap<Character, Integer>();
	            int count = 0;
	            for (int j = i; j < s.length(); j++) {
	                if(!map.containsKey(s.charAt(j))) {
	                    map.put(s.charAt(j), 1);
	                    count++;
	                } else {
	                    break;
	                }
	            }
	            if(count > maxCount) maxCount = count;
	        
	        }
	        return maxCount;
	    }
}
