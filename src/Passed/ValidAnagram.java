package Passed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> hashmapS = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            if(!hashmapS.containsKey(s.charAt(i))) {
                hashmapS.put(s.charAt(i), 1);
            }
            else {
                hashmapS.put(s.charAt(i), hashmapS.get(s.charAt(i)) + 1);
            }
        }
            
        for(int i = 0; i < t.length(); i++) {
            if (!hashmapS.containsKey(t.charAt(i))) {
                return false;
            } 
            else {
                hashmapS.put(t.charAt(i), hashmapS.get(t.charAt(i)) -1);

            }
                
        }
        Iterator<Map.Entry<Character, Integer>> it = hashmapS.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() != 0) return false;
        }
        
        return true;
        
    }
}
