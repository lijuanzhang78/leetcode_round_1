package Passed;

import util.ListNode;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return MSort(lists, 0, lists.length - 1);
    }
    
    public ListNode MSort(ListNode[] lists, int low, int high) {
        if (low < high) {
            int mid = (low+high)/2;
            ListNode left = MSort(lists, low, mid);
            ListNode right = MSort(lists, mid+1, high);
            return merge(left, right);
        }
        return lists[low];
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
                 
        ListNode l3;
        if(l1.val<l2.val){
            l3 = l1;
            l1 = l1.next;
        }else{
            l3 = l2;
            l2 = l2.next;
        }
             
        ListNode fakehead = new ListNode(-1);
        fakehead.next = l3;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }
             
        if(l1!=null) l3.next = l1;
        if(l2!=null) l3.next = l2;
        return fakehead.next;
    }

}
