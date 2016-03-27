package Passed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
	 public boolean wordPatternMatch(String pattern, String str) {
	        Map<Character, String> map = new HashMap<Character, String>();
	        Set<String> set = new HashSet<String>();
	        
	        return isMatch(str, 0, pattern, 0, map, set);
	    }
	    
	    boolean isMatch(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
	        if(i == str.length() && j == pattern.length()) return true;
	        if(i == str.length() || j == pattern.length()) return false;
	        
	        char c = pattern.charAt(j);
	        
	        if (map.containsKey(c)) {
	            String s = map.get(c);
	            if(!str.startsWith(s,i)) { return false; }
	            return isMatch(str, i+s.length(), pattern, j+1, map,set);
	        }
	        
	        for(int k = i; k < str.length(); k++) {
	            String p = str.substring(i,k+1);
	            if(set.contains(p)) continue;
	            map.put(c,p);
	            set.add(p);
	            
	            if(isMatch(str, k+1, pattern, j+1, map, set)) {
	                return true;
	            }
	            
	            map.remove(c);
	            set.remove(p);
	        }
	        return false;
	    }
}
