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
        //ȥ��ͷ����Ȳ���
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
                //βָ���������һ���ڵ�ֵ��ȣ���һֱ����βָ��ֱ������
                int temp = tail.val;
                while( tail!=null && tail.next!=null ){
                    if( tail.val!=temp ){
                        break;
                    }else{
                        tail = tail.next;
                    }
                }
                //��Ȼ���
                if( tail.val==temp ){
                    tail = null;
                }
                pre.next = tail;
            }
        }
        return root;
    }
}