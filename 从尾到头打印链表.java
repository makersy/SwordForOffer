/*
 题目描述
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

 */

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> a = new ArrayList();
        if( listNode==null ){
            return a;
        }
        fun(a, listNode);
        return a;
    }

    public void fun(ArrayList<Integer> a, ListNode node){
        if( node.next==null ){
            a.add(node.val);
            return;
        }
        fun(a, node.next);
        a.add(node.val);
    }
}
