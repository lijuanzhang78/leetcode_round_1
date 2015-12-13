package Passed;

public class RotateImage {
	 public void rotate(int[][] matrix) {
	      int n = matrix.length;
	      
	      int maxlayer = n / 2;
	      int layer = n;
	      for (int i = 0; i < maxlayer; i++) {
	          for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
	              int temp = matrix[i][j];
	               matrix[i][j] = matrix[n-1-j][i];
	               matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
	               matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
	               matrix[j][n-1-i] = temp;
	          }
	      }
	      
	    }

}
