package Passed;

import java.util.LinkedList;

public class WallsAndGates {
	 public void wallsAndGates(int[][] rooms) {
	       if (rooms == null || rooms.length == 0) return;
	       LinkedList<int[]> list = new LinkedList<int[]>();
	       int m = rooms.length - 1, n = rooms[0].length - 1;
	       
	       for(int i=0; i<rooms.length; i++) {
	           for(int j=0; j<rooms[0].length; j++) {
	               if (rooms[i][j] == 0) {
	                   list.add(new int[]{i,j});
	               }
	           }
	       }
	       
	       while(!list.isEmpty()) {
	           int[] pop = list.remove();
	           int row = pop[0], col = pop[1];
	           
	           if(row - 1 >= 0 && rooms[row-1][col] == Integer.MAX_VALUE) {
	               list.add(new int[]{row - 1 , col});
	               rooms[row-1][col] = rooms[row][col] + 1;
	           }
	           
	            if(row + 1 <= m && rooms[row+1][col] == Integer.MAX_VALUE) {
	               list.add(new int[]{row + 1 , col});
	               rooms[row+1][col] = rooms[row][col] + 1;
	           }
	           
	           if(col + 1 <= n && rooms[row][col+1] == Integer.MAX_VALUE) {
	               list.add(new int[]{row , col+1});
	               rooms[row][col+1] = rooms[row][col] + 1;
	           }
	           
	           if(col - 1 >= 0 && rooms[row][col-1] == Integer.MAX_VALUE) {
	               list.add(new int[]{row , col-1});
	               rooms[row][col-1] = rooms[row][col] + 1;
	           }
	       }
	    }
}
