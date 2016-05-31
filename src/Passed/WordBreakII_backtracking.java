package Passed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII_backtracking {
	public List<String> wordBreak(String s, Set<String> dict) {
	    if(!isPossible(s, dict)) return new LinkedList<String>();
	    List<String> res = new LinkedList<String>();
	    StringBuilder sb = new StringBuilder();
	    wbreak(0, sb, s, dict, res); // break from s index
	    return res;
	}
	 
	void wbreak(int start, StringBuilder sb, String s, Set<String> dict, List<String> res) {
		System.out.println("Begin, start = " + start);
	    if( start==s.length() ) {
	        res.add(sb.toString());
	        return;
	    }
	    for(int end=start; end<s.length(); end++) {   // 0...len-1, must not have -1, have len-1
	        String sub = s.substring(start, end+1);
	        if( dict.contains(sub) ) {
	            int appLen = sub.length();
	         if(sb.length()!=0) {
	             sb.append(" ");
	             appLen++;
	         }
	            sb.append(sub);
	            wbreak(end+1, sb, s, dict, res);
	            sb.delete(sb.length()-appLen, sb.length());
	        }
	    }
	    System.out.println("End, start = " + start);
	    return;
	}
	
	public boolean isPossible(String s, Set<String> dict) { // exactly same code of with WB I
	    int len = s.length();
	    boolean[] isSub = new boolean[len+1];
	    isSub[0] = true;    // empty str is substring
	    for(int i=0; i<len; i++) {
	        for(int j=0; j<=i; j++) {
	            isSub[i+1] = isSub[j] && dict.contains(s.substring(j,i+1));
	            if( isSub[i+1] ) {
	                break;  // break from inner for loop
	            }
	        }
	    }
	    return isSub[len];  // return last member
	     
	}
	
	public static void main(String[] args) {
		List<String> res = new ArrayList<String>();
		String s = "catsanddog";
		Set<String> set = new HashSet<String>();
		String[] str = {"cat", "cats", "and", "sand", "dog"};
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		
		res = new WordBreakII_backtracking().wordBreak(s, set);
		return;
		
	}

}
