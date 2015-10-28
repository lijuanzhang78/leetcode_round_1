package Passed;

public class AddBinary {
	public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int maxLen = Math.max(lenA, lenB);
        int p, q, carry = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < maxLen; i++) {
            if(i >= lenA) {
                p = 0;
            } else {
                p = a.charAt(lenA-i-1) - '0';
            }
            
            if(i >=lenB) {
                q = 0;
            } else {
                q = b.charAt(lenB-i-1) - '0';
            }
            
            int digit = p + q + carry;
            carry = digit/2;
            digit %= 2;
            
            sb.insert(0, digit);
        }
        
        if(carry > 0) sb.insert(0,carry);
        
        return sb.toString();
    
    }

}
