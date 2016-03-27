package Passed;

import java.util.Stack;

public class MaximumRectangle {
	 public int maximalRectangle(char[][] matrix) {
	        if (matrix == null || matrix.length == 0) return 0;
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int[][] heights = new int[m][n];
	        int maxRec = 0;
	        
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (i == 0) heights[i][j] = (matrix[i][j] == '1')? 1 : 0;
	                else 
	                    heights[i][j] += (matrix[i][j] == '1')? heights[i-1][j] + 1 : 0;
	            }
	            
	            maxRec = Math.max(maxRec,largestRectangleArea(heights[i]));
	        }
	        return maxRec;
	    }
	    
	     public int largestRectangleArea(int[] heights) {
	        if (heights == null || heights.length == 0) return 0;
	        
	        Stack<Integer> stack = new Stack<Integer>();
	        int max = 0;
	        
	        for (int i = 0; i <= heights.length; i++) {
	            int curr = (i == heights.length)? -1 : heights[i];
	            while(!stack.isEmpty() && curr <= heights[stack.peek()]) {
	                int h = heights[stack.pop()];
	                int w = stack.empty()? i : i - stack.peek() - 1;
	                max = Math.max(h*w, max);
	            }
	            stack.push(i);
	        }
	        return max;
	    }

}
