package Passed;

public class FlipGameII {
	public boolean canWin(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
            	boolean res = canWin(s.substring(0,i) + "--" + s.substring(i+2));
            	if(!res) return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		boolean res = new FlipGameII().canWin("++++");
		return;		
	}
}
