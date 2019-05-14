/*
 * 题目描述
输入一个链表，反转链表后，输出新链表的表头。
 * */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    ListNode root = null;
    public ListNode ReverseList(ListNode head) {
        if( head==null ) return null;
        reverse(head);
        return root;
    }

    public ListNode reverse(ListNode node){
        if( node.next==null ){
            this.root = node;
            return node;
        }
        ListNode temp = reverse(node.next);
        temp.next = node;
        node.next = null;
        return node;
    }
}
