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

/*
题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/

public class Solution {
    
    //1. 先判断有没有右孩子，如果有，转到他的右孩子，然后一直遍历左孩子到最后一个，输出；
    //2. 没有右孩子，那么看父节点，如果父节点的左孩子是当前节点，那么输出父节点；否则继
    //   续遍历父节点的右孩子；
    //3. 没有右孩子也没有父节点，那么直接输出当前节点。
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if( pNode==null ) return null;
        
        if( pNode.right!=null ) {
            TreeLinkNode temp = pNode.right;
            while( temp.left!=null ){
                temp = temp.left;
            }
            return temp;
        }
        
        while( pNode.next!=null ){
            if( pNode.next.left == pNode ) return pNode.next;
            pNode = pNode.next;
        }
        
        return null;
    }
}
