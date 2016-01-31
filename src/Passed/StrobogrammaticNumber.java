package Passed;

import java.util.HashMap;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        int left = 0;
        int right = num.length() - 1;
        while(left < right) {
            char l = num.charAt(left);
            char r = num.charAt(right);
            if(!map.containsKey(l) || map.get(l) != r) return false;
            left++;
            right--;
        }
        
        if(left == right) {
            char mid = num.charAt(left);
            if(mid == '1' || mid == '8' || mid == '0') {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
