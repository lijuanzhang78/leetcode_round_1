package Passed;

public class AddAndSearchWord {
	public class WordDictionary {
	    class TrieNode {
	        public TrieNode[] children;
	        boolean hasWord;
	        public TrieNode() {
	            children = new TrieNode[26];
	            hasWord = false;
	        }
	    }
	    
	    private TrieNode root;
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        TrieNode p = root;
	        for(char c:word.toCharArray()) {
	            if(p.children[c-'a'] == null) p.children[c-'a'] = new TrieNode();
	            p = p.children[c-'a'];
	        }
	        p.hasWord = true;
	    }
	    
	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        return helper(word, 0, root);
	    }
	    
	    private boolean helper(String word, int index, TrieNode p) {
	        if (index == word.length()) {
	            return p.hasWord;
	        }
	        
	        char c = word.charAt(index);
	        if (c == '.') {
	            for (int i = 0; i < p.children.length; i++) {
	                if (p.children[i] != null && helper(word, index+1,p.children[i])) {
	                    return true;
	                }
	            }
	            return false;
	        } else {
	            return p.children[c - 'a'] != null && helper(word, index + 1, p.children[c-'a']);
	        }
	    }
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");

}
