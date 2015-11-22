package Passed;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareVersionNumbers {
	 public int compareVersion(String version1, String version2) {
	        String[] arr1 = version1.split("\\.");
	        String[] arr2 = version2.split("\\.");
	        
	        List<String> list1 = new ArrayList<String>(Arrays.asList(arr1));
	        List<String> list2 = new ArrayList<String>(Arrays.asList(arr2));
	        
	        int maxLen = Math.max(arr1.length, arr2.length);
	        for(int i = 0; i < maxLen; ++i) {
	            if(i >= arr1.length) {
	                list1.add(i, "0");
	            }
	            if(i >= arr2.length) {
	                list2.add(i, "0");
	            }
	        }
	        
	        for (int i = 0; i < maxLen; i++) {
	            if (Integer.parseInt(list1.get(i)) > Integer.parseInt(list2.get(i))) {
	                return 1;
	            } else if (Integer.parseInt(list1.get(i)) < Integer.parseInt(list2.get(i))) {
	                return -1;
	            } else {
	                continue;
	            }
	        }
	        
	        return 0;
	    }

}
