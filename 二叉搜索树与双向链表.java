/*
 * 题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * */

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    //首先要走到最左边的节点（最左边节点就是最小的节点），然后进行中序遍历，在此过程中注意节点指针的改变

    private TreeNode head, root;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if( pRootOfTree==null ) return null;
        fun(pRootOfTree);
        return root;
    }

    private void fun(TreeNode node){
        if( node==null ) return;
        if( node.left != null ) fun(node.left);
        if( head==null ){  //当到达最左边的节点时，赋值给头结点
            head = node;
            root = node;
        } else {  //如果左边节点为null，或者已经遍历完左边部分，就把左边部分和当前节点拼接上
            head.right = node;
            node.left = head;
            head = head.right;
        }
        //拼接完成后，进行遍历右边部分的工作
        fun(node.right);
    }
}
