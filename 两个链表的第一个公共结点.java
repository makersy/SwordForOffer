/*
 * 题目描述
输入两个链表，找出它们的第一个公共结点。
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
    //如果存在公共节点，那么两个链表必然有一部分尾部相同，我们需要让两个节点相对于终点的距离相等。
    //然后两个节点同时出发，直到找到公共节点为止。
    //要让相对于终点距离相等，那么就找到2个链表的长度差值，令长的一方从差值处开始。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        if( pHead1==null || pHead2==null ) return null;
        int len1 = getLen(pHead1), len2 = getLen(pHead2);
        if( len1>len2 ) {
            for( int i=0; i<(len1-len2); ++i ){
                p1 = p1.next;
            }
        }else{
            for( int i=0; i<(len2-len1); ++i ){
                p2 = p2.next;
            }
        }
        while( p1!=null && p2!=null && p1!=p2 ){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //获取链表长度
    public int getLen(ListNode node){
        int cnt = 0;
        while( node!=null ){
            cnt++;
            node = node.next;
        }
        return cnt;
    }
}
