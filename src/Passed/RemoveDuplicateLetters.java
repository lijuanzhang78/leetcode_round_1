package Passed;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
	 public String removeDuplicateLetters(String s) {
	        int[] freq = new int[256];
	        for(int i = 0; i < s.length(); i++) {
	            freq[s.charAt(i)]++;
	        }
	        
	        boolean visited[] = new boolean[256];
//	      why stack not right here?
	        Deque<Character> q = new ArrayDeque<>();
	        
	        for(int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            freq[c]--;
	            if(visited[c]) continue;
	            
	            while(!q.isEmpty() && q.peek() > c && freq[q.peek()] > 0) {
	                visited[q.pop()] = false;
	            }
	            q.push(c);
	            visited[c] = true;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(char c : q) {
	            sb.append(c);
	        }
	        
	        return sb.reverse().toString();
	    }
}
