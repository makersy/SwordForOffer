/*
 * 题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * */

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    //总体就是遍历所有的节点，复制next节点和random节点。注意的是每次都要new一个新的对象
    //新的链表中不可以持有对旧的链表的引用
    public RandomListNode Clone(RandomListNode pHead)
    {
        if( pHead == null ) return null;
        RandomListNode root = new RandomListNode(pHead.label);
        RandomListNode now = root;
        while( pHead.next != null ){
            RandomListNode temp = new RandomListNode(pHead.next.label);
            RandomListNode tempR = null;
            if( pHead.random != null ){
                tempR = new RandomListNode(pHead.random.label);
            }
            now.next = temp;
            now.random = tempR;
            pHead = pHead.next;
            now = now.next;
        }
        return root;
    }
}
