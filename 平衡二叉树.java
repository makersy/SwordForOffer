/*
 * 题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * */

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if( root==null ) return true;
        int hl = 1, hr = 1;
        if( Math.abs(getDepth(root.left, hl)-getDepth(root.right, hr)) > 1 ){
            return false;
        }else return true;
    }

    public int getDepth(TreeNode node, int h){
        if( node==null ) return h;
        h = Math.max(getDepth(node.left, h), getDepth(node.right, h));
        h++;
        return h;
    }
}
