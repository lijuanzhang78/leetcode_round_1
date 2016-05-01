package Passed;

import java.util.HashSet;
import java.util.Set;

public class ValidSoduko {
	public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(!isParticallyValid(board, i, i, 0, 8)) return false;
            if(!isParticallyValid(board, 0, 8, i, i)) return false;
        }
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (!isParticallyValid(board, i*3, i*3+2, j*3, j*3+2)) return false;
            }
        }
        
        return true;
    }
    
    private boolean isParticallyValid(char[][] board, int x1, int x2, int y1, int y2) {
        Set<Character> set = new HashSet<Character>();
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) return false;
                }
            }
        }
        return true;
    }
}
