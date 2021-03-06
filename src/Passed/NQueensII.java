package Passed;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	  int count = 0;
	    
	    public int totalNQueens(int n) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        if (n <= 0) return 0;
	        search(n, res, new ArrayList<Integer>());
	        return count;
	    }
	    
	    private void search(int n, List<List<String>> res, List<Integer> cols) {
	        if (cols.size() == n) {
	            res.add(drawChessBoard(cols));
	            count++;
	        } 
	        
	        for(int i = 0; i < n; i++) {
	            if(!isValid(cols, i)) {
	                continue;
	            }
	            
	            cols.add(i);
	            search(n,res,cols);
	            cols.remove(cols.size() - 1);
	        }
	    }
	    
	    private boolean isValid(List<Integer> cols, int newcol) {
	        int row = cols.size();
	        
	        for(int i = 0; i < row; i++) {
	            // same col
	            if (cols.get(i) == newcol) return false;
	            
	            if (i - cols.get(i) == row - newcol) return false;
	            
	            if (i + cols.get(i) == row + newcol) return false;
	        }
	        
	        return true;
	    }
	    
	    private List<String> drawChessBoard(List<Integer> cols) {
	        List<String> res = new ArrayList<String>();
	        for(int i = 0; i < cols.size(); i++) {
	            String onerow = "";
	            for(int j = 0; j < cols.size(); j++) {
	                if (j != cols.get(i)) {
	                    onerow += ".";
	                } else {
	                    onerow += "Q";
	                }
	            }
	            res.add(new String(onerow));
	        }
	        return res;
	    }

}
