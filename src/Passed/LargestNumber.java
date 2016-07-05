package Passed;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	class StringComparator implements Comparator<String> {
	    public int compare(String s1, String s2) {
	        return (s2+s1).compareTo(s1+s2);
	    }
	}

	public class Solution {
	    public String largestNumber(int[] nums) {
	        String[] str = new String[nums.length];
	        for(int i = 0; i < nums.length; i++) {
	            str[i] = Integer.toString(nums[i]);
	        }
	        
	        Arrays.sort(str, new StringComparator());
	        StringBuilder sb = new StringBuilder();
	        
	        for(int i = 0; i < str.length; i++) {
	            sb.append(str[i]);
	        }
	        String res = sb.toString();
	        if (res.charAt(0) == '0') return "0";
	        
	        return res;
	    }

}
