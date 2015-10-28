package Passed;

public class AddDigits {
	 public int addDigits(int num) {
	        int newnum = num;
	        while (newnum /10 != 0) {
	            newnum = getsum (newnum);
	        }
	            
	        return newnum;   
	        }
	        
	    public int getsum (int num) {
	        int sum = 0;
	        while (num != 0) {
	            sum += num % 10;
	            num /= 10;
	        }
	        return sum;

	    }
}
