/*
 * 题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if( pre.length!=in.length ) return null;
        return rebuild(pre, in, 0, pre.length-1, 0, in.length-1);
    }

    //递归，由前序序列找出头，然后在中序序列找出头结点左右两边的节点，一直递归直至is>ie
    public TreeNode rebuild(int[] pre, int[] in, int ps, int pe, int is, int ie){
        if( ps>pe ) return null;
        int index = is;
        int value = pre[ps];  //前序序列的第一个，相当于头结点
        //找到头结点，分割数组
        while( index<=ie && in[index]!=value ){
            index++;
        }
        TreeNode node = new TreeNode(value);
        //进行数组的左右分割，将node的左右孩子分别指向左右部分的头结点
        node.left = rebuild(pre, in, ps+1, ps+index-is, is, index-1);
        node.right = rebuild(pre, in, ps+index-is+1, pe, index+1, ie);
        return node;
    }
}
