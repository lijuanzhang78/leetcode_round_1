package Passed;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
	       s = s.toLowerCase();
	       int i = 0, j = s.length() - 1;
	       char left, right;
	       
	       while (i < j) {
	           while (!isValid (s.charAt(i))) {
	               i++;
	               if (i > s.length() -1) return true;
	           }
	           while (!isValid (s.charAt(j))) {
	               j--;
	               if (i > s.length() -1) return true;
	           }
	           
	           left = s.charAt(i);
	           right = s.charAt(j);
	           
	           if(left != right) return false;
	           i++;
	           j--;
	        }
	        return true;
	       }
	       
	       public boolean isValid (char test) {
	           if(test >= '0' && test <= '9') return true;
	           if(test >= 'a' && test <= 'z') return true;
	           return false;
	       }
}
