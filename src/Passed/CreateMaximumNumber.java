package Passed;

public class CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[k];
        for(int i = 0; i <= k; i++) {
            if (i > nums1.length || k-i > nums2.length) continue;
            int[] maxSum1 = maxArray(nums1, i);
            int[] maxSum2 = maxArray(nums2, k-i);
            int[] temp = merge(maxSum1, maxSum2, k);
            if(isgreater(temp, 0, res, 0)) {
                res = temp;
            }
        }
        return res;
    }
    
    
    public int[] maxArray(int[] arr, int count) {
        int[] res = new int[count];
        if (count == 0) return res;
        int j = 0;
        int n = arr.length;
        
        for(int i = 0; i < arr.length; i++) {
            while(j > 0 && n-i-1 >= count-j && res[j-1] < arr[i]) {
                j--;
            }  
            if(j<count) {
                res[j] = arr[i];
                j++;
            }
        }
        return res;
    }
    
    public int[] merge(int[] arr1, int[] arr2, int k) {
        int[] res = new int[k];
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        if(len1 == 0) return arr2;
        if(len2 == 0) return arr1;
        
        int cur = 0, i = 0, j = 0;
        while(i < len1 && j < len2) {
            if (isgreater(arr1, i, arr2, j)) {
                res[cur++] = arr1[i++];
            } else {
                res[cur++] = arr2[j++];
            }
        }
        
        while(i < len1) {
            res[cur++] = arr1[i++];
        }
        
        while(j < len2) {
            res[cur++] = arr2[j++];
        }
        
        return res;
    }
    
    public boolean isgreater(int[] arr1, int i1, int[] arr2, int i2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        while(i1 < len1 && i2 < len2 && arr1[i1] == arr2[i2]) {
            i1++;
            i2++;
        }
        
        if(i1 == len1) return false;
        if(i2 == len2) return true;
        return arr1[i1] > arr2[i2];
    } 
}
