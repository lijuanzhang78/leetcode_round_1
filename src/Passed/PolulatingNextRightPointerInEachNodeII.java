package Passed;

public class PolulatingNextRightPointerInEachNodeII {
	public void connect(TreeLinkNode root) {
        if (root == null) return; 
        
        TreeLinkNode lastHead = root;
        TreeLinkNode pre = null;
        TreeLinkNode currHead = null;
        TreeLinkNode lastCur = null;
        
        while(lastHead != null) {
            lastCur = lastHead;
            while(lastCur != null) {
                if (lastCur.left != null) {
                
                    if(currHead == null) {
                        currHead = lastCur.left;
                        pre = currHead;
                    } else {
                        pre.next = lastCur.left;
                        pre = pre.next;
                    }
                }
            
                if (lastCur.right != null) {
                
                    if(currHead == null) {
                        currHead = lastCur.right;
                        pre = currHead;
                    } else {
                        pre.next = lastCur.right;
                        pre = pre.next;
                    }
                }
                
                lastCur = lastCur.next;
            }
            lastHead = currHead;
            currHead = null;
        }
        

}
