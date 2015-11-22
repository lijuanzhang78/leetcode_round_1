package Passed;

public class implementstrStr {
	public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean isfirstOcurr = true;
            for(int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    isfirstOcurr = false;
                    break;
                }
            }
            
            if(isfirstOcurr) return i;
        }
        
        return -1;
    }

}
