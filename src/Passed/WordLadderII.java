package Passed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	 public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
	        List<List<String>> ladders = new ArrayList<List<String>>();
	        Map<String, List<String>> map = new HashMap<String, List<String>>();
	        Map<String, Integer> distance = new HashMap<String, Integer>();

	        wordList.add(beginWord);
	        wordList.add(endWord);
	 
	        bfs(map, distance, beginWord, endWord, wordList);
	        
	        List<String> path = new ArrayList<String>();
	        
	        dfs(ladders, path, endWord, beginWord, distance, map);

	        return ladders;
	    }

	    void dfs(List<List<String>> ladders, List<String> path, String crt,
	            String start, Map<String, Integer> distance,
	            Map<String, List<String>> map) {
	        path.add(crt);
	        if (crt.equals(start)) {
	            Collections.reverse(path);
	            ladders.add(new ArrayList<String>(path));
	            Collections.reverse(path);
	        } else {
	            for (String next : map.get(crt)) {
	                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
	                    dfs(ladders, path, next, start, distance, map);
	                }
	            }           
	        }
	        path.remove(path.size() - 1);
	    }

	    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
	            String start, String end, Set<String> dict) {
	        boolean foundEnd = false;
	        Queue<String> q = new LinkedList<String>();
	        q.offer(start);
	        distance.put(start, 0);
	        for (String s : dict) {
	            map.put(s, new ArrayList<String>());
	        }
	        
	        while (!q.isEmpty()) {
	            int count = q.size();
	            for(int i = 0; i < count; i++) {
	                String crt = q.poll();
	                List<String> nextList = expand(crt, dict);
	                for (String next : nextList) {
	                    map.get(next).add(crt);
	                
	                    if (!distance.containsKey(next)) {
	                        distance.put(next, distance.get(crt) + 1);
	                        if (next.equals(end)) {
	                            foundEnd = true;
	                        } else {
	                            q.offer(next);
	                        }
	                    }
	                }
	            } 
	            if (foundEnd) break;
	        }
	    }

	    List<String> expand(String crt, Set<String> dict) {
	        List<String> expansion = new ArrayList<String>();

	        for (int i = 0; i < crt.length(); i++) {
	            for (char ch = 'a'; ch <= 'z'; ch++) {
	                if (ch != crt.charAt(i)) {
	                    String expanded = crt.substring(0, i) + ch
	                            + crt.substring(i + 1);
	                    if (dict.contains(expanded)) {
	                        expansion.add(expanded);
	                    }
	                }
	            }
	        }

	        return expansion;
	   }
	     
	   public static void main(String[] args) {
		   Set<String> wordList = new HashSet<String>();
		   wordList.add("hot");
		   wordList.add("dot");
		   wordList.add("dog");
		   wordList.add("lot");
		   wordList.add("log");
		   
		   String beginWord = "hit";
		   String endWord = "cog";
		   
		   List<List<String>> res = new WordLadderII().findLadders(beginWord, endWord, wordList);
		      
	   }
}
