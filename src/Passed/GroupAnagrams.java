package Passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	  public List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> res = new ArrayList<List<String>> ();
	        HashMap<String, List<String>> map = new HashMap<String, List<String>> (); 
	        
	        Arrays.sort(strs);
	        for(String str : strs) {
	            char[] strarr = str.toCharArray();
	            Arrays.sort(strarr);
	            String sortStr = new String(strarr);
	            if(map.containsKey(sortStr)) {
	                map.get(sortStr).add(str);
	            } else {
	                List<String> newStrList = new ArrayList<String> ();
	                newStrList.add(str);
	                map.put(sortStr, newStrList);
	            }
	        }
	        
	        for(List<String> list : map.values()) {
	            res.add(list);
	        }
	        
	        return res;
	        }
}
