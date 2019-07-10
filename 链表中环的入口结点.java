/*
 * 题目描述
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * */

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    //https://blog.csdn.net/sinat_35261315/article/details/79205157
    //采用快慢指针来做，先找到在环内快慢指针的相遇位置，然后慢指针从头开始、快指针在相遇位置开始
    //，二者以相同速度同时走，最终相遇位置就是环的入口

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if( pHead==null || pHead.next==null || pHead.next.next==null ) return null;
        ListNode slow = pHead.next, fast = pHead.next.next;  //防止修改了头结点
        while( slow != fast ){
            if( fast.next != null && fast.next.next != null ) {
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return null;
            }
        }
        slow = pHead;
        while( slow != fast ){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
