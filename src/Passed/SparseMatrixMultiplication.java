package Passed;

public class SparseMatrixMultiplication {
	 public int[][] multiply(int[][] A, int[][] B) {
	        if(A == null || B == null) {
	            return null;
	        }
	        
	        int[][] res = new int[A.length][B[0].length];
	        if (A.length == 0 || B.length == 0) return res;
	        
	        for(int i = 0; i < A.length; i++) {
	            for(int j = 0; j < A[0].length; j++) {
	                if(A[i][j] != 0) {
	                    for(int k = 0; k < B[0].length; k++) {
	                        res[i][k] += A[i][j] * B[j][k];
	                    }
	                }
	            }
	        }
	        
	        return res;
	    }
}
