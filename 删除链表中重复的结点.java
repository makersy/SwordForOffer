/*
 * 题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
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

    //新建2个指针，一个指向当前最大的非重复节点，另一个查找重复节点
    public ListNode deleteDuplication(ListNode pHead)
    {
        if( pHead == null || pHead.next==null ) return pHead;

        ListNode root = new ListNode(-1);
        root.next = pHead;

        ListNode pre = root, last = pre.next;
        while( last != null ){
            if( last.next!=null && last.val==last.next.val ){
                // 如果last指针发现存在重复节点，那么就一直往后遍历直到链表终点
                // 或者节点不重复
                while( last.next!=null && last.val==last.next.val ){
                    last = last.next;
                }
                pre.next = last.next;  //将不重复节点或者null赋给pre.next
                last = last.next;
            }else{
                //如果节点不重复就继续向后遍历
                pre = pre.next;
                last = last.next;
            }
        }
        return root.next;
    }
}
