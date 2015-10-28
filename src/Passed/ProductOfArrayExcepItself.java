package Passed;

public class ProductOfArrayExcepItself {
	public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int temp = 1;
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1)  { 
                temp = 1;
            }
            else {
                temp *= nums[i+1];    
            }
            
            output[i] *= temp;
            
        }
        
        return output;
        
    }

}
