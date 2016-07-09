package Passed;

public class RangeSumQueryImmu {
	private static int[] sum;

    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        this.sum = nums;
    }

    public int sumRange(int i, int j) {
        return sum[j] - (i == 0? 0 : sum[i-1]);
    }
}
