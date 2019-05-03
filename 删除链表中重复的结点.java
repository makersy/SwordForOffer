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
    public ListNode deleteDuplication(ListNode pHead)
    {
        if( pHead==null || pHead.next==null ) return pHead;
        ListNode root = pHead;
        //去掉头部相等部分
        while( root!=null && root.next!=null && root.val==root.next.val ) {
            int temp = root.val;
            root = root.next;
            while( root.val==temp ){
                if( root.next != null ) root = root.next;
                else {
                    return null;
                }
            }
        }
        ListNode pre = root, tail = root.next;
        while( tail!=null && tail.next!=null ){
            if( tail.val!=tail.next.val ){
                pre = tail;
                tail = tail.next;
            }else {
                //尾指针和它的下一个节点值相等，就一直操作尾指针直到不等
                int temp = tail.val;
                while( tail!=null && tail.next!=null ){
                    if( tail.val!=temp ){
                        break;
                    }else{
                        tail = tail.next;
                    }
                }
                //仍然相等
                if( tail.val==temp ){
                    tail = null;
                }
                pre.next = tail;
            }
        }
        return root;
    }
}