package Passed;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }
        
        Set<Character> keys = map.keySet();
        int numSingle = 0;
        for(Character ch : keys) {
            if(map.get(ch) % 2 == 0) {
                continue;
            } else {
                numSingle++;
                
            }
        }
        
        return numSingle <= 1;
    }
}
