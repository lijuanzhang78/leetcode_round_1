package Passed;

public class TwoSumInputSorted {
	public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        int left = 0;
        int right = numbers.length-1;
        
        while(left < right) {
            int x = numbers[left] + numbers[right];
            if(x > target) {
                right--;
            } else if (x < target) {
                left++;
            } else {
                // good useage new int[]
                return new int[]{left+1, right+1};
            }
        }
        return null;
    }

}
