package Passed;

public class IntegerToEnglishWords {
	  public String numberToWords(int num) {
	        String[] units = {"", "Thousand", "Million", "Billion"};
	        String res = "";
	        
	        if (num == 0) return "Zero";
	        int i = 0;
	        while(num > 0) {
	            int temp = num % 1000;
	            if (temp > 0) {
	                res = convert(temp) + " " + units[i]  + res;
	            }
	            num /= 1000;
	            i++;
	        }
	        
	        return res.trim();
	    }
	    
	    public String convert (int num) {
	        String result = "";
	        String[] ten = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	        String[] twenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	        String[] hundred = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	        
	        if(num / 100 > 0) result += " " + ten[num/100] + " " + "Hundred";
	        if(num / 10 > 0) {
	            int secondDigit = (num/10) % 10;
	            if (secondDigit > 1) {
	                result += " " + hundred[secondDigit - 1];
	                int thirdDigit = num % 10;
	                if (thirdDigit > 0) result += " " + ten[thirdDigit] ;
	                return result;
	            } else if (secondDigit == 1) {
	                int thirdDigit = num % 10;
	                result += " " + twenty[thirdDigit];
	                return result;
	            } else {
	                int thirdDigit = num % 10;
	                if(thirdDigit > 0) return result += " " + ten[thirdDigit];
	                return result;
	            }
	        
	        }
	        if(num % 10 > 0) {
	            result += " " + ten[num % 10];
	        }
	        
	        return result;
	    }

}
