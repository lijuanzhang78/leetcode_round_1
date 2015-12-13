package Passed;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);
	    
	    int length = s.length();
	    int result = map.get(s.charAt(length - 1));
	    
	    for (int i = length - 2; i >= 0; i-- ) {
	        if (map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
	            result += map.get(s.charAt(i));
	        } else {
	            result -= map.get(s.charAt(i));
	        }
	    }
	    
	    return result;
    }

}
