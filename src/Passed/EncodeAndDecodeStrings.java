package Passed;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
	  // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(String s : strs) {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        
        while(i < s.length()) {
            int sharp = s.indexOf('#', i);
            int l = Integer.parseInt(s.substring(i,sharp));
            res.add(s.substring(sharp + 1, sharp + l + 1));
            i = sharp + l + 1;
        }
        return res;
    }

}
