package Passed;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0, end = m*n - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            int p = mid / n;
            int q = mid % n;
            if(matrix[p][q] > target) {
                end = mid - 1;
            } else if(matrix[p][q] < target){
                start = mid + 1;
            } else {
                return true;
            }
        }
            
        if (matrix[start/n][start%n] == target) {
                return true;
        } else {
                return false;
        }

    }

}
