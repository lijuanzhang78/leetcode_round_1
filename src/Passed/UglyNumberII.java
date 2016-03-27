package Passed;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
	 public int nthUglyNumber(int n) {
	        if (n < 1) return 0;
	        int a2 = 0, a3= 0, a5 = 0;
	        List<Integer> list = new ArrayList<Integer>();
	        list.add(1);
	        int count = 1, nextVal = 1;
	        while(list.size() < n) {
	            nextVal = Math.min(list.get(a2)*2, Math.min(list.get(a3)*3, list.get(a5)*5));
	            if(nextVal == list.get(a2)*2) a2++;
	            if(nextVal == list.get(a3)*3) a3++;
	            if(nextVal == list.get(a5)*5) a5++;
	            list.add(nextVal);
	        }
	        
	        return list.get(list.size()-1);
	    }
}
