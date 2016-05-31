package Passed;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Map<Character, Integer>  map = new HashMap<>();
        int walker = 0;
        int runner = 0;
        int res = 0;
        
        while(runner < s.length()) {
            if (map.containsKey(s.charAt(runner))) {
                map.put(s.charAt(runner), map.get(s.charAt(runner))+1);
                runner++;
            } else if (map.size() < 2) {
                    map.put(s.charAt(runner), 1);
                    runner++;
              } else {
                    while (map.size() == 2) {
                        map.put(s.charAt(walker), map.get(s.charAt(walker)) - 1);
                        if (map.get(s.charAt(walker)) == 0) {
                            map.remove(s.charAt(walker));
                        } 
                        walker++;
                    }
               }
             res = Math.max(res, runner - walker);
        }
        return res;
    }

}
