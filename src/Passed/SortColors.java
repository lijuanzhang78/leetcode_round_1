package Passed;

public class SortColors {
	  public void sortColors(int[] nums) {
	        int n = nums.length;
	         int second=n-1, zero=0;
	         for (int i=0; i<=second; i++) {
	                while (nums[i]==2 && i<second) swap(i, second--, nums);
	                while (nums[i]==0 && i>zero) swap(i, zero++, nums);
	         }
	    }
	    
	    public void swap(int i, int j, int[] nums) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp; 
	    }

}
