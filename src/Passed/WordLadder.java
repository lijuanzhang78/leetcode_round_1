package Passed;

public class WordLadder {
	 public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	        Queue<String> queue = new LinkedList<String>();
	        queue.offer(beginWord);
	        int length = 1;
	        wordList.remove(beginWord);
	        
	        while(!queue.isEmpty()) {
	            int count = queue.size();
	            for(int i = 0; i < count; i++) {
	                String curr = queue.poll();
	                for(char c = 'a'; c <= 'z'; c++) {
	                    for(int j = 0; j < curr.length(); j++) {
	                        if(curr.charAt(j) == c) {
	                            continue;
	                        }
	                        
	                        String tmp = replace(curr,j,c);
	                        if (tmp.equals(endWord)) return length + 1;
	                        
	                        if(wordList.contains(tmp)) {
	                            queue.offer(tmp);
	                            wordList.remove(tmp);
	                        }
	                    }
	                }
	            }
	            length++;
	        }
	        return 0;
	    }
	    
	    private String replace(String s, int index, char c) {
	        char[] chars = s.toCharArray();
	        chars[index] = c;
	        return new String(chars);
	    }
}
