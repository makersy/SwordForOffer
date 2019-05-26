/*
 * 题目描述
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * */


import java.util.*;
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
    //采用dfs思想，进行深度优先遍历，用一个list存储当前路径，另一个list存储满足条件的路径
    private ArrayList<Integer> list = new ArrayList();
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if( root == null ){
            return listAll;
        }
        list.add(root.val);  //将当前节点添加进当前路径
        target -= root.val;
        //这个判断的意思是：如果当前root节点是叶子节点，且当前list的路径和 = target
        if( target==0 && root.left==null && root.right==null ){
            //将当前路径添加。这里要new一个list，否则listAll存储的都是对list的引用
            //我们要的是存储的都是分配了内存的ArrayList数组
            listAll.add(new ArrayList<Integer>(list));
        }
        //否则的话就遍历左孩子和右孩子
        FindPath(root.left, target);
        FindPath(root.right, target);
        
        //遍历完当前root及其子节点之后回退节点，遍历其他路径
        list.remove(list.size()-1);
        //使用comparator，使数组长度大的靠前
        //listAll.sort( (ArrayList<Integer> a, ArrayList<Integer> b) -> 
       //              Integer.compare(b.size(), a.size()));
        return listAll;
    }
}
