package Passed;

public class DesignTicTacToe {
	 private int[] rows;
	    private int[] cols;
	    private int diag;
	    private int antiDiag;

	    /** Initialize your data structure here. */
	    public TicTacToe(int n) {
	        rows = new int[n];
	        cols = new int[n];
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        int toAdd = player == 1? 1 : -1;
	        rows[row] += toAdd;
	        cols[col] += toAdd;
	        
	        int len = rows.length;
	        if (col == row) {
	            diag += toAdd;
	        } 
	        if (col + row == len - 1) {
	            antiDiag += toAdd;
	        }
	        
	        if (Math.abs(rows[row]) == len ||
	        Math.abs(cols[col]) == len ||
	        Math.abs(diag) == len  ||
	        Math.abs(antiDiag) == len)
	        {
	            return player;
	        }
	        
	        return 0;
	    }

}
