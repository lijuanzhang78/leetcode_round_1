package Passed;

public class ExcelSheetColumeNumber {
	 public int titleToNumber(String s) {
	        if(s == null || s.length() == 0) return 0;
	        int result = 0;
	        int n = s.length();
	        
	        for(int i = 0; i < n; i++) {
	            char ch = s.charAt(i);
	            result = result * 26 + ch - 'A' + 1;
	        }
	        
	        return result;
	    }
}
