package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        
        if(s == null || s.length() == 0) {
            return res;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if(!palindromeExists(s,map)) return res;
        
        StringBuilder sb = new StringBuilder();
        Set<Character> keys = map.keySet();
        char middle = '\0';
        for(Character ch : keys) {
            int num = map.get(ch);
            for(int i=0; i<num/2; i++) {
                sb.append(ch);
            }
            if(num % 2 == 1) middle = ch;            
        }
        
        String half = sb.toString();
        List<Character> list = new ArrayList<Character>();
        
        boolean[] visited = new boolean[half.length()];
        for(int i=0; i<half.length(); i++) {
            visited[i] = false;
        }
        
        helper(list, res, visited, half, middle);
        return res;
    }
    
    public void helper(List<Character> list, List<String> res, boolean[] visited, String half, char middle) {
        if(list.size() == half.length()) {
            StringBuilder sb = new StringBuilder();
            for(char ch : list) {
                sb.append(ch);
            }
            if(middle != '\0') sb.append(middle);
            for(int i=list.size()-1; i>=0; i--) {
                sb.append(list.get(i));
            }
            res.add(sb.toString());
            return;
        }
        
        for(int i=0; i<half.length(); i++) {
            if(i>0 && half.charAt(i) == half.charAt(i-1) && !visited[i-1]) {
                continue;
            }
            
            if(!visited[i]) {
                list.add(half.charAt(i));
                visited[i] = true;
                helper(list,res,visited,half,middle);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

    public boolean palindromeExists(String s, HashMap<Character, Integer> map) {
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        
        Set<Character> keys = map.keySet();
        int numSingle = 0;
        for(Character ch : keys) {
            if(map.get(ch) % 2 == 1) {
                numSingle++;
            } 
        }
        
        if(numSingle > 1) return false;
        return true;
    }
    
    public static void main(String[] args) {
    	List<String> res = new PalindromePermutationII().generatePalindromes("aabb");
    	return; 	
    }

}
