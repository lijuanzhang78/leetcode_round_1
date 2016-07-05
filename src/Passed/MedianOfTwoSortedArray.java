package Passed;

public class MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        
        if (total % 2 != 0) {
            return (double) findKth(nums1, 0, m-1, nums2, 0, n-1, total/2 + 1);
        } else {
            double x = (double) findKth(nums1, 0, m-1, nums2, 0, n-1, total/2);
            double y = (double) findKth(nums1, 0, m-1, nums2, 0, n-1, total/2 + 1);
            return (x+y)/2;
        }
    }
    
    public int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;
        
        if (m > n) return findKth(nums2, start2, end2, nums1, start1, end1, k);
        if (m == 0) return nums2[k-1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        int part1 = Math.min(k/2, m);
        int part2 = k - part1;
        
        if(nums1[start1+part1-1] < nums2[start2+part2-1]) {
            return findKth(nums1, start1+part1, end1, nums2, start2, end2, k-part1);
        } else if (nums1[start1+part1-1] > nums2[start2+part2-1]) {
            return findKth(nums1, start1, end1, nums2, start2+part2, end2, k-part2);
        } else {
            return nums1[start1+part1-1];
        }
    }

}
