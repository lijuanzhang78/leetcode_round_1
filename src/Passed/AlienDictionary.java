package Passed;

import java.util.Arrays;

public class AlienDictionary {
private final int N = 26;
    
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {
                if(!dfs(visited, adj, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }
    
    public boolean dfs(int[] visited, boolean[][] adj, StringBuilder sb, int i) {
        visited[i] = 1;
        
        for(int j = 0; j < N; j++) {
            if (adj[i][j]) {
                if(visited[j] == 1) return false;
                if(visited[j] == 0) {
                    if(!dfs(visited, adj, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;
        sb.append((char)(i+'a'));
        return true;
    }
    
    
    void buildGraph(String[] words, boolean[][] adj, int[] visited) {
    	// usage: Array.fill
        Arrays.fill(visited, -1);
        
        for(int i = 0; i < words.length; i++) {
        	// usage: toCharArray()
            for(char c : words[i].toCharArray()) visited[c-'a'] = 0;
            if (i > 0) {
                String w1 = words[i-1];
                String w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    
                    if(c1 != c2) {
                        adj[c1-'a'][c2-'a'] = true;
                        break;
                    }
                }
            }
        }
    }

}
