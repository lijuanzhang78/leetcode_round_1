package Passed;

public class StrobogrammaticNumbersIII {
	 int count = 0;
	    char[][] pair = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
	    
	    public int strobogrammaticInRange(String low, String high) {
	        for(int len = low.length(); len <= high.length(); len++) {
	            dfs(low, high, new char[len], 0, len-1);
	        }
	        return count;
	    }
	    
	    public void dfs(String low, String high, char[] c, int l, int r) {
	        if (l > r) {
	            String s = new String(c);
	            if (s.length() == low.length() && s.compareTo(low) < 0 ||
	                s.length() == high.length() && s.compareTo(high) > 0) return;
	            count++;
	            return;
	        }
	        
	        for(char[] p : pair) {
	            c[l] = p[0];
	            c[r] = p[1];
	            if (c.length != 1 && c[0] == '0') continue;
	            if (l < r || l == r && p[0] == p[1]) dfs(low, high, c, l+1, r-1);
	        }
	    }
}
