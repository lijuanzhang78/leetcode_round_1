package Passed;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
	 public List<String> letterCombinations(String digits) {
	        String[] dic = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        if(digits == null || digits.length() == 0) {
	            return new ArrayList<String>();
	        }

	        ArrayList<String> ret = new ArrayList<String>();
	        StringBuilder temp = new StringBuilder();
	        dfs(digits, dic, 0, temp, ret);
	        return ret;
	    }
	    
	    public void dfs(String digits, String[] dic, int deep, StringBuilder temp, ArrayList<String> ret) {
	        if (deep == digits.length()) {
	            ret.add(temp.toString());
	            return;
	        } else {
	            for (int i = 0; i < dic[digits.charAt(deep) - '0'].length(); i++) {
	                temp.append(dic[digits.charAt(deep) - '0'].charAt(i));
	                dfs(digits,dic,deep+1,temp,ret);
	                temp.deleteCharAt(temp.length() - 1);
	            }
	        }
	    }
}
