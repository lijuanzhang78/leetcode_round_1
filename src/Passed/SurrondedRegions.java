package Passed;

import java.util.LinkedList;
import java.util.Queue;

public class SurrondedRegions {

	// queue is built from linkedlist!
	 private Queue<Integer> queue = new LinkedList<Integer>();
	    
	    public void solve(char[][] board) {
	        if (board == null || board.length == 0) return;
	        int m = board.length;
	        int n = board[0].length;
	        
	        for(int i=0; i<m; i++) {
	            if (board[i][0] == 'O') {
	                bfs(board, i, 0);
	            }
	            if (board[i][n-1] == 'O') {
	                bfs(board, i, n-1);
	            }
	        }
	        
	        for(int j=0; j<n; j++) {
	            if (board[0][j] == 'O') {
	                bfs(board, 0, j);
	            }
	            
	            if(board[m-1][j] == 'O') {
	                bfs(board, m-1, j);
	            }
	        }
	        
	        for(int i=0; i<m; i++) {
	            for(int j=0; j<n; j++) {
	                if(board[i][j] == 'O') {
	                    board[i][j] = 'X';
	                } else if (board[i][j] == '#') {
	                    board[i][j] = 'O';
	                }
	            }
	        }
	    }
	    
	    void bfs(char[][] board, int i, int j) {
	        int n = board[0].length;
	        
	        fillCell(board, i, j);
	        
	        while(!queue.isEmpty()) {
	            int curr = queue.poll();
	            int x = curr/n;
	            int y = curr%n;
	            
	            // bfs started
	            fillCell(board, x-1, y);
	            fillCell(board, x+1, y);
	            fillCell(board, x, y-1);
	            fillCell(board, x, y+1);
	        }
	    }
	    
	    void fillCell(char[][] board, int i, int j) {
	        int m = board.length;
	        int n = board[0].length;
	        
	        // don't forget board[i][j] != 'O' !
	        if(i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O') {
	            return;
	        } else {
	            board[i][j] = '#';
	            queue.offer(i*n+j);
	        }
	    }
	    

}
