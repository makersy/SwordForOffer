/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.*;
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if( pHead==null || pHead.next==null || pHead.next.next==null ) return null;
        ListNode fast = pHead.next.next, slow = pHead.next;
        while( fast!=slow ){
            if( fast.next!=null && fast.next.next!=null ){
                fast = fast.next.next;
                slow = slow.next;
            }else{
                return null;
            }
        }
        slow = pHead;
        while( slow!=fast ){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}