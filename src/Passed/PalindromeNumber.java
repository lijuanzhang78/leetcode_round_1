package Passed;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        int maxN = getMaxDigits(x);
        
        int i = 0, j = maxN;
        while (i < j) {
            if(getIthDigit(i, x) != getIthDigit(j,x)) return false;
            i++;
            j--;
        } 
        return true;
    }  
        
    public int getMaxDigits (int x) {
        int count = 0;
        
        while (x/10 > 0) {
            x = x/10;
            count++;
        }
        return count;
        
    }
    
    public int getIthDigit (int i, int x) {
        while (i > 0) {
            x = x / 10;
            i--;
        }
        
        return x %= 10;
    }
}
