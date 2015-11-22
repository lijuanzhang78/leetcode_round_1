package Passed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BullsAndCows {
	public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return "0A0B";
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> bullsMap = new HashMap<Character, Integer>();
        Map<Character, Integer> cowsMap = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) ++bulls;
            else {
                addToMap(secret.charAt(i), bullsMap);
                addToMap(guess.charAt(i), cowsMap);
            }
        }
        Iterator<Map.Entry<Character, Integer>> it = cowsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> es = it.next();
            char c = es.getKey();
            int occur = es.getValue();
            cows += getOccurance(c, occur, bullsMap);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append('A');
        sb.append(cows);
        sb.append('B');
        return sb.toString();
    }
    
    private void addToMap(char c, Map<Character, Integer> map) {
        if (map.containsKey(c)) {
            map.put(c, map.remove(c) + 1);
        } else {
            map.put(c, 1);
        }
    }
    
    private int getOccurance(char c, int occur, Map<Character, Integer> map) {
        if (map.containsKey(c)) {
            return Math.min(occur, map.get(c));
        } else {
            return 0;
        }
    }

}
