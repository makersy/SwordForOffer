/*
题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if( pNode==null ) return pNode;
        //如果有右孩子，先转到右孩子，然后一直遍历左孩子到最后
        TreeLinkNode now = pNode;
        if( now.right!=null ){
            now = now.right;
            while( now.left!=null ){
                now = now.left;
            }
            return now;
        }
        //如果是其他，则看父节点，若父节点的左孩子是此节点，返回父节点；否则转到父节点的父节点，继续此判断
        while( now.next!=null ){
            if( now.next.left==now ){
                return now.next;
            }
            now = now.next;
        }
        //没有父节点，也没有右孩子，说明没有下一个中序节点了
        return null;
    }
}