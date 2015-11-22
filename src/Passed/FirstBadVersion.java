package Passed;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
        if (!isBadVersion(n)) return -1;
        int start = 1;
        int end = n ;
        
        while (start < end - 1) {
// integer overflow 
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isBadVersion(start)) return start;
        if (isBadVersion(end)) return end;
        return -1;
        
    }
	
}
