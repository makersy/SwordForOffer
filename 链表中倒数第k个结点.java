/*
 * 题目描述
输入一个链表，输出该链表中倒数第k个结点。
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
    public ListNode FindKthToTail(ListNode head,int k) {
        if( head==null ) return null;
        if( k<=0 ) return null;
        ListNode node1 = head, node2 = head;
	//这里需要用两个指针，一前一后
        //node1先走k步，随后2个一起走，等到node1到最后时，node2即是倒数第k个节点
        int cnt = 1;
        while( cnt<k ){
            if( node1.next==null ){
                //如果到了终点，说明总共就没有k个节点
                return null;
            }else{
                node1 = node1.next;
            }
            cnt++;
        }
        while( node1!=null ){
            if( node1.next==null ){
                break;
            }else{
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return node2;
    }

}
