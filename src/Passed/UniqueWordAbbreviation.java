package Passed;

import java.util.HashMap;

public class UniqueWordAbbreviation {
	  HashMap<String, String> map; 
	    public void ValidWordAbbr(String[] dictionary) {
	        map = new HashMap<String, String>();
	        for(String str : dictionary) {
	            String key = getKey(str);
	            if (map.containsKey(key) && !map.get(key).equals(str)) {
	                map.put(key, "");
	            } else {
	                map.put(key, str);
	            }
	        }
	    }

	    public boolean isUnique(String word) {
	        String key = getKey(word);
	        return !map.containsKey(key) || map.get(key).equals(word);
	    }
	    
	    private String getKey(String str) {
	        if (str.length() <= 2) return str;
	        return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
	    }
}
