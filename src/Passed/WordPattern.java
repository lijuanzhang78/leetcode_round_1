package Passed;

import java.util.HashMap;

public class WordPattern {
	  public boolean wordPattern(String pattern, String str) {
	        if(pattern.isEmpty() || str.isEmpty()) {
	            return false;
	        }
	        
	        String[] s = str.split(" ");
	        if(s.length != pattern.length()) {
	            return false;
	        }
	        
	        HashMap<Character, String> hashmap = new HashMap<Character, String>();
	        for(int i = 0; i < pattern.length(); i++) {
	            if(!hashmap.containsKey(pattern.charAt(i))) {
	                if(hashmap.containsValue(s[i])) {
	                    return false;
	                } else {
	                    hashmap.put(pattern.charAt(i), s[i]);
	                }
	            }
	            else {
	                if(!hashmap.get(pattern.charAt(i)).equals(s[i])) {
	                    return false;
	                }
	            }
	        }
	        
	        return true;
	    }

}
