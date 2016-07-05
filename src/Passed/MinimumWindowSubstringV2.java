package Passed;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringV2 {
	public String minWindow(String s, String t) {
        String res = "";
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return res;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        
        int count = 0;
        int pre = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) >= 0) {
                    count++;
                }
            }
                
            while (count == t.length()) {
                if (map.containsKey(s.charAt(pre))) {
                    map.put(s.charAt(pre), map.get(s.charAt(pre)) + 1);
                    if (map.get(s.charAt(pre)) > 0) {
                        if (minLen > i - pre + 1) {
                            minLen = i - pre + 1;
                            res = s.substring(pre, i+1);
                        }
                        count --;
                    }
                }
                pre++;
            }
        }
        
        return res;
    }

}
