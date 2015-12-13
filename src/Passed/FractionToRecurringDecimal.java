package Passed;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	 public String fractionToDecimal(int numerator, int denominator) {
	        if (numerator == 0) {
	            return "0";
	        }
	        if (denominator == 0) {
	            return "";
	        }
	        
	        String ans = "";
	        if(numerator < 0 ^ denominator < 0) {
	            ans += "-";
	        }
	        long num = numerator, den = denominator;
	        num = Math.abs(num);
	        den = Math.abs(den);
	        
	        long res = num / den;
	        ans += res;
	        if(num % den == 0) return ans;
	        
	        
	        Map<Long, Integer> map = new HashMap<Long, Integer> ();
	        if(num % den > 0) {
	            ans += '.';
	        }
	        long rem = (long) num % den * 10;
	        
	        while (rem != 0) {
	            if(map.containsKey(rem)) {
	                int begin = map.get(rem);
	                String part1 = ans.substring(0, begin);
	                String part2 = ans.substring(begin, ans.length());
	                ans = part1 + "(" + part2 + ")";
	                return ans;
	            }
	            
	            map.put(rem, ans.length());
	            ans += rem / den;
	            rem = (rem % den) * 10;
	        }
	        
	        return ans;
	    }
	

}
