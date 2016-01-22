package Passed;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> m = new ArrayList<Integer>(); 
        List<Integer> n = new ArrayList<Integer>();
        
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(word1)) {
                m.add(i);
            }
            if(words[i].equals(word2)) {
                n.add(i);
            }
        }
        
        int minLen = Integer.MAX_VALUE;
        for(int m1 : m) {
            for(int n1 : n) {
                if(word1.equals(word2) && m1 == n1) continue;
                minLen = Math.min(minLen, Math.abs(m1-n1));
            }
        }
        
        return minLen;        
    }

}
