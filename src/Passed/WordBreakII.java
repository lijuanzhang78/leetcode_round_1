package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	 public List<String> wordBreak(String s, Set<String> wordDict) {
	        if (!isPossible(s, wordDict)) return new ArrayList<String>();
	        
	        int len = s.length();
	        HashMap<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
	        List<String> base = new ArrayList<>();
	        base.add("");
	        dp.put(0, base);
	        
	        for(int i = 1; i <= len; i++) {
	            List<String> cur = new ArrayList<String>();
	            dp.put(i, cur);
	            for(int j = 0; j <= i; j++) {
	                if (dp.get(j).size() > 0 && wordDict.contains(s.substring(j,i))) {
	                    for(String str : dp.get(j)) {
	                        dp.get(i).add(str + (str.length()==0? "":" ") + s.substring(j,i));
	                    }
	                }
	            }
	        }
	        
	        return dp.get(len);
	}

	    private boolean isPossible(String s, Set<String> wordDict) {
	        int len = s.length();
	        boolean[] dp = new boolean[len + 1];
	        dp[0] = true;
	        
	        for(int i = 1; i <= len; i++) {
	            for(int j = 0; j <= i; j++) {
	                dp[i] = dp[j] && wordDict.contains(s.substring(j,i));
	                if (dp[i]) break;
	            }
	        }
	        return dp[len];
	    }

}
